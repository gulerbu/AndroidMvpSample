package com.example.burcuguler.androidmvpsample.form;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.burcuguler.androidmvpsample.R;
import com.example.burcuguler.androidmvpsample.core.BaseActivity;

/**
 * Created by burcuguler on 18/12/2017.
 */

public class FormActivity extends BaseActivity<FormPresenter> implements
        FormView,
        View.OnClickListener {

    EditText editTextName;
    EditText editTextSurname;
    EditText editTextEmail;
    Button buttonSignup;

    @Override
    public int getContentResourceId() {
        return R.layout.activity_form;
    }

    @Override
    public FormPresenter createPresenter() {
        return new FormPresenter();
    }

    @Override
    public void initUserInterface() {
        editTextName = (EditText) findViewById(R.id.activity_form_edit_text_name);
        editTextSurname = (EditText) findViewById(R.id.activity_form_edit_text_surname);
        editTextEmail = (EditText) findViewById(R.id.activity_form_edit_text_email);
        buttonSignup = (Button) findViewById(R.id.activity_form_button_signUp);

        buttonSignup.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        presenter.onSignUpClick(
                editTextName.getText().toString(),
                editTextSurname.getText().toString(),
                editTextEmail.getText().toString());
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "Check information you entered", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRegisterSuccessful() {
        Toast.makeText(this, "Go on !", Toast.LENGTH_LONG).show();
    }
}
