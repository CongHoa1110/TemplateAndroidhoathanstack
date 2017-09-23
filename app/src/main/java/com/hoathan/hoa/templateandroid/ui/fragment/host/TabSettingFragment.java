package com.hoathan.hoa.templateandroid.ui.fragment.host;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.hoathan.hoa.templateandroid.R;
import com.hoathan.hoa.templateandroid.ui.BaseActivity;
import com.hoathan.hoa.templateandroid.ui.BaseFragment;
import com.hoathan.hoa.templateandroid.ui.activity.MainActivity;


public class TabSettingFragment extends BaseFragment implements View.OnClickListener {
private Button btnSetting;
    private MainActivity mainActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void intialView(View view, Bundle savedInstanceState) {
        btnSetting = (Button) view.findViewById(R.id.btn_setting);
        btnSetting.setOnClickListener(this);

    }

    @Override
    protected void intialVariables(View view, Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View view) {
        mainActivity.setCurrentTab(BaseActivity.TAB_SETTING);
        mainActivity.pushFragment(new Setting1Fragment(),true);
    }
}
