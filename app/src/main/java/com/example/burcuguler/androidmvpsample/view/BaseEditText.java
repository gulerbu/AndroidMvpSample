package com.example.burcuguler.androidmvpsample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatEditText;

/**
 * Created by burcuguler on 8.01.2018.
 */

public class BaseEditText extends AppCompatEditText {

    public BaseEditText(Context context) {
        super(context);
    }

    public BaseEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public String getTextAsString() {
        return getText().toString();
    }

}
