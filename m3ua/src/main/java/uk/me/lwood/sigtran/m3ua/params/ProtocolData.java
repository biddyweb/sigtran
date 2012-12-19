package uk.me.lwood.sigtran.m3ua.params;

import io.netty.buffer.ByteBuf;

/**
 * 
 * @author lukew
 */
public class ProtocolData extends M3uaParameter {
    private final ByteBuf data;
    private final int opc;
    private final int dpc;
    private final int serviceIndicator;
    private final int networkIndicator;
    private final int priority;
    private final int sls;
    
    public ProtocolData(int opc, int dpc, int serviceIndicator, int networkIndicator, int priority, int sls, ByteBuf data) {
        super(M3uaTag.PROTOCOL_DATA);
        
        this.data = data;
        this.opc = opc;
        this.dpc = dpc;
        this.serviceIndicator = serviceIndicator;
        this.networkIndicator = networkIndicator;
        this.priority = priority;
        this.sls = sls;
    }
    
    @Override
    public int getLength() {
        return 96 + data.readableBytes();
    }
    
    @Override
    public void writeTo(ByteBuf buf) {
        buf.writeInt(opc);
        buf.writeInt(dpc);
        buf.writeByte(serviceIndicator);
        buf.writeByte(networkIndicator);
        buf.writeByte(priority);
        buf.writeByte(sls);
        buf.writeBytes(data);
    }
}
