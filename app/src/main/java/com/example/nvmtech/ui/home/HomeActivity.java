package com.example.nvmtech.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nvmtech.BuildConfig;
import com.example.nvmtech.R;
import com.example.nvmtech.data.DataManager;
import com.example.nvmtech.models.apis.RssItem;
import com.example.nvmtech.ui.base.BaseActivity;
import com.example.nvmtech.utils.OverlayUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity<HomeViewModel> {
    @BindView(R.id.rvRssItems) RecyclerView rvRssItems;

    private HomeAdapter homeAdapter;

    @NonNull
    @Override
    protected HomeViewModel createViewModel() {
        HomeViewModelFactory homeViewModelFactory = new HomeViewModelFactory(DataManager.getInstance().getRssService());
        return ViewModelProviders.of(this, homeViewModelFactory).get(HomeViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        homeAdapter = new HomeAdapter();
        rvRssItems.setAdapter(homeAdapter);
        rvRssItems.setLayoutManager(new LinearLayoutManager(this));

        viewModel.getIsLoading().observe(this, new LoadingObserver());
        viewModel.getRssItems().observe(this, new RssItemsObserver());

        viewModel.fetchRss();
    }

    public static void start(Context context){
        Intent starter = new Intent(context, HomeActivity.class);
        context.startActivity(starter);
    }

    private class LoadingObserver implements Observer<Boolean> {

        @Override
        public void onChanged(Boolean isLoading) {
            if (isLoading == null) return;

            OverlayUtil.animateView(findViewById(R.id.progressOverlay), isLoading ? View.GONE : View.VISIBLE);
        }
    }

    private class RssItemsObserver implements Observer<List<RssItem>> {

        @Override
        public void onChanged(List<RssItem> newRssItems) {
            if (newRssItems == null) return ;

            homeAdapter.setRssItems(newRssItems);
        }
    }
}
