package com.example.burcuguler.androidmvpsample.util;

import android.support.annotation.StringRes;

import com.example.burcuguler.androidmvpsample.core.App;

/**
 * Created by burcuguler on 4.02.2018.
 */

public final class ResourceUtil {

    public static String getString(@StringRes int stringId) {

        if (stringId > 0) {
            return App.instance.getString(stringId);
        }

        return "";

    }
}
