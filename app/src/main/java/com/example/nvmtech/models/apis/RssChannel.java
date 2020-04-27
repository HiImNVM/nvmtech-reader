package com.example.nvmtech.models.apis;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "channel", strict = false)
public class RssChannel
{
    @Element
    private String title;

    @Element
    private RssImage image;

    @Element
    private String link;

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    @Element(required = false)
    private String pubDate;

    @Element(required = false)
    private String generator;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Element
    private String description;

    @ElementList(inline = true, required = false)
    public List<RssItem> rssItems;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RssImage getImage() {
        return image;
    }

    public void setImage(RssImage image) {
        this.image = image;
    }

    public List<RssItem> getRssItems() {
        return rssItems;
    }

    public void setRssItems(List<RssItem> rssItems) {
        this.rssItems = rssItems;
    }
}