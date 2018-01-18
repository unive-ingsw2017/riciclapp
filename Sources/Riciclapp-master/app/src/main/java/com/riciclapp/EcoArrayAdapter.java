package com.riciclapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EcoArrayAdapter extends ArrayAdapter<String[]> {
	private List<String[]> ecoList = new ArrayList<String[]>();
	public String provincia;

    static class EcoViewHolder {
        TextView name;
        TextView score;
    }

    public EcoArrayAdapter(String prov, Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        provincia = prov;
    }

	@Override
	public void add(String[] object) {
        if (object[3].equals(provincia)){
            ecoList.add(object);
            super.add(object);
            Collections.sort(ecoList, new Comparator<String[]>() {
                @Override
                public int compare(String[] lhs, String[] rhs) {
                    // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                    return lhs[5].compareTo(rhs[5]);
                }
            });
        }
	}

    @Override
	public int getCount() {
		return this.ecoList.size();
	}

    @Override
	public String[] getItem(int index) {
		return this.ecoList.get(index);
	}

    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
        EcoViewHolder viewHolder;
		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) this.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.item_layout, parent, false);
            viewHolder = new EcoViewHolder();
            viewHolder.name = (TextView) row.findViewById(R.id.name);
            viewHolder.score = (TextView) row.findViewById(R.id.score);
            row.setTag(viewHolder);
		} else {
            viewHolder = (EcoViewHolder)row.getTag();
        }
        String[] linea = getItem(position);

        viewHolder.name.setText(linea[5]);

		return row;
	}

}
