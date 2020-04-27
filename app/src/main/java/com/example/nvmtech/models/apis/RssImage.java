package com.example.nvmtech.models.apis;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "image", strict = false)
public class RssImage
{
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Element
    private String url;

    @Element(required = false)
    private String width;

    @Element(required = false)
    private String height;

    @Override
    public String toString() {
        return "RssImage [url=" + url + ", width=" + width + ", height=" + height + "]";
    }
}