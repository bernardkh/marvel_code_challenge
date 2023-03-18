package com.marvel.utils;
/**
 * Created by Bernard Khadra on 9/15/15.
 */
public class Logger {

    private static final String mTag = "Logger";
    public static final boolean mDebug = false;

    public static int v(String msg) {
        if (mDebug) {
            return android.util.Log.v(mTag, msg);
        }
        return 0;
    }

    public static int v(String tag, String msg) {
        if (mDebug) {
            return android.util.Log.v(tag, msg);
        }
        return 0;
    }

    public static int v(String msg, Throwable tr) {
        if (mDebug) {
            return android.util.Log.v(mTag, msg, tr);
        }
        return 0;
    }

    public static int v(String tag, String msg, Throwable tr) {
        if (mDebug) {
            return android.util.Log.v(tag, msg, tr);
        }
        return 0;
    }

    public static int d(String msg) {
        if (mDebug) {
            return android.util.Log.d(mTag, msg);
        }
        return 0;
    }

    public static int d(String tag, String msg) {
        if (mDebug) {
            return android.util.Log.d(tag, msg);
        }
        return 0;
    }

    public static int d(String msg, Throwable tr) {
        if (mDebug) {
            return android.util.Log.d(mTag, msg, tr);
        }
        return 0;
    }

    public static int d(String tag, String msg, Throwable tr) {
        if (mDebug) {
            return android.util.Log.d(tag, msg, tr);
        }
        return 0;
    }

    public static int i(String msg) {
        if (mDebug) {
            return android.util.Log.i(mTag, msg);
        }
        return 0;
    }

    public static int i(String tag, String msg) {
        if (mDebug) {
            return android.util.Log.i(tag, msg);
        }
        return 0;
    }

    public static int i(String msg, Throwable tr) {
        if (mDebug) {
            return android.util.Log.i(mTag, msg, tr);
        }
        return 0;
    }

    public static int i(String tag, String msg, Throwable tr) {
        if (mDebug) {
            return android.util.Log.i(tag, msg, tr);
        }
        return 0;
    }

    public static int w(String msg) {
        if (mDebug) {
            return android.util.Log.w(mTag, msg);
        }
        return 0;
    }

    public static int w(String tag, String msg) {
        if (mDebug) {
            return android.util.Log.w(tag, msg);
        }
        return 0;
    }

    public static int w(String msg, Throwable tr) {
        if (mDebug) {
            return android.util.Log.w(mTag, msg, tr);
        }
        return 0;
    }

    public static int w(String tag, String msg, Throwable tr) {
        if (mDebug) {
            return android.util.Log.w(tag, msg, tr);
        }
        return 0;
    }

    public static int e(String msg) {
        if (mDebug) {
            return android.util.Log.e(mTag, msg);
        }
        return 0;
    }

    public static int e(String tag, String msg) {
        if (mDebug) {
            return android.util.Log.e(tag, msg + "");
        }
        return 0;
    }

    public static int e(String msg, Throwable tr) {
        if (mDebug) {
            return android.util.Log.e(mTag, msg, tr);
        }
        return 0;
    }

    public static int e(String tag, String msg, Throwable tr) {
        if (mDebug) {
            return android.util.Log.e(tag, msg, tr);
        }
        return 0;
    }

    public static int t(String msg, Object... args) {
        if (mDebug) {
            return android.util.Log.v(mTag, String.format(msg, args));
        }
        return 0;
    }
}
