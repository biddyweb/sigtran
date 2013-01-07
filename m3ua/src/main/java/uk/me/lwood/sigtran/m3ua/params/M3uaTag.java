package uk.me.lwood.sigtran.m3ua.params;

/**
 * Marker interface for the basic tags vs any extension tags
 * 
 * @author lukew
 */
public interface M3uaTag {
    public short getId();
    public M3uaParameterFactory getFactory();
}
