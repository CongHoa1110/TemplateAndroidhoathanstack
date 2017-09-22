package com.hoathan.hoa.templateandroid.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(),container,false);
        intialView(view,  savedInstanceState);
        intialVariables( view, savedInstanceState);
        return view;

    }
    protected abstract int getLayout();
    protected abstract void intialView(View view, Bundle savedInstanceState);
    protected abstract void intialVariables(View view, Bundle savedInstanceState);

}
