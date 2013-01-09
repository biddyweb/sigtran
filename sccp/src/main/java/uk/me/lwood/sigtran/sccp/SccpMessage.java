package uk.me.lwood.sigtran.sccp;

import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

import uk.me.lwood.sigtran.common.ByteBufWritable;
import uk.me.lwood.sigtran.sccp.params.SccpParameter;

/**
 * 
 * @author lukew
 */
public class SccpMessage implements ByteBufWritable {
    
    private final SccpMessageType type;
    private final List<SccpParameter> mandatoryFixed = new ArrayList<SccpParameter>();
    private final List<SccpParameter> mandatoryVariable = new ArrayList<SccpParameter>();
    private final List<SccpParameter> optional = new ArrayList<SccpParameter>();
    
    public SccpMessage(SccpMessageType type) {
        this.type = type;
    }
    
    public SccpMessageType getType() {
        return type;
    }
    
    public void addMandatoryFixedParam(SccpParameter param) {
        mandatoryFixed.add(param);
    }
    
    public void addMandatoryVariableParam(SccpParameter param) {
        mandatoryVariable.add(param);
    }
    
    public void addOptionalParam(SccpParameter param) {
        optional.add(param);
    }

    @Override
    public int getLength() {
        int length = 0;
        for (SccpParameter param : mandatoryFixed) {
            length += param.getLength();
        }
        length += mandatoryVariable.size();
        for (SccpParameter param : mandatoryVariable) {
            length += param.getLength();
        }
        for (SccpParameter param : optional) {
            length += 2 + param.getLength();
        }
        if (!optional.isEmpty()) {
            length += 1;
        }
        
        return length;
    }

    @Override
    public void writeTo(ByteBuf buf) {
        buf.writeByte(type.getCode());
        for (SccpParameter param : mandatoryFixed) {
            param.writeTo(buf);
        }
        int mandatoryVariableLength = 0;
        int currentIndex = 0;
        for (SccpParameter param : mandatoryVariable) {
            buf.writeByte(mandatoryVariable.size() - currentIndex + mandatoryVariableLength);
            mandatoryVariableLength += param.getLength();
            currentIndex++;
        }
        buf.writeByte(mandatoryVariableLength);
        for (SccpParameter param : mandatoryVariable) {
            buf.writeByte(param.getLength());
            param.writeTo(buf);
        }
        for (SccpParameter param : optional) {
            buf.writeByte(param.getTag().getId());
            buf.writeByte(param.getLength());
            param.writeTo(buf);
        }
        if (!optional.isEmpty()) {
            buf.writeZero(1);
        }
    }
}
