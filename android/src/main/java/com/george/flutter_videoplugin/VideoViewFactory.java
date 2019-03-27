package com.george.flutter_videoplugin;

import android.content.Context;
import android.util.Log;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

/**
 * Created By George
 * Description:
 */
public class VideoViewFactory extends PlatformViewFactory {

    private final PluginRegistry.Registrar registrar;

    public VideoViewFactory(PluginRegistry.Registrar registrar) {
        super(StandardMessageCodec.INSTANCE);
        Log.d("fcs-","android-VideoViewFactory");
        this.registrar = registrar;
    }

    @Override
    public PlatformView create(Context context, int viewId, Object args) {
        Log.d("fcs-","android-VideoViewFactory-create");
        return new VideoView(context, viewId, args, this.registrar);
    }

}
