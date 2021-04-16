package com.voise.homeservisegraduateproject.customfonts;
import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;


public class MirvaEditText extends AppCompatEditText {
    public MirvaEditText(Context context) {
        super(context);
        ConstantsOfApp.InitialView(context,this);
//        requestFocus();
    }

    public MirvaEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        ConstantsOfApp.InitialView(context,this);

    }

     public MirvaEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ConstantsOfApp.InitialView(context,this);
//        requestFocus();
    }

}
