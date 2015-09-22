package com.softteco.codesample.model;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class Element implements Parcelable {

    public static final int ELEMENT_ID_BUTTON = 0;
    public static final int ELEMENT_ID_INPUT_FIELD = 1;
    public static final int ELEMENT_ID_SPINNER = 2;
    public static final int ELEMENT_ID_STATIC = 3;

    private final int elementId;
    private final String title;

    public Element(final int elementId, final String title) {
        this.elementId = elementId;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getElementId() {
        return elementId;
    }

    public abstract int getElementDescriptionResource();

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
