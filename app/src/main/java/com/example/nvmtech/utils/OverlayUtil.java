package com.example.nvmtech.utils;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.example.nvmtech.R;

public class OverlayUtil {
    public static void showOverlayWaiting(OverlayWaiting overlayWaiting, FragmentManager fragmentManager){

        if (fragmentManager == null) {
            return;
        }
        overlayWaiting.setCancelable(false);
        overlayWaiting.show(fragmentManager, null);
    }

    public static void close(OverlayWaiting overlayWaiting){
        if (overlayWaiting != null){
            overlayWaiting.dismiss();
        }
    }

    public static class OverlayWaiting extends DialogFragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.frame_progress_overlay, container, false);
        }
    }
}
