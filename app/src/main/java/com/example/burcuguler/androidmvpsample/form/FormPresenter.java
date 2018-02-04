package com.example.burcuguler.androidmvpsample.form;

import android.os.Handler;

import com.example.burcuguler.androidmvpsample.util.InputValidationUtil;
import com.example.burcuguler.androidmvpsample.core.BasePresenter;

/**
 * Created by burcuguler on 18/12/2017.
 */

public class FormPresenter extends BasePresenter<FormView> {

    public void onSignUpClick(String name, String surname, String email) {
        if (!InputValidationUtil.isValidName(name) || !InputValidationUtil.isValidName(surname)
                || !InputValidationUtil.isValidEmail(email)) {
            view.showInputError();
        } else {
            registerUser(name, surname, email);
        }

    }

    private void registerUser(String name, String surname, String email) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.onRegisterSuccessful();
            }
        }, 1000);


    }
}
