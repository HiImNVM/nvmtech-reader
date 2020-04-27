package com.example.nvmtech.models.apis;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item", strict = false)
public class RssItem
{
    @Element
    private String title;

    @Element
    private String link;

    @Element
    private String pubDate;

    @Element(required = false)
    private String guid;

    @Element(data = true)
    private String description;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
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

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RssItem [title=" + title + ", link=" + link + ", pubDate=" + pubDate
                + ", description=" + description + "]";
    }
}