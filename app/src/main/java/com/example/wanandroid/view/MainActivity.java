package com.example.wanandroid.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.wanandroid.R;
import com.example.wanandroid.bean.LoginBean;
import com.example.wanandroid.mvp.BaseActivity;
import com.example.wanandroid.view.activity.LoginActivity;
import com.example.wanandroid.view.fragment.MainFragment;
import com.example.wanandroid.view.fragment.MineFragment;
import com.example.wanandroid.view.fragment.PlaygroundFragment;
import com.example.wanandroid.view.fragment.TreeFragment;
import com.example.wanandroid.view.fragment.PublicFragment;
import com.google.android.material.navigation.NavigationView;
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
    @BindView(R.id.ll_main) LinearLayout ll_main;
    @BindView(R.id.ll_project) LinearLayout ll_project;
    @BindView(R.id.ll_playground) LinearLayout ll_playground;
    @BindView(R.id.ll_public) LinearLayout ll_public;
    @BindView(R.id.ll_mine) LinearLayout ll_mine;
    @BindView(R.id.drawer_layout) DrawerLayout dl;
    @BindView(R.id.nav_view) NavigationView navView;

    private Context context;
    private FragmentManager fm;
    private int currentPosition = -1;

    private Fragment currentFragment;
    private MainFragment mainFragment;
    private TreeFragment treeFragment;
    private PlaygroundFragment playgroundFragment;
    private PublicFragment publicFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        //屏幕适配
        ScreenAdapterTools.getInstance().loadView(getWindow().getDecorView());
        ButterKnife.bind(this);
        context = this;

        initNV();

        initData();

        initView();

        initClick();
    }

    private void initNV() {
        View headerView = navView.inflateHeaderView(R.layout.nav_header);
        ImageView head_iv = headerView.findViewById(R.id.nv_image);
        head_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                dl.closeDrawers();
                return true;
            }
        });
    }

    private void initClick() {
        ll_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = 0;
                changeTab();
            }
        });
        ll_project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = 1;
                changeTab();
            }
        });
        ll_playground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = 2;
                changeTab();
            }
        });
        ll_public.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = 3;
                changeTab();
            }
        });
        ll_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = 4;
                changeTab();
            }
        });
    }

    //结束Activity并释放内存
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initView() {
        changeTab();
    }
    //Tab标签更换
    private void changeTab() {
        FragmentTransaction transaction = fm.beginTransaction();
        if (currentFragment != null) {
            transaction.hide(currentFragment);//隐藏已经添加到父容器的fragment的View
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
                if (treeFragment == null) {
                    treeFragment = new TreeFragment();
            }
                if (!treeFragment.isAdded()) {
                    transaction.add(R.id.fl_fragment, treeFragment);
                } else {
                    transaction.show(treeFragment);
                }
                currentFragment = treeFragment;
                break;
            case 2:
                if (playgroundFragment == null) {
                    playgroundFragment = new PlaygroundFragment();
                }
                if (!playgroundFragment.isAdded()) {
                    transaction.add(R.id.fl_fragment, playgroundFragment);
                } else {
                    transaction.show(playgroundFragment);
                }
                currentFragment = playgroundFragment;
                break;
            case 3:
                if (publicFragment == null) {
                    publicFragment = new PublicFragment();
                }
                if (!publicFragment.isAdded()) {
                    transaction.add(R.id.fl_fragment, publicFragment);
                } else {
                    transaction.show(publicFragment);
                }
                currentFragment = publicFragment;
                break;
            case 4:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                }
                if (!mineFragment.isAdded()) {
                    transaction.add(R.id.fl_fragment, mineFragment);
                } else {
                    transaction.show(mineFragment);
                }
                currentFragment = mineFragment;
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    private void initData() {
        fm = getSupportFragmentManager();
        currentPosition = 0;
    }

    public void setLoginData(LoginBean loginBean) {
        //tv.settext();
        //
    }

    public void clearLoginData() {

    }

}
