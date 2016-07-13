package com.yq.doubletimecalander;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by X-FAN on 2016/3/29.
 */
public class BaseActivity extends AppCompatActivity {

    protected final Object TAG = new Object();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //友盟推送
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 默认有返回键
     *
     * @param title
     */
    protected void setTitleBar(@StringRes int title) {

        setMyTitle(title);
        ImageView leftButton = (ImageView) findViewById(R.id.left_button);
        leftButton.setVisibility(View.VISIBLE);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 默认有返回键
     *
     * @param title
     */
    protected void setTitleBar(@NonNull String title) {
        setMyTitle(title);
        ImageView leftButton = (ImageView) findViewById(R.id.left_button);
        leftButton.setVisibility(View.VISIBLE);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 设置标题以及标题颜色
     *
     * @param title
     * @param color
     */
    protected void setMyTitle(@StringRes int title, @ColorRes int color) {
        TextView titleTV = ((TextView) findViewById(R.id.toolbar_title));
        titleTV.setText(title);
        titleTV.setTextColor(getResources().getColor(color));
    }


    /**
     * 设置标题以及标题颜色
     *
     * @param title
     * @param color
     */
    protected void setMyTitle(String title, @ColorRes int color) {
        TextView titleTV = ((TextView) findViewById(R.id.toolbar_title));
        titleTV.setText(title);
        titleTV.setTextColor(getResources().getColor(color));
    }


    /**
     * 设置副标题
     *
     * @param title
     */
    protected void setSubTitle(String title) {
        TextView titleTV = ((TextView) findViewById(R.id.sub_title));
        titleTV.setText(title);
        titleTV.setVisibility(View.VISIBLE);

    }

    /**
     * 设置titlebar背景色
     *
     * @param color
     */
    protected void setTitleBarColor(int color) {
        View toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundResource(color);
    }

    /**
     * 设置标题
     *
     * @param title
     */
    protected void setMyTitle(@StringRes int title) {
        TextView titleTV = ((TextView) findViewById(R.id.toolbar_title));
        titleTV.setText(title);
        titleTV.setVisibility(View.VISIBLE);
    }

    /**
     * 设置标题
     *
     * @param title
     */
    protected void setMyTitle(@NonNull String title) {
        TextView titleTV = ((TextView) findViewById(R.id.toolbar_title));
        titleTV.setText(title);
        titleTV.setVisibility(View.VISIBLE);
    }

    /**
     * 设置左边图片按钮
     *
     * @param leftButtonImage
     * @param listener
     */
    protected void setLeftButton(@DrawableRes int leftButtonImage, View.OnClickListener listener) {
        ImageView leftButton = (ImageView) findViewById(R.id.left_button);
        leftButton.setImageResource(leftButtonImage);
        leftButton.setVisibility(View.VISIBLE);
        leftButton.setOnClickListener(listener);
    }

    /**
     * 设置左边图片按钮(默认注册关闭界面事件)
     *
     * @param leftButtonImage
     */
    protected void setLeftButton(@DrawableRes int leftButtonImage) {
        ImageView leftButton = (ImageView) findViewById(R.id.left_button);
        leftButton.setImageResource(leftButtonImage);
        leftButton.setVisibility(View.VISIBLE);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 设置右边图片按钮
     *
     * @param rightButtonImage
     * @param listener
     */
    protected void setRightButton(@DrawableRes int rightButtonImage, View.OnClickListener listener) {
        ImageView rightButton = (ImageView) findViewById(R.id.right_button);
        rightButton.setImageResource(rightButtonImage);
        rightButton.setVisibility(View.VISIBLE);
    }

    /**
     * 设置右边文字按钮
     *
     * @param rightText
     */
    protected void setRightTextButton(@StringRes int rightText) {
        TextView rightTextButton = (TextView) findViewById(R.id.right_textButton);
        rightTextButton.setText(rightText);
        rightTextButton.setVisibility(View.VISIBLE);
    }




    protected EditText getEditTextView() {
        EditText editText = (EditText) findViewById(R.id.toolbar_edit);
        return editText;
    }

    protected TextView getTitleView() {
        TextView titleTV = ((TextView) findViewById(R.id.toolbar_title));
        return titleTV;
    }

    protected ImageView getLeftbutton() {
        ImageView leftButton = (ImageView) findViewById(R.id.left_button);
        return leftButton;
    }
}
