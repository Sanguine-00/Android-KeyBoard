package com.mobcb.android.keyboard.demo.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.provider.Settings.System;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.view.WindowManager;
import android.widget.EditText;

public class BrightnessUtils {
    /**
     * 判断是否开启了自动亮度调节
     *
     * @param act
     * @return
     */
    public static boolean isAutoBrightness(Activity act) {
        boolean automicBrightness = false;
        ContentResolver aContentResolver = act.getContentResolver();
        try {
            automicBrightness = System.getInt(aContentResolver,
                    System.SCREEN_BRIGHTNESS_MODE) == System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC;
        } catch (Exception e) {
            e.printStackTrace();
            ToastUtils.showShort("无法获取亮度");
        }
        return automicBrightness;
    }

    /**
     * 改变亮度
     *
     * @param act
     * @param value
     */
    public static void SetLightness(Activity act, int value) {
        try {
            System.putInt(act.getContentResolver(), System.SCREEN_BRIGHTNESS,
                    value);
            WindowManager.LayoutParams lp = act.getWindow().getAttributes();
            lp.screenBrightness = (value <= 0 ? 1 : value) / 255f;
            act.getWindow().setAttributes(lp);
        } catch (Exception e) {
            e.printStackTrace();
            ToastUtils.showShort("无法改变亮度");
        }
    }

    /**
     * 获取亮度
     *
     * @param act
     * @return
     */
    public static int GetLightness(Activity act) {
        return System.getInt(act.getContentResolver(),
                System.SCREEN_BRIGHTNESS, -1);
    }

    /**
     * 停止自动亮度调节
     *
     * @param activity
     */
    public static void stopAutoBrightness(Activity activity) {
        System.putInt(activity.getContentResolver(),
                System.SCREEN_BRIGHTNESS_MODE,
                System.SCREEN_BRIGHTNESS_MODE_MANUAL);
    }

    /**
     * 开启亮度自动调节
     *
     * @param activity
     */
    public static void startAutoBrightness(Activity activity) {
        System.putInt(activity.getContentResolver(),
                System.SCREEN_BRIGHTNESS_MODE,
                System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC);
    }

    public static void setEdDecimal(EditText editText, int count) {
        if (count < 1) {
            count = 1;
        }

        editText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);

        //设置字符过滤
        final int finalCount = count;
        editText.setFilters(new InputFilter[]{new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals(".") && dest.toString().length() == 0) {
                    return "0.";
                }
                if (dest.toString().contains(".")) {
                    int index = dest.toString().indexOf(".");
                    int mlength = dest.toString().substring(index).length();
                    if (mlength == finalCount) {
                        return "";
                    }
                }
                return null;
            }
        }});
    }
}

