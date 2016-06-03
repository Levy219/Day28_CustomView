package com.levy.day28_customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.levy.day28_customview.R;

/**
 * Created by Levy on 2016/6/1.
 */
public class SlideButtonView extends View{

    private int slideBtnWidth;
    private float customX;
    private int bgOffWidth;
    private int bgOffHeight;
    private Bitmap bgOff;
    private Bitmap bgOn;
    private Bitmap slideBtn;
    private OnSlideStateChangedListener listener;
    private boolean state;

    public SlideButtonView(Context context){
        super(context);
        init();
    }

    public SlideButtonView(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    public void setOnSlideStateChangedListener(OnSlideStateChangedListener listener){
        this.listener = listener;
    }

    public interface OnSlideStateChangedListener{
        void onStateChanged(boolean on);
    }

    private void init(){
        bgOff = BitmapFactory.decodeResource(getResources(), R.mipmap.slide_bg_off);
        bgOn = BitmapFactory.decodeResource(getResources(), R.mipmap.slide_bg_on);
        slideBtn = BitmapFactory.decodeResource(getResources(), R.mipmap.slide_btn);
        //获得背景位图的宽高
        bgOffWidth = bgOff.getWidth();
        bgOffHeight = bgOff.getHeight();
        //滑块的宽
        slideBtnWidth = slideBtn.getWidth();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        //不想让使用者去修改控件的大小
        //直接用底图的宽高作为控件的宽高
        setMeasuredDimension(bgOffWidth, bgOffHeight);
    }

    @Override
    protected void onDraw(Canvas canvas){
        if(customX < bgOffWidth / 2){
            canvas.drawBitmap(bgOff, 0, 0, null);
        }else{
            canvas.drawBitmap(bgOn, 0, 0, null);
        }
        //currentX用于代表圆心的x坐标
        if(customX < slideBtnWidth / 2){
            customX = slideBtnWidth / 2;
        }
        if(customX > bgOffWidth - slideBtnWidth / 2){
            customX = bgOffWidth - slideBtnWidth / 2;
        }
        canvas.drawBitmap(slideBtn, customX - slideBtnWidth / 2, 0, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        customX = event.getX();
        //当手指离开的时候，判断离开的点在靠右还是靠左
        if(event.getAction() == MotionEvent.ACTION_UP){
            if(customX>bgOffWidth/2){
                customX = bgOffWidth;
                state = true;
            }else{
                customX = 0;
                state = false;
            }
            if(listener!=null){
                listener.onStateChanged(state);
            }
        }
        //通知尽快重新绘图
        invalidate();
        return true;
    }


}
