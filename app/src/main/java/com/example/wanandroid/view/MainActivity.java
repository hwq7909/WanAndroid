package com.example.wanandroid.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.wanandroid.R;
import com.example.wanandroid.mvp.BaseActivity;
import com.example.wanandroid.view.fragment.MainFragment;
import com.yatoooon.screenadaptation.ScreenAdapterTools;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author L_Name
 * @date 2019/12/22.
 * GitHub：
 * Email：
 * Description：
 */
public class MainActivity extends BaseActivity{

    @BindView(R.id.fl_fragment) FrameLayout fl_fragment;

    private Context context;
    private FragmentManager fm;
    private int currentPosition = -1;

    private Fragment currentFragment;
    private MainFragment mainFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ScreenAdapterTools.getInstance().loadView(getWindow().getDecorView());
        ButterKnife.bind(this);
        context = this;

        initData();

        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initView() {
        changeTab();
    }

    private void changeTab() {
        FragmentTransaction transaction = fm.beginTransaction();
        if (currentFragment != null) {
            transaction.hide(currentFragment);
        }
        switch (currentPosition) {
            case 0:
                if (mainFragment == null) {
                    mainFragment = new MainFragment();
                }
                if (!mainFragment.isAdded()) {
                    transaction.add(R.id.fl_fragment, mainFragment);
                } else {
                    transaction.show(mainFragment);
                }
                currentFragment = mainFragment;
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    private void initData() {
        fm = getSupportFragmentManager();
        currentPosition = 0;
    }
}
