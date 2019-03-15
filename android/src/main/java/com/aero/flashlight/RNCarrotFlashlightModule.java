
package com.aero.flashlight;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.util.Log;

public class RNCarrotFlashlightModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNCarrotFlashlightModule(ReactApplicationContext reactContext) {
    private Camera camera;
    private Boolean isLightOn = false;
    private final ReactApplicationContext myReactContext;
    public CameraControlUtil(ReactApplicationContext reactContext) {
        super(reactContext);
        this.myReactContext = reactContext;
    }
  }

  @Override
  public String getName() {
    return "RNCarrotFlashlight";
  }

   /**
     * @param isOpen 控制手电筒开关，true:打开，false：关闭
     * @param callback 回调
     */
    @ReactMethod
    public void setFlashlight(Boolean isOpen, Callback callback) {
        isLightOn = isOpen;
            Camera.Parameters params;
            if (isLightOn) {
                camera = Camera.open();
                params = camera.getParameters();
                params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(params);
                camera.startPreview();
            } else {
                params = camera.getParameters();
                params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(params);
                camera.stopPreview();
                camera.release();
            }
        failCallback.invoke(true,"操作成功！");
    }

    private boolean isM() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return true;
        } else {
            return false;
        }
    }
}