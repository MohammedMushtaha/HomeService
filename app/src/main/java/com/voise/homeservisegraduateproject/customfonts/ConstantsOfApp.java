package com.voise.homeservisegraduateproject.customfonts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.EditText;

import androidx.core.content.ContextCompat;

import com.voise.homeservisegraduateproject.R;

import java.util.Objects;



public class ConstantsOfApp {
    public static void InitialView(Context context, EditText editText) {
        ConstantsOfApp.SetColorToLineUnderView(context, editText, R.color.design_default_color_background);

    }
    @SuppressLint("NewApi")
    public static void SetColorToLineUnderView(Context context, View view, int colorResourcesId) {
        view.getBackground().mutate().setColorFilter(ContextCompat
                .getColor(Objects.requireNonNull(context), colorResourcesId), PorterDuff.Mode.SRC_ATOP);

    }
}
