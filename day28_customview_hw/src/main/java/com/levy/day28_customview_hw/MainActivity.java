package com.levy.day28_customview_hw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.controlsView_btn).setOnClickListener(this);
        findViewById(R.id.drawIcon_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.drawIcon_btn:
                Intent intent = new Intent(this, DrawAndroidIconActivity.class);
                startActivity(intent);
                break;
            case R.id.controlsView_btn:
                Intent intent1 = new Intent(this, ShowMessageActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
