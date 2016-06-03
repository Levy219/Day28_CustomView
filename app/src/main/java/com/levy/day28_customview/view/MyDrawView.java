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
public class MyDrawView extends View{

    private Paint paint;

    public MyDrawView(Context context){
        super(context);
        initPaint();
    }

    public MyDrawView(Context context, AttributeSet attrs){
        super(context, attrs);
        initPaint();
    }

    private void initPaint(){
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        //用于指定是否使用抗锯齿功能，如果使用会使绘图速度变慢
        paint.setAntiAlias(true);
        //用于指定是否使用图像抖动处理，如果使用会使图像颜色更加平滑和饱满，更加清晰
        paint.setDither(true);
        //用于设置填充风格
        paint.setStyle(Paint.Style.STROKE);
        //用于当画笔的填充样式为STROKE或FILL_AND_STROKE时，设置笔刷的图形样式,主要体现在线的端点上
       paint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas){
        //画多条线，每4组代表一条线
        float[] pts = {0,0,300,500,0,0,0,500,0,500,300,500};
        canvas.drawLines(pts,paint);
        //画圆
        canvas.drawCircle(500,300,150,paint);
        //画椭圆
        RectF oval = new RectF(40,20,80,40);
        canvas.drawOval(oval,paint);
        //画圆角矩形
        RectF rect = new RectF(160,80,320,160);
        canvas.drawRect(rect,paint);
    }
}
