package com.softteco.codesample.adapters;

import android.content.Context;
import android.widget.BaseAdapter;

import com.softteco.codesample.model.Element;

import java.util.List;

public abstract class AdapterAbstract extends BaseAdapter {

    private List<Element> list;
    private Context context;

    public AdapterAbstract(final Context context, final List<Element> elements) {
        this.list = elements;
        this.context = context;
    }

    public List<Element> getList() {
        return this.list;
    }

    public Context getContext() {
        return this.context;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Element getItem(final int position) {
        return this.list.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return position;
    }

}
