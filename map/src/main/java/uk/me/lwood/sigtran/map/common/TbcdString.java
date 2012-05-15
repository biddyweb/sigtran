package uk.me.lwood.sigtran.map.common;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author lukew
 */
public class TbcdString {
    private static final List<Character> NUMERIC_CHARS = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '*', '#', 'a', 'b', 'c');
    
    private final String numericString;
    
    public TbcdString(String numericString) {
        for (char c : numericString.toCharArray()) {
            if (!NUMERIC_CHARS.contains(c))
                throw new IllegalArgumentException("'" + c + "' is an invalid TBCD character");
        }
        
        this.numericString = numericString;
    }
    
    public String getNumericString() {
        return numericString;
    }
}
