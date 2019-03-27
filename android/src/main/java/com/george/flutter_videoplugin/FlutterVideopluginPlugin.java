package com.george.flutter_videoplugin;

import android.util.Log;

import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * FlutterVideopluginPlugin
 */
public class FlutterVideopluginPlugin {
    /**
     * Plugin registration.
     */
    public static void registerWith(Registrar registrar) {
        Log.d("fcs-","android-registerWith");
        registrar.platformViewRegistry().registerViewFactory("plugins.bms_video_player/view", new VideoViewFactory(registrar));
    }
}
