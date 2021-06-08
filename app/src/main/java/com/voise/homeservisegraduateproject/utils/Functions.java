package com.voise.homeservisegraduateproject.utils;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.developer.kalert.KAlertDialog;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.voise.homeservisegraduateproject.ui.auth.login.LoginActivity;


public class Functions {
    KProgressHUD hud;

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

//    public ProgressDialog pDialog;
    private static Functions Instanse;

    public static Functions getInstanse() {
        if (null == Instanse) {
            Instanse = new Functions();
        }
        return Instanse;
    }

    public  void showDialog(Context context,String text) {
        hud = KProgressHUD.create(context)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel(text)
                .setDetailsLabel("q")
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();
    }

    public   void hideDialog() {
        if (hud.isShowing())
            hud.dismiss();
    }
    public void diaLog(Context context, String TitleText, String ContentText, String ConfirmText) {
        new KAlertDialog(context)
                .setTitleText(TitleText)
                .setContentText(ContentText)
                .setConfirmText(ConfirmText)

                .show();
    }
    public void click_out(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void OpenKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void CloseKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.showSoftInput(view, 0);

        }
    }

}
