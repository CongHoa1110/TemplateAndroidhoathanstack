package com.hoathan.hoa.templateandroid.ui.activity;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.hoathan.hoa.templateandroid.R;
import com.hoathan.hoa.templateandroid.ui.BaseActivity;
import com.hoathan.hoa.templateandroid.ui.fragment.home.TabHomeFragment;
import com.hoathan.hoa.templateandroid.ui.fragment.host.TabSettingFragment;
import com.hoathan.hoa.templateandroid.ui.fragment.news.AddFragment;

public class MainActivity extends BaseActivity {
    private FragmentTabHost fragmentTabHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        fragmentTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec(TAB_HOME).
                setIndicator(getTabIndicator(this, TAB_HOME, R.drawable.ic_widget_main)), TabHomeFragment.class, null);

        fragmentTabHost.addTab(fragmentTabHost.newTabSpec(TAB_SETTING)
                .setIndicator(getTabIndicator(this, TAB_SETTING, R.drawable.ic_widget_setting)), TabSettingFragment.class, null);

        fragmentTabHost.addTab(fragmentTabHost.newTabSpec(TAB_ADD)
                .setIndicator(getTabIndicator(this, TAB_ADD, R.drawable.ic_widget_study)), AddFragment.class, null);

        setCurrentTab(TAB_HOME);
        pushFragment(new TabHomeFragment(), true);

        fragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                setCurrentTab(tabId);
                if (tabStackMap.get(tabId).size() == 0) {
                  /*
                   *    First time this tab is selected. So add first fragment of that tab.
                   *    Don't need animation, so that argument is false.
                   *    We are adding a new fragment which is not present in stack. So add to stack is true.
                   */
                    if (tabId.equals(TAB_HOME)) {
                        setCurrentTab(TAB_HOME);
                        pushFragment(new TabHomeFragment(), true);

                    } else if (tabId.equals(TAB_SETTING)) {
                        setCurrentTab(TAB_SETTING);
                        pushFragment(new TabSettingFragment(), true);

                    } else if (tabId.equals(TAB_ADD)) {
                        setCurrentTab(TAB_ADD);
                        pushFragment(new AddFragment(), true);
                    }
                } else {
                  /*
                   *    We are switching tabs, and target tab is already has at least one fragment.
                   *    No need of animation, no need of stack pushing. Just show the target fragment
                   */
                    pushFragment(tabStackMap.get(tabId).lastElement(), false);
                }
            }
        });


    }

    private View getTabIndicator(Context context, String title, int icon) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_layout, null);

        ImageView iv = (ImageView) view.findViewById(R.id.imgIcon);
        iv.setImageResource(icon);
        TextView tvTextIndicator = (TextView) view.findViewById(R.id.tvTitle);

        tvTextIndicator.setText(title);
        XmlResourceParser xrp = getResources().getXml(R.xml.tabhot_change_text_color);
        try {
            ColorStateList csl = ColorStateList.createFromXml(getResources(), xrp);
            tvTextIndicator.setTextColor(csl);
        } catch (Exception e) {
        }
        return view;
    }


    @Override
    public int getFragmentContainerResId() {
        return android.R.id.tabcontent;
    }
}
