package com.yq.doubletimecalander.fragment;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yq.doubletimecalander.R;


/**
 * Created by X-FAN on 2016/4/8.
 */
public class BaseFragment extends Fragment {
    protected final Object TAG = new Object();

    /**
     * 默认有返回键
     *
     * @param title
     */
    protected void setTitleBar(View view, @StringRes int title) {

        setMyTitle(view, title);
        ImageView leftButton = (ImageView) view.findViewById(R.id.left_button);
        leftButton.setVisibility(View.VISIBLE);

    }

    /**
     * 默认有返回键
     *
     * @param title
     */
    protected void setTitleBar(View view, @NonNull String title) {

        setMyTitle(view, title);
        ImageView leftButton = (ImageView) view.findViewById(R.id.left_button);
        leftButton.setVisibility(View.VISIBLE);
     /*   leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/
    }

    /**
     * 设置标题
     *
     * @param title
     */
    protected void setMyTitle(View view, @StringRes int title) {
        TextView titleTV = ((TextView) view.findViewById(R.id.toolbar_title));
        titleTV.setText(title);
        titleTV.setVisibility(View.VISIBLE);
    }

    /**
     * 设置标题
     *
     * @param title
     */
    protected void setMyTitle(View view, @NonNull String title) {
        TextView titleTV = ((TextView) view.findViewById(R.id.toolbar_title));
        titleTV.setText(title);
        titleTV.setVisibility(View.VISIBLE);
    }

    /**
     * 设置左边图片按钮
     *
     * @param leftButtonImage
     * @param listener
     */
    protected void setLeftButton(View view, @DrawableRes int leftButtonImage, View.OnClickListener listener) {
        ImageView leftButton = (ImageView) view.findViewById(R.id.left_button);
        leftButton.setImageResource(leftButtonImage);
        leftButton.setVisibility(View.VISIBLE);
    }

    /**
     * 设置右边图片按钮
     *
     * @param rightButtonImage
     * @param listener
     */
    protected void setRightButton(View view, @DrawableRes int rightButtonImage, View.OnClickListener listener) {
        ImageView rightButton = (ImageView) view.findViewById(R.id.right_button);
        rightButton.setImageResource(rightButtonImage);
        rightButton.setVisibility(View.VISIBLE);
    }

    /**
     * 设置右边文字按钮
     *
     * @param rightText
     */
    protected void setRightTextButton(View view, @StringRes int rightText) {
        TextView rightTextButton = (TextView) view.findViewById(R.id.right_textButton);
        rightTextButton.setText(rightText);
        rightTextButton.setVisibility(View.VISIBLE);
    }
}
