package com.softteco.codesample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softteco.codesample.R;
import com.softteco.codesample.model.Element;
import com.softteco.codesample.util.ViewHolder;

import java.util.List;

public class AdapterUIBuilder extends AdapterAbstract {

    public AdapterUIBuilder(final Context context, final List<Element> elements) {
        super(context, elements);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_ui_builder_element, parent, false);
        }
        TextView textView = ViewHolder.get(convertView, R.id.adapter_ui_builder_element_textview_desc);
        textView.setText(getList().get(position).getElementDescriptionResource());
        return convertView;
    }

    public void drop(final int from, final int to) {
        Element element = getList().remove(from);
        getList().add(to, element);
        notifyDataSetChanged();
    }

    public void remove(final int which) {
        getList().remove(which);
        notifyDataSetChanged();
    }

    public void add(final Element element) {
        getList().add(element);
        notifyDataSetChanged();
    }
}
