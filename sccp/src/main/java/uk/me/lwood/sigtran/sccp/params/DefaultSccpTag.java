package uk.me.lwood.sigtran.sccp.params;

/**
 * 
 * @author lukew
 */
public enum DefaultSccpTag implements SccpTag {
    DESTINATION_LOCAL_REFERENCE(1),
    SOURCE_LOCAL_REFERENCE(2),
    CALLED_PARTY_ADDRESS(3),
    CALLING_PARTY_ADDRESS(4),
    PROTOCOL_CLASS(5),
    SEGMENTING(6),
    RECEIVE_SEQUENCE(7),
    SEQUENCING(8),
    CREDIT(9),
    RELEASE_CAUSE(10),
    RETURN_CAUSE(11),
    RESET_CAUSE(12),
    ERROR_CAUSE(13),
    REFUSAL_CAUSE(14),
    DATA(15),
    SEGMENTATION(16),
    HOP_COUNTER(17),
    IMPORTANCE(18),
    LONG_DATA(19);

    private final byte id;
    
    private DefaultSccpTag(int id) {
        this.id = (byte) id;
    }
    
    @Override
    public byte getId() {
        return id;
    }
}
