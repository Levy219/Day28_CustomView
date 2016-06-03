package com.levy.day28_customview.view;

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
public class CustomProgressView extends View{

    private Paint paint;
    private int width;
    private int height;

    private int progress = 50;
    private int max = 100;

    public int getProgress(){
        return progress;
    }

    public void setProgress(int progress){
        this.progress = progress;
    }

    public int getMax(){
        return max;
    }

    public void setMax(int max){
        this.max = max;
    }

    public CustomProgressView(Context context){
        super(context);
        initPaint();
    }

    public CustomProgressView(Context context, AttributeSet attrs){
        super(context, attrs);
        initPaint();
    }

    private void initPaint(){
        paint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        width = widthMode == MeasureSpec.EXACTLY ? MeasureSpec.getSize(widthMeasureSpec) : 300;
        height = heightMode == MeasureSpec.EXACTLY ? MeasureSpec.getSize(heightMeasureSpec) : 300;
        width = height = width < height ? width : height;
        //测量完之后要把宽高值通知视图管理器
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas){
        //画灰色圆圈
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(width/2,height/2,width/2-4,paint);
        //画蓝色弧形
        paint.setColor(Color.BLUE);
        RectF rect = new RectF(4,4,width,height);
        canvas.drawArc(rect,90,progress,false,paint);
    }
}
