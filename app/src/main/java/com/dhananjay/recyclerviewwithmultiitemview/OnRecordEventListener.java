package com.dhananjay.recyclerviewwithmultiitemview;

public interface OnRecordEventListener {

    void onRatingBarChange(int position, float value);

    void onRadioCheckedChange(int position, boolean isChecked);
}
