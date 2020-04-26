package com.example.nvmtech.models.apis;

public class RssImageModel {
    public RssImageModel(){}
    public RssImageModel(String url, String title, String link) {
        this.url = url;
        this.title = title;
        this.link = link;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    private String url;
    private  String title;
    private String link;
}
