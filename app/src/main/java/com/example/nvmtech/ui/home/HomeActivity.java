package com.example.nvmtech.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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

        setupActionBar();
        ButterKnife.bind(this);

        // setupActionBar();
        setupListRssItems();
        viewModel.getIsLoading().observe(this, new LoadingObserver());
        viewModel.getRssItems().observe(this, new RssItemsObserver());

        viewModel.fetchRss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    private void setupActionBar(){
        Toolbar myToolbar = (Toolbar)findViewById(R.id.tbHome);
        setSupportActionBar(myToolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null){
            return;
        }

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("NVM");
    }

    private void setupListRssItems(){
        homeAdapter = new HomeAdapter();
        rvRssItems.setAdapter(homeAdapter);
        rvRssItems.setLayoutManager(new LinearLayoutManager(this));
    }

    public static void start(Context context){
        Intent starter = new Intent(context, HomeActivity.class);
        context.startActivity(starter);
    }

    private class LoadingObserver implements Observer<Boolean> {
        private OverlayUtil.OverlayWaiting overlayWaiting = new OverlayUtil.OverlayWaiting();

        @Override
        public void onChanged(Boolean isLoading) {
            if (isLoading == null) return;

            if (isLoading) {
                OverlayUtil.showOverlayWaiting(overlayWaiting, getSupportFragmentManager());
            } else {
                OverlayUtil.close(overlayWaiting);
            }
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
