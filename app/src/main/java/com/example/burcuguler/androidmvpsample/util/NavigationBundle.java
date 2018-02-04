package com.example.burcuguler.androidmvpsample.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by burcuguler on 27.01.2018.
 */

public class NavigationBundle {

    private Class clazz;
    private Bundle bundle;

    public NavigationBundle(Class clazz, @Nullable Bundle bundle) {
        this.clazz = clazz;
        this.bundle = bundle;

    }

    public Intent getIntent(Activity activity) {
        final Intent intent = new Intent(activity, clazz);

        if (bundle != null) {
            intent.putExtras(bundle);
        }

        return intent;
    }
}
