package com.example.burcuguler.androidmvpsample.core;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.burcuguler.androidmvpsample.util.NavigationBundle;

import butterknife.ButterKnife;

/**
 * Created by burcuguler on 18/12/2017.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity
        implements BaseView {

    protected P presenter;

    public abstract int getContentResourceId();

    public abstract P createPresenter();

    public abstract void initUserInterface();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResourceId());
        presenter = createPresenter();
        presenter.attach(this);
        ButterKnife.bind(this);
        initUserInterface();
    }

    @Override
    protected void onDestroy() {
        presenter.detach();
        super.onDestroy();
    }

    @Override
    public void navigateTo(@NonNull NavigationBundle navigationBundle) {
        startActivity(navigationBundle.getIntent(this));
    }
}
