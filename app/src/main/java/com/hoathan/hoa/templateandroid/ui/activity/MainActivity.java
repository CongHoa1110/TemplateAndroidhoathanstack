package com.hoathan.hoa.templateandroid.ui.activity;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
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
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("tag1").
                setIndicator(getTabIndicator(this, "Home", R.drawable.ic_widget_main)), TabHomeFragment.class, null);

        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("tag2")
                .setIndicator(getTabIndicator(this, "Setting", R.drawable.ic_widget_setting)), TabSettingFragment.class, null);

        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("tag3")
                .setIndicator(getTabIndicator(this, "Add", R.drawable.ic_widget_study)), AddFragment.class, null);
        setCurrenTab(TabTyte.TAB_Home);
        pushFragment( new TabHomeFragment() ,true);
        setCurrenTab(TabTyte.TAB_SETTING);
        pushFragment(new TabSettingFragment(),true);
        setCurrenTab(TabTyte.TAB_NEWS);
        pushFragment(new AddFragment(),true);


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
