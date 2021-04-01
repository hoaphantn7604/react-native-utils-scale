package com.reactlibrary;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.util.HashMap;
import java.util.Map;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

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
        TelephonyManager manager = (TelephonyManager)reactContext.getSystemService(reactContext.TELEPHONY_SERVICE);
        if(manager.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE){
            return true;
        }else{
            return false;
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
