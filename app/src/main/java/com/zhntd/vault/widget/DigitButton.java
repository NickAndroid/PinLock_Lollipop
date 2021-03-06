package com.zhntd.vault.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;

import com.zhntd.vault.R;
import com.zhntd.vault.secure.PinKey;
import com.zhntd.vault.secure.SecurityUtils;
import com.zhntd.vault.utils.Logger;

public class DigitButton extends Button {

    private PinKey mStandFor = PinKey.ZERO;

    private DigitButton(Context context) {
        super(context);
    }

    public DigitButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        readKeyFromAttrs(context, attrs);
    }

    public DigitButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        readKeyFromAttrs(context, attrs);
    }

    public DigitButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        readKeyFromAttrs(context, attrs);
    }

    private void readKeyFromAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.pin);
        String keyStr = array.getString(R.styleable.pin_key);
        if (keyStr != null)
            mStandFor = SecurityUtils.text2PinKey(keyStr);
        Logger.d("readKeyFromAttrs: key = " + mStandFor.toString(), getClass());
    }

    public PinKey getPinKey() {
        return mStandFor;
    }
}
