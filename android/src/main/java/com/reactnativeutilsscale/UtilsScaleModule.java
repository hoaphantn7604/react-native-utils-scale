package com.reactnativeutilsscale;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.util.HashMap;
import java.util.Map;
import com.facebook.react.bridge.Callback;

@ReactModule(name = UtilsScaleModule.NAME)
public class UtilsScaleModule extends ReactContextBaseJavaModule {
    public static final String NAME = "UtilsScale";

    private final ReactApplicationContext reactContext;

    public UtilsScaleModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put("checkTablet", isTablet());
        constants.put("checkSmallDevice", isSmallDevice());
        constants.put("deviceInch", deviceInch());
        constants.put("getModel", getModel());
        constants.put("getBrand", getBrand());

        return constants;
    }

    public boolean isTablet() {
        // TODO: Implement some actually useful functionality
        if ((reactContext.getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE) {
            return true;
        }
        return false;
    }

    public boolean isSmallDevice() {
        // TODO: Implement some actually useful functionality
        double screenInches = deviceInch();

        if (screenInches < 4.8) {
            return true;
        }
        return false;
    }

    public double deviceInch() {
        // TODO: Implement some actually useful functionality
        DisplayMetrics dm = reactContext.getResources().getDisplayMetrics();

        WindowManager windowManager = (WindowManager) reactContext.getSystemService(reactContext.WINDOW_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            windowManager.getDefaultDisplay().getRealMetrics(dm);
        } else {
            windowManager.getDefaultDisplay().getMetrics(dm);
        }

        double x = Math.pow(dm.widthPixels / dm.xdpi, 2);
        double y = Math.pow(dm.heightPixels / dm.xdpi, 2);
        double screenInches = Math.sqrt(x + y);

        if(screenInches < 30){
            return screenInches;
        }else {
            double density = dm.density * 160;
            double x2 = Math.pow(dm.widthPixels / density, 2);
            double y2 = Math.pow(dm.heightPixels / density, 2);
            double screenInches2 = Math.sqrt(x2 + y2);

            return screenInches2;
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
