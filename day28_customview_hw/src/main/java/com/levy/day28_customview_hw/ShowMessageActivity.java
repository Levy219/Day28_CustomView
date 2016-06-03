package com.levy.day28_customview_hw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.levy.day28_customview_hw.customview.ShowMessageView;

public class ShowMessageActivity extends AppCompatActivity implements View.OnClickListener{

    private ShowMessageView showMsgView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);
        showMsgView = (ShowMessageView) findViewById(R.id.showMsgView);
        findViewById(R.id.addMsg_btn).setOnClickListener(this);
        findViewById(R.id.reduceMsg_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.addMsg_btn:
                showMsgView.addMsg();
                break;
            case R.id.reduceMsg_btn:
                showMsgView.reduceMsg();
                break;
        }
    }
}
