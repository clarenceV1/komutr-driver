package com.komutr.driver.ui.main;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.komutr.driver.R;
import com.komutr.driver.databinding.MainBinding;

import java.util.ArrayList;
import java.util.List;

public class TabManager {

    int[] imge = new int[]{R.drawable.tab_1, R.drawable.tab_2, R.drawable.tab_3};
    int[] imgeSelected = new int[]{R.drawable.tab_1_selected, R.drawable.tab_2_selected, R.drawable.tab_3_selected};

    List<ImageView> tabImageView = new ArrayList<>();
    List<TextView> tabTitleView = new ArrayList<>();
    ITabClickListener tabClickListener;

    public TabManager(MainBinding mainBinding, ITabClickListener clickListener) {
        tabImageView.add(mainBinding.tab1Img);
        tabImageView.add(mainBinding.tab2Img);
        tabImageView.add(mainBinding.tab3Img);
        tabTitleView.add(mainBinding.tab1Title);
        tabTitleView.add(mainBinding.tab2Title);
        tabTitleView.add(mainBinding.tab3Title);
        this.tabClickListener = clickListener;
        mainBinding.tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTab(0);
                if (tabClickListener != null) {
                    tabClickListener.onClick(v, 0);
                }
            }
        });
        mainBinding.tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTab(1);
                if (tabClickListener != null) {
                    tabClickListener.onClick(v, 1);
                }
            }
        });
        mainBinding.tab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTab(2);
                if (tabClickListener != null) {
                    tabClickListener.onClick(v, 2);
                }
            }
        });
        mainBinding.tab1.performClick();
    }

    public void selectedTab(int position) {
        if (position < 0 || position >= 3) {
            return;
        }
        Context context = tabImageView.get(0).getContext();
        for (int i = 0; i < 3; i++) {
            if (position == i) {
                tabTitleView.get(i).setTextColor(context.getResources().getColor(R.color.color_2196f3));
                tabImageView.get(i).setImageResource(imgeSelected[i]);
            } else {
                tabTitleView.get(i).setTextColor(context.getResources().getColor(R.color.color_666666));
                tabImageView.get(i).setImageResource(imge[i]);
            }
        }
    }


}
