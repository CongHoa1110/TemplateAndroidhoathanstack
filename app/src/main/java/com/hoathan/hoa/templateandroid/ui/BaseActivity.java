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

public abstract class BaseActivity extends FragmentActivity {
    public static final String TAB_HOME = "HOME";
    public static final String TAB_SETTING = "SETTING";
    public static final String TAB_ADD = "ADD";

    public Map<String, Stack<Fragment>> tabStackMap;
    protected String currentTab = TAB_HOME;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(getLayout());
       /* intialVariables(savedInstanceState);
        intialView(savedInstanceState);*/
        initialStackFragment();

    }

    public void pushFragment(Fragment fragment, Boolean shoulAdd) {
        if (shoulAdd) {
            tabStackMap.get(currentTab).push(fragment);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        fragmentTransaction.replace(getFragmentContainerResId(), fragment, fragment.getClass().getSimpleName());
        fragmentTransaction.commitAllowingStateLoss();

    }

    public void popFragment() {
        final Stack<Fragment> stackFragment = tabStackMap.get(currentTab);
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

    public void popFragmentBundle(Bundle argBundle) {
        final Stack<Fragment> stackFragment = tabStackMap.get(currentTab);
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
        if (tabStackMap.get(currentTab).size() <= 1) {
            super.onBackPressed();
        } else {
            popFragment();
        }

    }

    public void setCurrentTab(String tabTyte) {
        this.currentTab = tabTyte;
    }

    private void initialStackFragment() {
        tabStackMap = new HashMap<>();
        tabStackMap.put(TAB_HOME, new Stack<Fragment>());
        tabStackMap.put(TAB_SETTING, new Stack<Fragment>());
        tabStackMap.put(TAB_ADD, new Stack<Fragment>());
    }

    /*protected abstract int getLayout();
    protected abstract void intialView(Bundle savedInstanceState);
    protected abstract void intialVariables(Bundle savedInstanceState);*/
    public abstract int getFragmentContainerResId();
}
