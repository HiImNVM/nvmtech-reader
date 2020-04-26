package com.example.nvmtech;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nvmtech.databinding.ActivityHomeBinding;
import com.example.nvmtech.databinding.ActivityRssItemBinding;
import com.example.nvmtech.models.apis.RssItemModel;

import java.util.List;

public class HomeRecyclerAdapter extends  RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {
    private List<RssItemModel> rssItemModels;

    public HomeRecyclerAdapter(List<RssItemModel> mRssItemModels){
        this.rssItemModels = mRssItemModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final ActivityRssItemBinding rssItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_rss_item, parent, false);

        return new ViewHolder(rssItemBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RssItemModel currentRssItem = this.rssItemModels.get(position);
        final ActivityRssItemBinding rssItemBinding = DataBindingUtil.findBinding(holder.itemView);

        rssItemBinding.rvRssItem.setText(currentRssItem.getTitle());
    }


    @Override
    public int getItemCount() {
        return this.rssItemModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
