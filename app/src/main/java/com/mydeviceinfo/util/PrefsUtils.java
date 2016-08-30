package com.mydeviceinfo.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by dongheelee on 2016. 6. 19..
 */
public class PrefsUtils {
	public static void putString
			(Context context, String key, String value)
	{
		SharedPreferences prefs =
				PreferenceManager.getDefaultSharedPreferences(context);

		SharedPreferences.Editor editor = prefs.edit();

		editor.putString(key, value);
		editor.commit();
	}

	public static String getString
			(Context context, String key)
	{
		SharedPreferences prefs =
				PreferenceManager.getDefaultSharedPreferences(context);

		return prefs.getString(key, null);
	}

	public static void putLong
			(Context context, String key, long value)
	{
		SharedPreferences prefs =
				PreferenceManager.getDefaultSharedPreferences(context);

		SharedPreferences.Editor editor = prefs.edit();

		editor.putLong(key, value);
		editor.commit();
	}

	public static long getLong
			(Context context, String key)
	{
		SharedPreferences prefs =
				PreferenceManager.getDefaultSharedPreferences(context);

		return prefs.getLong(key, 0L);
	}
}
