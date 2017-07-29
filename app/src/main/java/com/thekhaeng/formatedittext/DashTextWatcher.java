package com.thekhaeng.formatedittext;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class DashTextWatcher implements TextWatcher{
    private final String format;
    private EditText edt;
    private String strAfter;
    private String strBefore;
    private int selectionIndex;
    private int maxLength;

    public DashTextWatcher( EditText edt, String format ){
        this.format = format;
        this.edt = edt;
        maxLength = format.replace( FormatUtility.SEPARATE, "" ).length();
    }

    @Override
    public void beforeTextChanged( CharSequence s, int start, int count, int after ){
        strBefore = s.toString();
    }

    @Override
    public void onTextChanged( CharSequence charSequence, int i, int i1, int i2 ){

    }

    @Override
    public void afterTextChanged( Editable s ){
        edt.removeTextChangedListener( this );
        String str = s.toString();
        if( !str.equals( "" ) ){
            selectionIndex = edt.getSelectionStart();
            strAfter = str;
            String strResult;
            int s1 = strAfter.length();
            strAfter = strAfter.replaceAll( FormatUtility.SEPARATE, "" );
            strAfter = strAfter.length() > maxLength ? strBefore : strAfter;

            String currentFormat = getCurrentFormat( strAfter.toCharArray() );

            strResult = FormatUtility.applyStringPattern( strAfter, currentFormat );
            int s2 = strResult.length();

            selectionIndex = ( s2 > s1 ) ? selectionIndex + ( s2 - s1 ) : selectionIndex - ( s1 - s2 );
            s.clear();
            s.append( strResult );
            // edt.setText( strResult ); Don't do this!!!
            try{
                edt.setSelection( selectionIndex );
            }catch( IndexOutOfBoundsException e ){
                edt.setSelection( 0 );
            }

        }
        edt.addTextChangedListener( this );
    }

    private String getCurrentFormat( char[] afterChar ){
        StringBuilder currentFormat = new StringBuilder();
        int dashCount = 0;
        for( int i = 0; i < afterChar.length; i++ ){
            if( i + dashCount < format.length() ){
                if( format.toCharArray()[i + dashCount] == FormatUtility.SEPARATE.charAt( 0 ) ){
                    currentFormat.append(format.toCharArray()[i + dashCount]);
                    currentFormat.append("#");
                    dashCount += 1;
                }else{
                    currentFormat.append(format.toCharArray()[i + dashCount]);
                }
            }

        }
        return currentFormat.toString();
    }
}


