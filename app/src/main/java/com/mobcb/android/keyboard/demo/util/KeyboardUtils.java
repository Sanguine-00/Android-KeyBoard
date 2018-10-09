package com.mobcb.android.keyboard.demo.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by lvmenghui
 * on 2018/3/22.
 */

public class KeyboardUtils {

    /**
     * 显示键盘
     *
     * @param paramEditText
     */
    public static void showKeyboard(final View paramEditText) {
        paramEditText.requestFocus();
        paramEditText.postDelayed(new Runnable() {
            @Override
            public void run() {
                ((InputMethodManager) paramEditText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(paramEditText, InputMethodManager.SHOW_FORCED);
            }
        }, 500L);
    }

    /**
     * 隐藏键盘
     *
     * @param paramEditText
     */
    public static void hideKeyboard(View paramEditText) {
        try {
            ((InputMethodManager) paramEditText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(paramEditText.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取软键盘高度
     *
     * @param paramActivity
     * @return
     */
    public static int getKeyboardHeight(Activity paramActivity) {
        int height = ScreenUtils.getScreenHeight() - ScreenUtils.getStatusBarHeight()
                - ScreenUtils.getAppHeight(paramActivity);

        return height;
    }

    /**
     * 判断软键盘是否弹出
     *
     * @param paramActivity
     * @return
     */
    public static boolean isKeyboardShow(Activity paramActivity) {
        int height = ScreenUtils.getScreenHeight() - ScreenUtils.getStatusBarHeight()
                - ScreenUtils.getAppHeight(paramActivity);
        return height != 0;
    }
}
