package com.example.nvmtech.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.nvmtech.services.rssService.RssService;

public class HomeViewModelFactory implements ViewModelProvider.Factory {

    private final RssService rssService;

    public HomeViewModelFactory(RssService rssService){
        this.rssService = rssService;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(this.rssService);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
