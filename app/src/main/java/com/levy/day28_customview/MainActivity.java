package com.levy.day28_customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.flow_btn).setOnClickListener(this);
        findViewById(R.id.paint_btn).setOnClickListener(this);
        findViewById(R.id.wuhuan_btn).setOnClickListener(this);
        findViewById(R.id.progress_btn).setOnClickListener(this);
        findViewById(R.id.slideButton_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.flow_btn:
                break;
            case R.id.paint_btn:
                Intent intent1 = new Intent(this,DrawActivity.class);
                startActivity(intent1);
                break;
            case R.id.wuhuan_btn:
                Intent intent2 = new Intent(this,WuHuanActivity.class);
                startActivity(intent2);
                break;
            case R.id.progress_btn:
                Intent intent3 = new Intent(this,ProgressActivity.class);
                startActivity(intent3);
                break;
            case R.id.slideButton_btn:
                Intent intent4 = new Intent(this,SlideButtonActivity.class);
                startActivity(intent4);
                break;
        }
    }
}
