package com.hoathan.hoa.templateandroid.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.hoathan.hoa.templateandroid.R;
import com.hoathan.hoa.templateandroid.ui.BaseActivity;
import com.hoathan.hoa.templateandroid.ui.BaseFragment;
import com.hoathan.hoa.templateandroid.ui.activity.MainActivity;

/**
 * Created by Tungnguyenbk54 on 9/17/2017.
 */

public class TabHomeFragment extends BaseFragment implements View.OnClickListener {
    private Button btnAddFragment;
    MainActivity MainActivity;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity = (MainActivity) getActivity();
    }



    @Override
    protected int getLayout() {
        return R.layout.fragment_layout;
    }

    @Override
    protected void intialView(View view, Bundle savedInstanceState) {
        btnAddFragment = (Button) view.findViewById(R.id.btAddFragment);
        btnAddFragment.setOnClickListener(this);


    }

    @Override
    protected void intialVariables(View view, Bundle savedInstanceState) {

    }

    public void onClick(View view) {
        MainActivity.setCurrentTab(BaseActivity.TAB_HOME);
        MainActivity.pushFragment(new Home1Fragment(), true);
    }
}
