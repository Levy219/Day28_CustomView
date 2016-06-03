package com.levy.day28_customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

import com.levy.day28_customview.view.CustomProgressView;

public class ProgressActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    private CustomProgressView porgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        porgressView = (CustomProgressView) findViewById(R.id.custom_progress);
       SeekBar seekBar = (SeekBar) findViewById(R.id.seekProgress);
        seekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar){
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar){
    }
}
