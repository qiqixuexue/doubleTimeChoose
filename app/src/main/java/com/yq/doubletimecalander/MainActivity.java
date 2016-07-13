package com.yq.doubletimecalander;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yq.doubletimecalander.bean.DateBean;
import com.yq.doubletimecalander.fragment.DateFragment;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String[] FRAGMENT_TAG = {"left", "right"};
    private DateFragment mLeftFragment;
    private DateFragment mRightFragment;
    private FragmentManager mFragmentManager;

    @Bind(R.id.checkin)
    RelativeLayout mCheckinLinearLayout;//入住时间
    @Bind(R.id.checkout)
    RelativeLayout mCheckoutLinearLayout;//离店时间
    @Bind(R.id.button)
    Button mButton;

    @Bind(R.id.lineleft)
    TextView mLeftTextView;
    @Bind(R.id.lineright)
    TextView mRightTextView;

    //确定传入参数的boolean值
    Calendar mCheckin, mCheckout;
    //确定传入参数的boolean值
    boolean mIsCheckIn;

    DateBean onlyEventLeft, onlyEventRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTitleBar("选择日期");
        mFragmentManager = getSupportFragmentManager();
        restoreFragments(savedInstanceState);
        initDate();
        initFragments();
        initView();
    }

    private void restoreFragments(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mLeftFragment = (DateFragment) mFragmentManager.findFragmentByTag(FRAGMENT_TAG[0]);
            mRightFragment = (DateFragment) mFragmentManager.findFragmentByTag(FRAGMENT_TAG[1]);
        }
    }

    private void initFragments() {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (mLeftFragment == null) {
            mLeftFragment = new DateFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isLeft", true);
            bundle.putSerializable("selected", mCheckin);
            mLeftFragment.setArguments(bundle);
            transaction.add(R.id.id_content, mLeftFragment, FRAGMENT_TAG[0]);
        }
        if (mRightFragment == null) {
            mRightFragment = new DateFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isLeft", false);
            bundle.putSerializable("selected", mCheckout);
            bundle.putSerializable("checkIn", mCheckin);
            mRightFragment.setArguments(bundle);
            transaction.add(R.id.id_content, mRightFragment, FRAGMENT_TAG[1]);
        }
        transaction.commitAllowingStateLoss();
    }


    private void initView() {
        setTabSelection(0);
        mCheckinLinearLayout.setOnClickListener(this);
        mCheckoutLinearLayout.setOnClickListener(this);
        mButton.setOnClickListener(this);

    }

    //这边修改时间 mCheckin和mCheckout 是初始化时间
    private void initDate() {
        mCheckin =  Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE,1 );
        mCheckout = c;
    }


    private void setTabSelection(int index) {
        resetBtn();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 0:
                setSelected(index);
                if (mLeftFragment == null) {
                    mLeftFragment = new DateFragment();
                    transaction.add(R.id.id_content, mLeftFragment, FRAGMENT_TAG[0]);
                } else {
                    transaction.show(mLeftFragment);
                }

                break;
            case 1:
                setSelected(index);
                if (mRightFragment == null) {
                    mRightFragment = new DateFragment();
                    transaction.add(R.id.id_content, mRightFragment, FRAGMENT_TAG[1]);
                } else {
                    transaction.show(mRightFragment);
                }
        }
        transaction.commitAllowingStateLoss();
    }


    private void hideFragments(FragmentTransaction transaction) {
        if (mLeftFragment != null) {
            transaction.hide(mLeftFragment);
        }
        if (mRightFragment != null) {
            transaction.hide(mRightFragment);
        }
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void resetBtn() {
        mLeftTextView.setVisibility(View.INVISIBLE);
        mRightTextView.setVisibility(View.INVISIBLE);
    }

    private void setSelected(int code) {
        if (code == 0) {
            mLeftTextView.setVisibility(View.VISIBLE);
            mRightTextView.setVisibility(View.INVISIBLE);
        } else {
            mLeftTextView.setVisibility(View.INVISIBLE);
            mRightTextView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.checkin:
                setTabSelection(0);
                break;
            case R.id.checkout:
                setTabSelection(1);
                break;
            case R.id.button:
                finish();
                break;
            default:
                break;
        }
    }

    public void leftDateChange(Calendar calendar) {
        Calendar checkOutCalendar = mRightFragment.getSelectedDate();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(calendar.getTime());
        calendar1.add(Calendar.DAY_OF_YEAR, 1);
        mRightFragment.setMinimumDate(calendar1);
        if (calendar.after(checkOutCalendar)) {
            mRightFragment.setSelectedDate(calendar1);
        }
    }
}