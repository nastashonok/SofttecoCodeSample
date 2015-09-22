package com.softteco.codesample.util.filters;

import android.text.InputFilter;
import android.text.Spanned;


public abstract class AbstractFilter implements InputFilter {

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        if (source.equals("")) {
            return source;
        }
        if (source.toString().matches(getPattern())) {
            return source;
        }
        return "";
    }

    protected abstract String getPattern();
}
