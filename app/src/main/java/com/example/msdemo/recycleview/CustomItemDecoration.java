package com.example.msdemo.recycleview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.example.msdemo.R;

public class CustomItemDecoration extends RecyclerView.ItemDecoration {
    /**
     * 自定义默认的Item的边距
     */
    private int mPageMargin = 10;//dp
    /**
     * 第一个item的左边距
     */
    private int mLeftPageVisibleWidth;

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        //计算一下第一个item距离屏幕左边的距离：(屏幕的宽度-item的宽度)/2。其中item的宽度=实际ImagView的宽度+margin。
        //如果每个item都是相等的宽度，计算一次就好了，否则，是需要每次都计算的
        ImageView imageview = (ImageView) view.findViewById(R.id.item_avatar);
        //measure方法的参数值都设为0即可
        imageview.measure(0, 0);
        //获取组件宽度
        int width = imageview.getMeasuredWidth() + dpToPx(30);
        //获取实际居左距离
        int swidth = (getScreenWidth(view.getContext())) / 2 - (width) / 2;
//            mLeftPageVisibleWidth = CommonUtil.convertPixelsToDp(view.getContext(),swidth);
        mLeftPageVisibleWidth = swidth;//px
//        }

        //获取当前Item的position
        int position = parent.getChildAdapterPosition(view);
        //获得Item的数量
        int itemCount = parent.getAdapter().getItemCount();
        int leftMagin = 0;
        int rightMagin = 0;
        if (position == 0) {
            if (mLeftPageVisibleWidth < dpToPx(mPageMargin)) {
                leftMagin = mLeftPageVisibleWidth;
                rightMagin = mLeftPageVisibleWidth;
            } else {
                leftMagin = mLeftPageVisibleWidth;
                rightMagin = dpToPx(mPageMargin);
            }
        } else if (position == itemCount - 1) {
            if (mLeftPageVisibleWidth < dpToPx(mPageMargin)) {
                rightMagin = mLeftPageVisibleWidth;
                leftMagin = mLeftPageVisibleWidth;
            } else {
                rightMagin = mLeftPageVisibleWidth;
                leftMagin = dpToPx(mPageMargin);
            }
        } else {
            leftMagin = dpToPx(mPageMargin);
            rightMagin = dpToPx(mPageMargin);
        }

        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();

        //10,10分别是item到上下的margin
        layoutParams.setMargins(leftMagin, 10, rightMagin, 10);
        view.setLayoutParams(layoutParams);
        super.getItemOffsets(outRect, view, parent, state);
    }

    /**
     * d p转换成px
     *
     * @param dp：
     */
    private int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density + 0.5f);

    }

    /**
     * 获取屏幕的宽度
     *
     * @param context:
     * @return :
     */
    public static int getScreenWidth(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        int screenWidth = display.getWidth();
        return screenWidth;
    }
}