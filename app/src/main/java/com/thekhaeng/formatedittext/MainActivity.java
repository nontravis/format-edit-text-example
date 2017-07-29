package com.thekhaeng.formatedittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate( Bundle savedInstanceState ){
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        FormatEditText edt = findViewById( R.id.edt );
        edt.setDashFormat( FormatUtility.DEFAULT_TEXT_FORMAT );
    }

}
