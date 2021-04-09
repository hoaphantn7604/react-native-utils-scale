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
        if(getDeviceType() == "Large"){
            return true;
        }else {
            return false;
        }
    }

    public boolean isSmallDevice() {
        // TODO: Implement some actually useful functionality
        if(getDeviceType() == "Small"){
            return true;
        }else {
            return false;
        }
    }

    private String getDeviceTypeFromResourceConfiguration() {
        int smallestScreenWidthDp = reactContext.getResources().getConfiguration().smallestScreenWidthDp;

        if (smallestScreenWidthDp == Configuration.SMALLEST_SCREEN_WIDTH_DP_UNDEFINED) {
            return "UNKNOWN";
        }
        if(smallestScreenWidthDp >= 600){
            return "Large";
        }else{
            return "Normal";
        }

    }
    
    private String getDeviceType() {
        String deviceTypeFromConfig = getDeviceTypeFromResourceConfiguration();

        if(deviceTypeFromConfig != null && deviceTypeFromConfig != "UNKNOWN") {
            return deviceTypeFromConfig;
        }

        DisplayMetrics metrics =  reactContext.getResources().getDisplayMetrics();

        float yInches= metrics.heightPixels/(metrics.ydpi * 100);
        float xInches= metrics.widthPixels/(metrics.xdpi * 100);
        double diagonalInches = Math.sqrt(xInches*xInches + yInches*yInches);

        if (diagonalInches >= 6.5){
            return "Large";
        }else{
            if (diagonalInches < 6.5 && diagonalInches >= 5.5){
                return "Normal";
            }else{
                return "Small";
            }
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
