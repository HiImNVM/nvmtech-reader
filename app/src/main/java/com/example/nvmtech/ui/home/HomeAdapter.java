package com.example.nvmtech.ui.home;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nvmtech.R;
import com.example.nvmtech.models.apis.RssItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private List<RssItem> rssItemModels;

    private RssItem getRssItemModel(int position){
        return this.rssItemModels.get(position);
    }

    public HomeAdapter(){
        this.rssItemModels = new ArrayList<>();
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rss_item, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return this.rssItemModels.size();
    }

    public void setRssItems(List<RssItem> newRssItems) {
        this.rssItemModels = newRssItems;
        notifyDataSetChanged();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.rvRssItem) TextView rvRssItem;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(int position){
            final RssItem rssItemModel = getRssItemModel(position);

            this.rvRssItem.setText(rssItemModel.getTitle());
        }

        @Override
        public void onClick(View v) {

        }
    }
}
