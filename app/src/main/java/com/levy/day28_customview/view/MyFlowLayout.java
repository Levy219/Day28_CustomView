package com.levy.day28_customview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Levy on 2016/6/1.
 */
public class MyFlowLayout extends ViewGroup{
    public MyFlowLayout(Context context){
        super(context);
    }

    public MyFlowLayout(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    //用于描述每一行
    private class LineView{
        //保存本行控件的集合
        List<View> childViews = new ArrayList<>();
        //本行控件的宽度和
        int lineSumWidth;
        //本行控件的高度。本行控件的高度等于最大控件的高度
        int lineMaxHeight;
    }

    //用于保存所有行的集合
    List<LineView> lineViews = new ArrayList<>();

    //用于测量,多次回调
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        //通知开始测量
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        LineView lineView = new LineView();
        //定义变量：统计所有行的宽度的最大值和所有行的高度和
        int MaxLineWidth;
        int LineHeightSum;
        //因为onMeasure会多次调用，避免重复加入控件行，一定要清空
        lineViews.clear();
        //测量子控件的宽高和边距
        for(int i = 0; i < getChildCount(); i++){

        }

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b){
    }


}
