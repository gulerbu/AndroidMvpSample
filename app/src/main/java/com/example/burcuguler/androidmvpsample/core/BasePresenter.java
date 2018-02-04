package com.example.burcuguler.androidmvpsample.core;

/**
 * Created by burcuguler on 18/12/2017.
 */

public abstract class BasePresenter<V extends BaseView> {

    protected V view;

    public void attach(V view) {
        this.view = view;
    }

    public void detach() {
        this.view = null;
    }

}
