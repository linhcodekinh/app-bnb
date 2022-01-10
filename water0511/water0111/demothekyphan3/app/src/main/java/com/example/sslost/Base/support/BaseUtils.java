package com.example.sslost.Base.support;


import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BaseUtils {
    private static final String TAG = "BaseUtils";

    private static Context mApplicationContext = null;
    public static void setApplicationContext(Context context) {
        mApplicationContext = context;
    }

    public static Context getApplicationContext() {
        return mApplicationContext;
    }

    private static int mHasSoftKey = -1;
    public static boolean hasSoftKey() {
        if (mHasSoftKey == -1) {
            try {
                mHasSoftKey = (KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK) ? 0 : 1);
            } catch (Exception e) {
                return false;
            }
        }
        Log.d(TAG, "hasSoftKey " + mHasSoftKey);
        return mHasSoftKey == 1;
    }

    public static void copyFile(String src, String dst) throws IOException {
        File dstName = new File(dst);
        FileInputStream inStream = null;
        FileOutputStream outStream = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bio = null;

        try {
            inStream = new FileInputStream(src);
            outStream = new FileOutputStream(dstName);
            bis = new BufferedInputStream(inStream);
            bio = new BufferedOutputStream(outStream);
            byte[] buf = new byte[1024];
            int len;
            while ((len = bis.read(buf)) > 0) {
                bio.write(buf, 0, len);
            }
        } catch (IOException e) {
            Log.d(TAG, "copyFile : " + e.getMessage());
            throw e;
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (inStream != null) {
                    inStream.close();
                }
                if (bio != null) {
                    bio.close();
                }
                if (outStream != null) {
                    outStream.close();
                }
            } catch (IOException e) {
                Log.d(TAG, "copyFile : " + e.getMessage());
            }
        }
    }

    public static void copyFileFromContentUri(Context context, Uri srcUri, String dst) throws IOException {
        File dstName = new File(dst);
        FileOutputStream outStream = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bio = null;
        InputStream uriInputStream = null;

        try {
            uriInputStream = context.getContentResolver().openInputStream(srcUri);
            outStream = new FileOutputStream(dstName);
            bis = new BufferedInputStream(uriInputStream);
            bio = new BufferedOutputStream(outStream);
            byte[] buf = new byte[1024];
            int len;
            while ((len = bis.read(buf)) > 0) {
                bio.write(buf, 0, len);
            }
        } catch (IOException e) {
            Log.d(TAG, "copyFile : " + e.getMessage());
            throw e;
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }

                if (uriInputStream != null) {
                    uriInputStream.close();
                }

                if (bio != null) {
                    bio.close();
                }

                if (outStream != null) {
                    outStream.close();
                }
            } catch (IOException e) {
                Log.d(TAG, "copyFile : " + e.getMessage());
            }
        }
    }
}
