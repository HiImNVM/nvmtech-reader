package com.example.nvmtech;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.nvmtech.databinding.ActivityHomeBinding;
import com.example.nvmtech.models.apis.RssItemModel;
import com.example.nvmtech.models.apis.RssModel;
import com.example.nvmtech.responses.RssResponse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding homeBinding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);


//        AsyncTask.execute(new Runnable() {
//            @Override
//            public void run() {
//                RssResponse.getInstance().fetchRssByLink(BuildConfig.RSS_URL, new IResult() {
//                    @Override
//                    public void abc(RssModel rssModel) {
//                        final List<RssItemModel> rssItemModels = rssModel.getItems();
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                homeBinding.rvRssItems.setAdapter(new HomeRecyclerAdapter(rssItemModels));
//                                homeBinding.rvRssItems.setLayoutManager(new LinearLayoutManager(homeBinding.getRoot().getContext()));
//                            }
//                        });
//                    }
//                });
//            }
//        });

    }
}
