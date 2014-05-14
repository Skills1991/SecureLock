package com.prostofm.app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Shell extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shell);

        findViewById(R.id.btnShowLog).setOnClickListener(this);
        findViewById(R.id.btnStartScan).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent myIntent;
        switch (v.getId()) {
            case R.id.btnStartScan:

                myIntent = new Intent(Shell.this, PageActivity.class);

                Shell.this.startActivity(myIntent);
                break;
            case R.id.btnShowLog:
                myIntent = new Intent(Shell.this, DescActivity.class);
                Shell.this.startActivity(myIntent);
                break;
            default:
                break;
        }
    }
}
