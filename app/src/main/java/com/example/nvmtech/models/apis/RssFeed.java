package com.example.nvmtech.models.apis;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "rss", strict = false)
public class RssFeed {
    @Element
    public RssChannel channel;

    public void setChannel(RssChannel channel) {
        this.channel = channel;
    }

    public RssChannel getChannel() {
        return channel;
    }

    @Override
    public String toString(){
        return "RssFeed [channel=" + channel + "]";
    }
}
