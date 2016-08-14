package com.dylan.scalex.util;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Used to declare common methods
 */
public class LMUtils {

    public static float scalePixel(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels / 320;
    }

    public static float scaleDensity(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels / displayMetrics.density / 320;
    }
}
