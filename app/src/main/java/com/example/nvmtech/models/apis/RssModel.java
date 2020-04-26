package com.example.nvmtech.models.apis;

import java.util.List;

public class RssModel {
    public RssModel(){}
    public RssModel(String title, String description, RssImageModel image, long pubDate, String generator, String link, List<RssItemModel> items) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.pubDate = pubDate;
        this.generator = generator;
        this.link = link;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RssImageModel getImage() {
        return image;
    }

    public void setImage(RssImageModel image) {
        this.image = image;
    }

    public long getPubDate() {
        return pubDate;
    }

    public void setPubDate(long pubDate) {
        this.pubDate = pubDate;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<RssItemModel> getItems() {
        return items;
    }

    public void setItems(List<RssItemModel> items) {
        this.items = items;
    }

    private String title;
    private String description;
    private RssImageModel image;
    private long pubDate;
    private String generator;
    private String link;
    private List<RssItemModel> items;
}
