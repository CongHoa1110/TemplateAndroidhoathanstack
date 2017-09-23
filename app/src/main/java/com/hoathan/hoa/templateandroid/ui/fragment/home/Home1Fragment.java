package com.hoathan.hoa.templateandroid.ui.fragment.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hoathan.hoa.templateandroid.R;
import com.hoathan.hoa.templateandroid.ui.BaseActivity;
import com.hoathan.hoa.templateandroid.ui.BaseFragment;
import com.hoathan.hoa.templateandroid.ui.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home1Fragment extends BaseFragment implements View.OnClickListener {
private Button btnHom1,btnHome2;
    private MainActivity mainActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home1;
    }

    @Override
    protected void intialView(View view, Bundle savedInstanceState) {
        btnHom1 = (Button) view.findViewById(R.id.btn_home1);
        btnHome2 = (Button) view.findViewById(R.id.btn_home2);
        btnHom1.setOnClickListener(this);
        btnHome2.setOnClickListener(this);

    }

    @Override
    protected void intialVariables(View view, Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_home1:
                mainActivity.setCurrentTab(BaseActivity.TAB_HOME);
                mainActivity.pushFragment(new Home12Fragment(), true);
                break;
            case R.id.btn_home2:
                Toast.makeText(getActivity() , "2", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
