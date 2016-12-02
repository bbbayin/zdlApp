package com.zdl.util;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by bayin on 2016/12/2.
 */

public class ImageUtil {
    private static LruCache<String, Bitmap> mLruCache;

    public static void cacheImage(Context context, String key, Bitmap bitmap) {
        init(context);
        if (get(context,key) == null)
            mLruCache.put(key, bitmap);
    }

    public static Bitmap get(Context context, String key) {
        if (mLruCache == null) init(context);
        return mLruCache.get(key);
    }

    private static void init(Context context) {
        if (mLruCache == null) {
            synchronized (ImageUtil.class) {
                ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
                int memoryClass = manager.getMemoryClass();
                mLruCache = new LruCache<String, Bitmap>(1024 * 1024 * memoryClass / 8) {
                    @Override
                    protected int sizeOf(String key, Bitmap bitmap) {
                        // 重写此方法来衡量每张图片的大小，默认返回图片数量。
                        return bitmap.getByteCount() / 1024;
                    }
                };
            }
        }
    }


}
