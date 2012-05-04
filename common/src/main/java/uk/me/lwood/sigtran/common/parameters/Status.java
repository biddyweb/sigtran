// $Id$
// Copyright 2012 MX Telecom Ltd
package uk.me.lwood.sigtran.common.parameters;

import io.netty.buffer.ChannelBuffer;
import io.netty.buffer.ChannelBuffers;

/**
 * 
 * @author lukew
 */
public class Status implements CommonParameter {
    public static final int TYPE_AS_STATE_CHANGE = 1;
    public static final int TYPE_OTHER = 2;
    
    public static final int INFO_AS_INACTIVE = 2;
    public static final int INFO_AS_ACTIVE = 3;
    public static final int INFO_AS_PENDING = 4;
    
    public static final int INFO_INSUFFICIENT_RESOURCES = 1;
    public static final int INFO_ALTERNATE_ASP_ACTIVE = 2;
    public static final int INFO_ASP_FAILURE = 3;
    
    private final int statusType;
    private final int statusInfo;
    
    public Status(int statusType, int statusInfo) {
        this.statusType = statusType;
        this.statusInfo = statusInfo;
    }

    @Override
    public int getTag() {
        return 0xD;
    }

    @Override
    public ChannelBuffer asChannelBuffer() {
        return ChannelBuffers.wrapShort(statusType, statusInfo);
    }

}
