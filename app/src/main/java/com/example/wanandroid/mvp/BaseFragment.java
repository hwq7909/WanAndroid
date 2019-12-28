package com.example.wanandroid.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.wanandroid.dialog.LoadDialog;
import com.example.wanandroid.utils.ScreenUtil;

/**
 * @author L_Name
 * @date 2019/12/28.
 * GitHub：
 * Email：
 * Description：
 */
public abstract class BaseFragment extends Fragment implements IBaseView {

    public Context context;
    public View rootView;
    private LoadDialog loadDialog;

    public boolean isOnResumeSetStatus = false;
    public boolean isProcessOnHiddenChanged = true;

    public BaseFragment() {
    }

    public abstract int getContentViewId();

    public abstract void initAllMembersView(Bundle var1);

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.rootView = inflater.inflate(this.getContentViewId(), null);
        this.context = this.getActivity();
        if (this.getContext() != null) {
            this.loadDialog = new LoadDialog(this.getContext());
        }

        this.initAllMembersView(savedInstanceState);
        return this.rootView;
    }

    /**
     * 检查activity连接情况
     */
    public void checkActivityAttached() {
        if (getActivity() == null) {
            throw new ActivityNotAttachedException();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(isProcessOnHiddenChanged){
            if(hidden){
                isOnResumeSetStatus = false;
            }else {
                isOnResumeSetStatus = true;
            }
        }
    }

    public static class ActivityNotAttachedException extends RuntimeException {
        public ActivityNotAttachedException() {
            super("Fragment has disconnected from Activity ! - -.");
        }
    }

    public void showLoading() {
        if (this.loadDialog != null && !this.loadDialog.isShowing()) {
            this.loadDialog.show();
        }

    }

    public void hideLoading() {
        if (this.loadDialog != null && this.loadDialog.isShowing()) {
            this.loadDialog.dismiss();
        }

    }

    public void showToast(String msg) {
        try {
            Toast.makeText(this.getContext(), msg, Toast.LENGTH_SHORT).show();
        } catch (Exception var3) {
            Looper.prepare();
            Toast.makeText(this.getContext(), msg, Toast.LENGTH_SHORT).show();
            Looper.loop();
        }

    }

    public void showErr(String msg) {
        if (msg != null && !msg.isEmpty()) {
            Toast.makeText(this.getContext(), msg, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this.getContext(), "发生错误", Toast.LENGTH_SHORT).show();
        }

    }

    public Context getContext() {
        if (this.context == null) {
            this.context = super.getActivity();
        }

        return this.context;
    }

    public Activity getAcitvity() {
        return super.getActivity();
    }

    public void setTextStatusBar(int emptyID){
        ScreenUtil.setHead(getActivity(), rootView.findViewById(emptyID),
                android.R.color.white,ScreenUtil.StatusBarStyle.COLOR);
        ScreenUtil.setStatusBarLightMode(getActivity());
    }

    public void setImageStatusBar(int emptyID){
        ScreenUtil.setHead(getActivity(), rootView.findViewById(emptyID),
                android.R.color.transparent, ScreenUtil.StatusBarStyle.IMAGE);
        ScreenUtil.setStatusBarDarkMode(getActivity());
    }

}
