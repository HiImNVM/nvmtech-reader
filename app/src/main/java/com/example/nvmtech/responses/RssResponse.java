package com.example.nvmtech.responses;

import android.text.TextUtils;
import android.util.Patterns;

import com.example.nvmtech.IResult;
import com.example.nvmtech.models.apis.RssModel;
import com.example.nvmtech.utils.LoggerUtil;
import com.example.nvmtech.utils.RssParserUtil;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RssResponse {
    private static RssResponse instance = null;

    public static RssResponse getInstance(){
        if (instance == null){
            instance = new RssResponse();
        }

        return instance;
    }

    public void fetchRssByLink(String url, IResult callBack){
        if (TextUtils.isEmpty(url)) {
            return;
        }

        if (!Patterns.WEB_URL.matcher(url).matches()){
            return;
        }

        RssModel rssModel = null;

        try {
            final HttpClient httpClient = new DefaultHttpClient();
            final HttpResponse httpResponse = httpClient.execute(new HttpGet(url));
            final String xmlResult = EntityUtils.toString(httpResponse.getEntity(), "utf8");

            rssModel = RssParserUtil.getInstance().parseXmlToRssModel(xmlResult);
        } catch (IOException e){
            LoggerUtil.e("fetchRssByLink", "IOException", e);
        } catch (Exception e) {
            LoggerUtil.e("fetchRssByLink", "Exception", e);
        }

        callBack.abc(rssModel);
    }
}
