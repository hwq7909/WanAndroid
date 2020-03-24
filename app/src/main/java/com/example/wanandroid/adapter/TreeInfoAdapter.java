package com.example.wanandroid.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wanandroid.R;
import com.example.wanandroid.bean.TreeBean;
import com.yanzhenjie.recyclerview.OnItemClickListener;
import com.yatoooon.screenadaptation.ScreenAdapterTools;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TreeInfoAdapter extends RecyclerView.Adapter {

    private Context context;
    private LayoutInflater inflater;
    private OnItemClickListener listener;
    private ArrayList<TreeBean> list;

    public TreeInfoAdapter(Context context, ArrayList<TreeBean> list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.tree_item, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private void OnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    private interface OnItemClickListener{

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.big_child) TextView big_child;
        @BindView(R.id.fl_child) TextView fl_child;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ScreenAdapterTools.getInstance().loadView(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
