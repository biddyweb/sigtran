package uk.me.lwood.sigtran.m3ua.params;

/**
 * 
 * @author lukew
 */
public class UnspecifiedM3uaTag implements M3uaTag {
    private short id;
    
    public UnspecifiedM3uaTag(short id) {
        this.id = id;
    }

    @Override
    public short getId() {
        return id;
    }

    @Override
    public M3uaParameterFactory getFactory() {
        return M3uaParameterFactory.BYTEBUF;
    }

}
