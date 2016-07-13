package com.yq.doubletimecalander.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.yq.doubletimecalander.MainActivity;
import com.yq.doubletimecalander.R;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yanqi1 on 2016/7/5.
 * .
 */
public class DateFragment extends BaseFragment {

    private boolean mIsLeft;
    private Calendar mSelectedCal;
    private Calendar mCheckIn;
    @Bind(R.id.calendarView)
    MaterialCalendarView mCalendarView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        mIsLeft = bundle.getBoolean("isLeft", false);
        mSelectedCal = (Calendar) bundle.getSerializable("selected");
        mCheckIn = (Calendar) bundle.getSerializable("checkIn");

        View view = inflater.inflate(R.layout.fragment_choose_data, container, false);
        initViews(view);
        return view;
    }


    private void initViews(View view) {
        ButterKnife.bind(this, view);
        if (mIsLeft) {
            mCalendarView.setMinimumDate(Calendar.getInstance());
        } else {
            mCheckIn.add(Calendar.DAY_OF_YEAR, 1);
            mCalendarView.setMinimumDate(mCheckIn);
        }
        mCalendarView.setSelectedDate(mSelectedCal);
        mCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                if (selected) {
                    if (mIsLeft) {
                        ((MainActivity) getActivity()).leftDateChange(date.getCalendar());
                    }
                }
            }
        });
    }


    public void setMinimumDate(Calendar calendar) {
        if (mCalendarView != null) {
            mCalendarView.setMinimumDate(calendar);
        }

    }

    public void setSelectedDate(Calendar calendar) {
        if (mCalendarView != null) {
            mCalendarView.setSelectedDate(calendar);
        }

    }

    public Calendar getSelectedDate() {
        return mCalendarView.getSelectedDate().getCalendar();
    }


}

