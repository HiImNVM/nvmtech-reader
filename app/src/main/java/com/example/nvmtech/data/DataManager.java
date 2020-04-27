package com.example.nvmtech.data;

import com.example.nvmtech.services.rssService.RssService;

public class DataManager {
    private static DataManager instance;

    private DataManager() {}

    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public RssService getRssService(){
        return RssService.getInstance();
    }
}
