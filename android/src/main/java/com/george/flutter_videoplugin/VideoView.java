package com.george.flutter_videoplugin;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugin.platform.PlatformView;

/**
 * Created By George
 * Description:
 */
public class VideoView implements PlatformView, MethodChannel.MethodCallHandler {

    private final android.widget.VideoView videoView;
    private final MethodChannel methodChannel;
    private final Registrar registrar;

    VideoView(Context context, int viewId, Object args, Registrar registrar) {
        Log.d("fcs-","android-VideoView");
        this.registrar = registrar;
        this.videoView = getJzvStd(registrar, args);
        this.methodChannel = new MethodChannel(registrar.messenger(), "bms_video_player_" + viewId);
        this.methodChannel.setMethodCallHandler(this);
    }


    @Override
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Log.d("fcs-","android-onMethodCall-methodCall.method:"+methodCall.method);
        switch (methodCall.method) {
            case "loadUrl":
                String url = methodCall.arguments.toString();
                videoView.setVideoPath(url);
                break;
            case "start":
                videoView.start();
                break;
            default:
                result.notImplemented();
        }
    }

    @Override
    public View getView() {
        return videoView;
    }

    @Override
    public void dispose() {

    }


    private android.widget.VideoView getJzvStd(Registrar registrar, Object args) {
        android.widget.VideoView view = (android.widget.VideoView) LayoutInflater.from(registrar.activity()).inflate(R.layout.jz_video, null);
        return view;
    }
}
