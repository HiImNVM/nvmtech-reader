package com.example.nvmtech.utils;

import android.util.Log;

import androidx.annotation.Nullable;

import com.example.nvmtech.BuildConfig;

import org.jetbrains.annotations.NotNull;

import timber.log.Timber;

public final class LoggerUtil {

    private LoggerUtil() {
        // This utility class is not publicly instantiable
    }

    public static void d(String s, Object... objects) {
        Timber.d(s, objects);
    }

    public static void d(Throwable throwable, String s, Object... objects) {
        Timber.d(throwable, s, objects);
    }

    public static void e(String s, Object... objects) {
        Timber.e(s, objects);
    }

    public static void e(Throwable throwable, String s, Object... objects) {
        Timber.e(throwable, s, objects);
    }

    public static void i(String s, Object... objects) {
        Timber.i(s, objects);
    }

    public static void i(Throwable throwable, String s, Object... objects) {
        Timber.i(throwable, s, objects);
    }

    public static void init(boolean isProd) {
        if (isProd) {
            Timber.plant(new ReleaseTree());
            return;
        }

        Timber.plant(new Timber.DebugTree());
    }

    public static void w(String s, Object... objects) {
        Timber.w(s, objects);
    }

    public static void w(Throwable throwable, String s, Object... objects) {
        Timber.w(throwable, s, objects);
    }

    private static class ReleaseTree extends Timber.Tree {
        @Override
        protected void log(int priority, @Nullable String tag,
                           @NotNull String message, @Nullable Throwable t) {
            if (priority == Log.ERROR || priority == Log.WARN){
                // TODO: Should be add library to observe log when error and warn
            }
        }
    }
}
