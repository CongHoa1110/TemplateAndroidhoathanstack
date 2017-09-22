package com.hoathan.hoa.templateandroid.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public  abstract class BaseActivity extends FragmentActivity {
    //define enum to handle foe tabs
    public enum TabTyte{
        TAB_Home,TAB_NEWS,TAB_SETTING
    }

    public Map<TabTyte,Stack<Fragment>> tyteStackMap;
    protected TabTyte currenTab = TabTyte.TAB_Home;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(getLayout());
       /* intialVariables(savedInstanceState);
        intialView(savedInstanceState);*/
        initialStackFragment();

    }
    public void pushFragment(Fragment fragment,Boolean shoulAdd){
        if (shoulAdd){
            tyteStackMap.get(currenTab).push(fragment);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        fragmentTransaction.replace(getFragmentContainerResId(),fragment,fragment.getClass().getSimpleName());
        fragmentTransaction.commitAllowingStateLoss();

    }
    public void popFragment() {
        final Stack<Fragment> stackFragment = tyteStackMap.get(currenTab);
        if (stackFragment.size() > 1) {
            Fragment fragment = stackFragment.elementAt(stackFragment.size() - 2);
            stackFragment.pop();
            if (fragment != null) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                ft.replace(getFragmentContainerResId(), fragment, fragment.getClass().getSimpleName());
                ft.commitAllowingStateLoss();
            }
        }
    }
    public void popFragmentBunder(Bundle argBundle){
        final Stack<Fragment> stackFragment = tyteStackMap.get(currenTab);
        if (stackFragment.size() > 1) {
            Fragment fragment = stackFragment.elementAt(stackFragment.size() - 2);
            stackFragment.pop();

            if (fragment != null) {
                if (argBundle != null) {
                    fragment.setArguments(argBundle);
                }
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                ft.replace(getFragmentContainerResId(), fragment, fragment.getClass().getSimpleName());
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (tyteStackMap.get(currenTab).size()<= 1){
            super.onBackPressed();
        }
        else {
            popFragment();
        }

    }
    public void setCurrenTab(TabTyte tabTyte){
        this.currenTab = tabTyte;
    }

    private void initialStackFragment(){
        tyteStackMap = new HashMap<>();
        /*tyteStackMap.put(TabTyte.TAB_Home,new Stack<Fragment>());
        tyteStackMap.put(TabTyte.TAB_NEWS,new Stack<Fragment>());
        tyteStackMap.put(TabTyte.TAB_SETTING,new Stack<Fragment>());*/
        // nen dung vong for:
        for (TabTyte menuType : TabTyte.values()) {
            tyteStackMap.put(menuType, new Stack<Fragment>());
        }
    }
    /*protected abstract int getLayout();
    protected abstract void intialView(Bundle savedInstanceState);
    protected abstract void intialVariables(Bundle savedInstanceState);*/
    public abstract int getFragmentContainerResId();
}
