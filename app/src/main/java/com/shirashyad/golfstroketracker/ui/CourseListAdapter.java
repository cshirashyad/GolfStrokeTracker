package com.shirashyad.golfstroketracker.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.shirashyad.golfstroketracker.R;
import com.shirashyad.golfstroketracker.databinding.RowItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chandra.shirashyad on 12/6/17.
 */

public class CourseListAdapter extends BaseAdapter implements Filterable {

    List<String> mData;
    List<String> mStringFilterList;
    ValueFilter valueFilter;
    private LayoutInflater inflater;

    public CourseListAdapter(List<String> cancel_type) {
        mData = cancel_type;
        mStringFilterList = cancel_type;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        RowItemBinding rowItemBinding = DataBindingUtil.inflate(inflater, R.layout.row_item, parent, false);
        rowItemBinding.stringName.setText(mData.get(position));

        return rowItemBinding.getRoot();
    }

    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                List filterList = new ArrayList();
                for (int i = 0; i < mStringFilterList.size(); i++) {
                    if ((mStringFilterList.get(i).toUpperCase()).contains(constraint.toString().toUpperCase())) {
                        filterList.add(mStringFilterList.get(i));
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mStringFilterList.size();
                results.values = mStringFilterList;
            }
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            mData = (List) results.values;
            notifyDataSetChanged();
        }

    }

}