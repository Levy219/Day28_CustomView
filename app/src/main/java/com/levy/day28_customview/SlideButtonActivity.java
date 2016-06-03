package com.levy.day28_customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.levy.day28_customview.view.SlideButtonView;

public class SlideButtonActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_button);
        SlideButtonView slideButtonView = (SlideButtonView) findViewById(R.id.slidebtn_view);
        slideButtonView.setOnSlideStateChangedListener(new SlideButtonView.OnSlideStateChangedListener(){
            @Override
            public void onStateChanged(boolean on){
                if(on){
                    Toast.makeText(SlideButtonActivity.this, "开", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SlideButtonActivity.this, "关", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
