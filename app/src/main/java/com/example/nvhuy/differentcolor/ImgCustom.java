package com.example.nvhuy.differentcolor;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class ImgCustom extends androidx.appcompat.widget.AppCompatImageView {
    public ImgCustom(Context context) {
        super(context);
    }

    public ImgCustom(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImgCustom(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);



    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int a = getMeasuredWidth();
        setMeasuredDimension(a,a);
    }
}
