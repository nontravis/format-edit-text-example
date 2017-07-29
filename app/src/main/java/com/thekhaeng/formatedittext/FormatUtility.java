package com.thekhaeng.formatedittext;

/**
 * Created by thekhaeng on 7/29/2017 AD.
 */

public class FormatUtility{
    public static final String SEPARATE = "-";
    public static final String DEFAULT_TEXT_FORMAT = "###-####-####";

    public static String applyStringPattern( String text, String format ){
        StringBuilder pattern = new StringBuilder(); // ex. pattern "(\\d{3})(\\d{3})(\\d+)"
        StringBuilder replacement = new StringBuilder(); // ex. replacement "$1-$2-$3"
        String[] formats = format.split( SEPARATE );
        for( int i = 0; i < formats.length; i++ ){
            pattern.append( "(\\d{" ).append( formats[i].length() ).append( "})" );
            if( i == 0 ){
                replacement.append( "$" ).append( i + 1 );
            }else{
                replacement.append( SEPARATE + "$" ).append( i + 1 );
            }
        }
        return text.replaceFirst( pattern.toString(), replacement.toString() );
    }
}
