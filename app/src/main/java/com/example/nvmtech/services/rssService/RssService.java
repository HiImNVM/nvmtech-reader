package com.example.nvmtech.services.rssService;
import com.example.nvmtech.BuildConfig;
import com.example.nvmtech.models.apis.RssFeed;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;

public class RssService {
    private static final String BASE_URL = BuildConfig.RSS_URL;

    private RssApi mRssApi;

    private static RssService instance = null;

    public static RssService getInstance(){
        if (instance == null){
            instance = new RssService();
        }

        return instance;
    }

    private RssService() {
        final Retrofit.Builder builder = new Retrofit.Builder()
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .baseUrl(BASE_URL);

        initInterceptors(builder);
        final Retrofit mRetrofit = builder.build();
        mRssApi = mRetrofit.create(RssApi.class);
    }

    private void initInterceptors(Retrofit.Builder builder){
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // httpClient.addInterceptor(new LoggerInterceptor());
        builder.client(httpClient.build());
    }

    public RssApi getRssApi(){ return this.mRssApi; }

    public interface RssApi {
        @GET("/news/business/rss.xml") Call<RssFeed> getRssFeed();
    }
}