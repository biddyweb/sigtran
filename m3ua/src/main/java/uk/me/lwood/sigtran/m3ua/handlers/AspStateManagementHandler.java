package uk.me.lwood.sigtran.m3ua.handlers;

import static uk.me.lwood.sigtran.m3ua.M3uaMessageType.*;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import uk.me.lwood.sigtran.m3ua.M3uaMessage;
import uk.me.lwood.sigtran.m3ua.params.DefaultM3uaTag;
import uk.me.lwood.sigtran.m3ua.params.IntegerM3uaParameter;

/**
 * 
 * @author lukew
 */
public class AspStateManagementHandler extends ChannelInboundMessageHandlerAdapter<M3uaMessage> {
    private static final AttributeKey<ScheduledFuture<?>> FUTURE_KEY = new AttributeKey<ScheduledFuture<?>>("timeoutFuture");
    
    private static enum State {
        ACTIVE,
        INACTIVE,
        DOWN
    }
    
    private final Integer aspId;
    private final long expireTimeout;
    
    private State state = State.DOWN;
    
    public AspStateManagementHandler(Integer aspId, long expireTimeout) {
        this.aspId = aspId;
        this.expireTimeout = expireTimeout;
    }
    
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        state = State.DOWN;
        // Sctp association has been made, so we need to send an ASP UP
        M3uaMessage aspUp = new M3uaMessage(1, ASPUP.getMessageClass(), ASPUP);
        if (aspUp != null) {
            aspUp.addParameter(new IntegerM3uaParameter(DefaultM3uaTag.ASP_IDENTIFIER, aspId));
        }
        scheduleTimeoutAndSend(ctx, aspUp, expireTimeout);
    }
    
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        state = State.DOWN;
        
        removeTimeout(ctx);
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, M3uaMessage msg) {
        if (msg.getMessageType() == ASPUP_ACK) {
            if (state == State.DOWN) {
                state = State.INACTIVE;
                removeTimeout(ctx);
                
                M3uaMessage aspAc = new M3uaMessage(1, ASPAC.getMessageClass(), ASPAC);
                // XXX: set appropriate config?
                scheduleTimeoutAndSend(ctx, aspAc, expireTimeout);
            }
        }
        else if (msg.getMessageType() == ASPAC_ACK) {
            if (state == State.INACTIVE) {
                removeTimeout(ctx);
                state = State.ACTIVE;
                ctx.fireChannelActive();
            }
        }
        else if (msg.getMessageType() == ASPDN) {
            removeTimeout(ctx);
            
            state = State.DOWN;
            
            M3uaMessage aspDnAck = new M3uaMessage(1, ASPDN_ACK.getMessageClass(), ASPDN_ACK);
            ctx.channel().write(aspDnAck);
            
            M3uaMessage aspUp = new M3uaMessage(1, ASPUP.getMessageClass(), ASPUP);
            if (aspUp != null) {
                aspUp.addParameter(new IntegerM3uaParameter(DefaultM3uaTag.ASP_IDENTIFIER, aspId));
            }
            
            scheduleTimeout(ctx, aspUp, expireTimeout);
        }
        else if (msg.getMessageType() == ASPIA) {
            if (state == State.ACTIVE) {
                removeTimeout(ctx);
                ctx.fireChannelInactive();
                
                state = State.INACTIVE;
                M3uaMessage aspAc = new M3uaMessage(1, ASPAC.getMessageClass(), ASPAC);
                scheduleTimeoutAndSend(ctx, aspAc, expireTimeout);
            }
        }
    }
    
    private static void removeTimeout(ChannelHandlerContext ctx) {
        Attribute<ScheduledFuture<?>> f = ctx.attr(FUTURE_KEY);
        if (f.get() != null) {
            f.get().cancel(true);
            f.remove();
        }
    }

    private static void scheduleTimeoutAndSend(ChannelHandlerContext ctx, M3uaMessage aspUp, long timeout) {
        scheduleTimeout(ctx, aspUp, timeout);
        ctx.channel().write(aspUp);
    }
    
    private static void scheduleTimeout(ChannelHandlerContext ctx, M3uaMessage aspUp, long timeout) {
        ScheduledFuture<?> f = ctx.executor().schedule(new AspUpExpireTimeout(ctx, aspUp, timeout), timeout, TimeUnit.MILLISECONDS);
        ctx.attr(FUTURE_KEY).set(f);
    }

    private static final class AspUpExpireTimeout implements Runnable {
        private final ChannelHandlerContext ctx;
        private final M3uaMessage aspUp;
        private final long timeout;
        
        public AspUpExpireTimeout(ChannelHandlerContext ctx, M3uaMessage aspUp, long timeout) {
            this.ctx = ctx;
            this.aspUp = aspUp;
            this.timeout = timeout;
        }

        @Override
        public void run() {
            scheduleTimeoutAndSend(ctx, aspUp, timeout);
        }
    }
}
