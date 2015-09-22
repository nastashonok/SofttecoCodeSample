package com.softteco.codesample.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentAbstract extends Fragment {

    protected static final String ARGS_CONTENT = "ARGS_CONTENT";

    private FragmentListener fragmentListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentListener = (FragmentListener) context;
        } catch (ClassCastException classCastException) {
            throw new IllegalAccessError("Activity MUST implement FragmentListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayoutId(), container, false);
    }

    protected abstract int getFragmentLayoutId();

    public FragmentListener getFragmentListener() {
        return fragmentListener;
    }

    public boolean onBackPressed() {
        return false;
    }
}
