package com.utils.scale;

import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;

import java.util.HashMap;
import java.util.Map;

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
        constants.put("checkSmallDevice", isSmallDevice());
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
        if ((reactContext.getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE) {
            return true;
        }
        return false;
    }

    public boolean isSmallDevice() {
        // TODO: Implement some actually useful functionality
        DisplayMetrics dm = reactContext.getResources().getDisplayMetrics();

        double density = dm.density * 155;
        double x = Math.pow(dm.widthPixels / density, 2);
        double y = Math.pow(dm.heightPixels / density, 2);
        double screenInches = Math.sqrt(x + y);

        if (screenInches < 5.5) {
            return true;
        }
        return false;
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
