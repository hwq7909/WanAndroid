package com.example.wanandroid.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.wanandroid.R;
import com.example.wanandroid.mvp.BaseActivity;
import com.example.wanandroid.mvp.IBaseView;
import com.yatoooon.screenadaptation.ScreenAdapterTools;

import butterknife.ButterKnife;

/**
 * @author L_Name
 * @date 2019/12/22.
 * GitHub：
 * Email：
 * Description：
 */
public class MainActivity extends BaseActivity implements IBaseView {

    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ScreenAdapterTools.getInstance().loadView(getWindow().getDecorView());
        ButterKnife.bind(this);
        context = this;
    }
}
