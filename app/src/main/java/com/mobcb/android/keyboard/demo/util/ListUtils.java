package com.mobcb.android.keyboard.demo.util;

import java.util.List;

/**
 * Created by lvmenghui
 * on 2018/3/23.
 */

public class ListUtils {

    /**
     * 判断列表是否为空
     *
     * @param list
     * @return
     */
    public static <T> boolean isEmpty(List<T> list) {
        if (list == null) {
            return true;
        } else if (list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断列表是否不为空
     *
     * @param list
     * @return
     */
    public static <T> boolean isNotEmpty(List<T> list) {
        return !ListUtils.isEmpty(list);
    }
}
