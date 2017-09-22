package com.hoathan.hoa.templateandroid.ui.fragment.news;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;

import com.hoathan.hoa.templateandroid.R;
import com.hoathan.hoa.templateandroid.ui.BaseActivity;
import com.hoathan.hoa.templateandroid.ui.BaseFragment;
import com.hoathan.hoa.templateandroid.ui.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends BaseFragment implements View.OnClickListener {
    private Button btnAdd;
    private MainActivity mainActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_add;
    }

    @Override
    protected void intialView(View view, Bundle savedInstanceState) {
        btnAdd = (Button) view.findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);

    }

    @Override
    protected void intialVariables(View view, Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View view) {
        mainActivity.setCurrenTab(BaseActivity.TabTyte.TAB_Home);
        mainActivity.pushFragment(new Add1Fragment(),true);

    }
}
