package com.levy.day28_customview_hw.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.levy.day28_customview_hw.R;

/**
 * Created by Levy on 2016/6/1.
 */
public class ShowMessageView extends View{

    private Paint paint;
    private Bitmap bitmap;
    private int width;
    private int msgCount = 0;

    public ShowMessageView(Context context){
        super(context);
        init();
    }

    public ShowMessageView(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setStrokeWidth(1);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.message_select);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        width =bitmap.getWidth();
        int height = bitmap.getHeight();
        setMeasuredDimension(width,height);
    }

    public void addMsg(){
        msgCount++;
    }

    public void reduceMsg(){
        msgCount--;
        if(msgCount < 0){
            msgCount = 0;
        }
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawBitmap(bitmap, 0, 50, null);
        if(msgCount > 0){
            //画红色提示圆
            paint.setColor(Color.RED);
            canvas.drawCircle(width - 50, 100, 50, paint);
            //画白色提示信息数
            paint.setStrokeWidth(3);
            paint.setColor(Color.WHITE);
            paint.setTextSize(50);
            paint.setTextAlign(Paint.Align.LEFT);
            if(msgCount > 99){
                canvas.drawText("99+", width - 90, 115, paint);
            }else if(msgCount >= 10){
                canvas.drawText(msgCount + "", width - 80, 115, paint);
            }else{
                canvas.drawText(msgCount + "", width - 60, 115, paint);
            }
        }
        invalidate();
    }
}

