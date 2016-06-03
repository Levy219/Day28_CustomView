package com.levy.day28_customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Levy on 2016/6/1.
 */
public class WuHuanView extends View{

    private Paint paint;
    private List<MyCircle> circleList;

    public WuHuanView(Context context){
        super(context);
        initCircle();
    }

    public WuHuanView(Context context, AttributeSet attrs){
        super(context, attrs);
        initCircle();
    }

    private void initCircle(){
        paint = new Paint();
        int x = getContext().getResources().getDisplayMetrics().widthPixels / 2;
        int r = getContext().getResources().getDisplayMetrics().widthPixels / 8;
        int y = x + 20;
        int d = r / 2;
        int sw = d / 2;
        circleList = new ArrayList<>();
        MyCircle blackCircle = new MyCircle(Color.BLACK, x, y, r, sw);
        MyCircle blueCircle = new MyCircle(Color.BLUE, x - 2 * r - d, y, r, sw);
        MyCircle redCircle = new MyCircle(Color.RED, x + 2 * r + d, y, r, sw);
        MyCircle yellowCircle = new MyCircle(Color.YELLOW, x - r - d / 2, y + r, r, sw);
        MyCircle greenCircle = new MyCircle(Color.GREEN, x + r + d / 2, y + r, r, sw);
        circleList.add(blackCircle);
        circleList.add(blueCircle);
        circleList.add(redCircle);
        circleList.add(yellowCircle);
        circleList.add(greenCircle);
    }

    private class MyCircle{
        int color;
        int cx, cy, cr;
        int strokeWidth;

        public MyCircle(int color, int cx, int cy, int cr, int strokeWidth){
            this.color = color;
            this.cx = cx;
            this.cy = cy;
            this.cr = cr;
            this.strokeWidth = strokeWidth;
        }
    }

    @Override
    protected void onDraw(Canvas canvas){
        paint.setStyle(Paint.Style.STROKE);
        for(int i = 0; i < circleList.size(); i++){
            MyCircle myCircle = circleList.get(i);
            paint.setColor(myCircle.color);
            paint.setStrokeWidth(myCircle.strokeWidth);
            canvas.drawCircle(myCircle.cx, myCircle.cy, myCircle.cr, paint);
        }
    }
}
