package com.example.nvmtech.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;

import com.example.nvmtech.BuildConfig;
import com.example.nvmtech.R;
import com.example.nvmtech.ui.base.BaseActivity;
import com.example.nvmtech.ui.home.HomeActivity;
import com.example.nvmtech.utils.LoggerUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

//import androidx.core.R;


public class MainActivity extends BaseActivity<MainViewModel> {

    @NonNull
    @Override
    protected MainViewModel createViewModel() {
        MainViewModelFactory mainFactory = new MainViewModelFactory();
        return ViewModelProviders.of(this, mainFactory).get(MainViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LoggerUtil.init(BuildConfig.IS_DEV == "false");
    }

    @OnClick(R.id.btnComeWithMe)
    void onNavigateToHome(){
        HomeActivity.start(this);
    }
}

