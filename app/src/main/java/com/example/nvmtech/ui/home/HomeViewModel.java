package com.example.nvmtech.ui.home;

import androidx.lifecycle.MutableLiveData;

import com.example.nvmtech.models.apis.RssFeed;
import com.example.nvmtech.models.apis.RssItem;
import com.example.nvmtech.services.rssService.RssService;
import com.example.nvmtech.ui.base.BaseViewModel;
import com.example.nvmtech.utils.LoggerUtil;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends BaseViewModel {
    private MutableLiveData<List<RssItem>> rssItems;
    private MutableLiveData<Boolean> isLoading;

    MutableLiveData<List<RssItem>> getRssItems(){
        return this.rssItems;
    };

    private void setRssItems(List<RssItem> newRssItems){
        this.rssItems.postValue(newRssItems);
    }

    MutableLiveData<Boolean> getIsLoading(){
        return this.isLoading;
    }

    private void setIsLoading(boolean newIsLoading){
        this.isLoading.postValue(newIsLoading);
    }


    private RssService rssService;

    HomeViewModel(RssService rssService){
        this.rssService = rssService;
        this.rssItems = new MutableLiveData<>();
        this.isLoading = new MutableLiveData<>();
    }

    void fetchRss(){
        this.setIsLoading(true);
        this.rssService.getRssApi().getRssFeed().enqueue(new RssServiceCallback());
    }


    private class RssServiceCallback implements Callback<RssFeed> {

        @Override
        public void onResponse(Call<RssFeed> call, Response<RssFeed> response) {
            setIsLoading(false);

            final RssFeed rssFeed = response.body();
            setRssItems(rssFeed == null ? Collections.emptyList() : rssFeed.getChannel().getRssItems());
        }

        @Override
        public void onFailure(Call<RssFeed> call, Throwable t) {
            setIsLoading(false);
            setRssItems(Collections.emptyList());
        }
    }
}