package com.example.wanandroid.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {

    private List<List<View>> mListViews = new ArrayList<>();
    private List<Integer> mHeights = new ArrayList<>();

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        int width = 0;//容器的宽度
        int height = 0;
        int lineWidth = 0;//当前行的宽度
        int lineHeight = 0;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++){
            View child = getChildAt(i);
            //测量
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams mlp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getWidth() + mlp.leftMargin + mlp.rightMargin;
            int childHeight = child.getHeight() + mlp.topMargin + mlp.bottomMargin;
            if (lineWidth + childWidth > sizeWidth){//换行
                width = Math.max(width, lineWidth);
                height += lineHeight;
                lineWidth = childWidth;
                lineHeight = childHeight;
            }else {
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
            }
            //最后一个控件
            if (i == childCount - 1){
                width = Math.max(width, lineWidth);
                height += lineHeight;
            }
        }
        setMeasuredDimension(modeWidth == MeasureSpec.EXACTLY ? sizeWidth:width,
                modeHeight == MeasureSpec.EXACTLY ? sizeHeight:height);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mListViews.clear();
        mHeights.clear();

        int width = getWidth();//容器宽度
        int lineWidth = 0;
        int lineHeight = 0;
        List<View> mList = new ArrayList<>();
        int count = getChildCount();
        for (int i = 0; i < count; i++){
            View child = getChildAt(i);
            ViewGroup.MarginLayoutParams mlp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getWidth() + mlp.leftMargin + mlp.rightMargin;
            int childHeight = child.getHeight() + mlp.topMargin + mlp.bottomMargin;
            if (childWidth + lineWidth > width){//换行
                //这一行所有子控件加进集合
                mListViews.add(mList);
                mHeights.add(lineHeight);
                lineWidth = 0;
                lineHeight = 0;
                mList = new ArrayList<>();
            }
                mList.add(child);
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
        }
        //最后一行
        mListViews.add(mList);
        mHeights.add(lineHeight);

        //排列
        int left = 0;
        int top = 0;
        for (int i = 0; i < mListViews.size(); i++){//循环每一行
            mList = mListViews.get(i);
            lineHeight = mHeights.get(i);
            for (int j = 0; j < mList.size(); j++){//循环每行的每个子控件
                View child = mList.get(j);
                MarginLayoutParams mlp = (MarginLayoutParams) child.getLayoutParams();
                int lc = left + mlp.leftMargin;
                int tc = top + mlp.topMargin;
                int rc = lc + child.getMeasuredWidth();
                int bc = tc + child.getMeasuredHeight();
                child.layout(lc, tc, rc, bc);
                left += child.getMeasuredWidth() + mlp.leftMargin + mlp.rightMargin;
            }
            left = 0;
            top += lineHeight;
        }
    }
}
