package com.thekhaeng.formatedittext;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.util.AttributeSet;

public class FormatEditText extends AppCompatEditText{


    public FormatEditText( Context context ){
        super( context );
    }

    public FormatEditText( Context context, AttributeSet attrs ){
        super( context, attrs );
    }

    public FormatEditText( Context context, AttributeSet attrs, int defStyleAttr ){
        super( context, attrs, defStyleAttr );
    }


    public void setDashFormat( String format ){
        if( format != null ){
            addTextChangedListener( new DashTextWatcher( this, format ) );
            KeyListener keyListener = DigitsKeyListener.getInstance( "0123456789" + FormatUtility.SEPARATE );
            setKeyListener( keyListener );
        }
    }
}
