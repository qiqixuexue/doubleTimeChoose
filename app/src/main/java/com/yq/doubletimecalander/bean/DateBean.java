package com.yq.doubletimecalander.bean;

import java.util.Calendar;

/**
 * Created by yanqi1 on 2016/7/4.
 */
public class DateBean {

    Calendar calendar;

    String type;

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
