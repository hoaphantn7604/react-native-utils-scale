package com.utils.scale;

import android.os.Build;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.Map;
import android.view.WindowManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class UtilsScaleModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public UtilsScaleModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "UtilsScale";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put("checkTablet", isTablet());
        constants.put("getModel", getModel());
        constants.put("getBrand", getBrand());
        return constants;
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }

    public boolean isTablet() {
        // TODO: Implement some actually useful functionality
        if(getDeviceType() == "Tablet"){
            return true;
        }else {
            return false;
        }
    }

    private String getDeviceType() {
        // Find the current window manager, if none is found we can't measure the device physical size.
        WindowManager windowManager = (WindowManager) reactContext.getSystemService(reactContext.WINDOW_SERVICE);

        if (windowManager == null) {
            return "unknown";
        }

        DisplayMetrics metrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            windowManager.getDefaultDisplay().getRealMetrics(metrics);
        } else {
            windowManager.getDefaultDisplay().getMetrics(metrics);
        }

        float yInches= metrics.heightPixels/metrics.ydpi;
        float xInches= metrics.widthPixels/metrics.xdpi;
        double diagonalInches = Math.sqrt(xInches*xInches + yInches*yInches);

        if (diagonalInches>=6.5){
            return "Tablet";
        }else{
            // smaller device
            return "Phone";
        }
    }

    public String getModel() {
        // TODO: Implement some actually useful functionality
        String modelName = Build.MODEL;

        return modelName;
    }

    public String getBrand() {
        // TODO: Implement some actually useful functionality
        String manufacturer = Build.MANUFACTURER;
        
        return manufacturer;
    }
}
