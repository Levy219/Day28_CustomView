package com.levy.day28_customview_hw.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Levy on 2016/6/1.
 */
public class DrawAndroidIconView extends View{

    private Paint paint;
    private int width;
    private int height;

    public DrawAndroidIconView(Context context){
        super(context);
        initPaint();
    }

    public DrawAndroidIconView(Context context, AttributeSet attrs){
        super(context, attrs);
        initPaint();
    }

    private void initPaint(){
        paint = new Paint();
        //用于指定是否使用图像抖动处理
        paint.setDither(true);
        //用于指定是否使用抗锯齿功能
        paint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        width = 400;
        height = 400;
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas){
        paint.setColor(Color.GREEN);
        //画上半圆弧
        RectF oval = new RectF(0, height / 6, width, 7 * height / 6);
        canvas.drawArc(oval, 0, -180, false, paint);
        //画下圆角矩形
        RectF rect = new RectF(0, 2 * height / 3, width, height);
        canvas.drawRoundRect(rect, 15, 15, paint);
        //画两条天线
        paint.setStrokeCap(Paint.Cap.ROUND);
        //用于设置画笔转弯处的连接风格
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(width / 16);
        canvas.drawLine(width/6,20,width/2,2*height/3,paint);
        canvas.drawLine(5*width/6,20,width/2,2*height/3,paint);
//        float[] pts = {width / 6, 10, width / 2, 2 * height / 3, width / 2, 2 * height / 3, 5 * width / 6, 10};
//        canvas.drawLines(pts, paint);
        //画两个眼睛
        paint.setColor(Color.WHITE);
        canvas.drawCircle(width/4, 5*height/12, width/16, paint);
        canvas.drawCircle(3*width/4, 5*height/12, width/16, paint);
        //画分割线
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setColor(0xff7BA651);
        paint.setStrokeWidth(10);
        canvas.drawLine(0, 2*height/3, width, 2*height/3, paint);
    }
}
