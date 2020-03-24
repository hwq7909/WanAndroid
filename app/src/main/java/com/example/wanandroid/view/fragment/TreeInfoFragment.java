package com.example.wanandroid.view.fragment;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wanandroid.Interface.MainView;
import com.example.wanandroid.R;
import com.example.wanandroid.bean.ExitBean;
import com.example.wanandroid.bean.LoginBean;
import com.example.wanandroid.bean.MainArticleInfoBean;
import com.example.wanandroid.bean.MainBannerListBean;
import com.example.wanandroid.bean.ProjectCommunityInfoBean;
import com.example.wanandroid.bean.RegisterBean;
import com.example.wanandroid.bean.TreeBean;
import com.example.wanandroid.bean.TreeInfoBean;
import com.example.wanandroid.mvp.BaseFragment;
import com.example.wanandroid.presenter.MainPresenter;
import com.example.wanandroid.view.widget.FlowLayout;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TreeInfoFragment extends BaseFragment implements MainView {

    @BindView(R.id.flowlayout)
    FlowLayout flowLayout;

    private MainPresenter presenter;
    private ArrayList<TreeBean> treeBeans = new ArrayList<>();

    @Override
    public int getContentViewId() {
        return R.layout.tree_info_fragment;
    }

    @Override
    public void initAllMembersView(Bundle var1) {
        ButterKnife.bind(this, rootView);

        initData();

    }

    private void initData() {
        presenter = new MainPresenter(this);
        presenter.getTree();
    }


    @Override
    public void getBannerList(MainBannerListBean bannerListBean) {

    }

    @Override
    public void getMainArticleList(MainArticleInfoBean mainArticleInfoBean) {

    }

    @Override
    public void getTree(TreeInfoBean treeInfoBean) {
        ViewGroup.MarginLayoutParams mlp = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        for (int i = 0; i < treeInfoBean.getData().get(1).getChildren().size(); i++){
            TextView view = new TextView(context);
            view.setText(treeInfoBean.getData().get(1).getChildren().get(i).getName());
            flowLayout.addView(view, mlp);
        }
        flowLayout.requestLayout();
    }

    @Override
    public void getProjectCommunityList(ProjectCommunityInfoBean projectCommunityInfoBean) {

    }

    @Override
    public void Login(LoginBean loginBean) {

    }

    @Override
    public void Register(RegisterBean registerBean) {

    }

    @Override
    public void Exit(ExitBean exitBean) {

    }
}
