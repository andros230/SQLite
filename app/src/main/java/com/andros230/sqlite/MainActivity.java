package com.andros230.sqlite;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBOpenHelper dbOpenHelper = new DBOpenHelper(this);
        dbOpenHelper.insert();
        dbOpenHelper.search();
    }
}
