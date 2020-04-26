package com.example.nvmtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nvmtech.databinding.ActivityMainBinding;
import com.example.nvmtech.utils.LoggerUtil;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        LoggerUtil.init(BuildConfig.IS_DEV == "false");
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainBinding.btnComeWithMe.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });
    }
}

