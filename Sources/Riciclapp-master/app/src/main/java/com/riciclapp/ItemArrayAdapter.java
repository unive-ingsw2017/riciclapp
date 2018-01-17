package com.riciclapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemArrayAdapter extends ArrayAdapter<String[]> {
	private List<String[]> scoreList = new ArrayList<String[]>();
	public int category, count;

    static class ItemViewHolder {
        TextView name;
        TextView score;
    }

    public ItemArrayAdapter(int cat, Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        category = cat;
    }

    public void position(int val){
        count = val;
    }

	@Override
	public void add(String[] object) {
        try {
            Float.valueOf(object[category]);
            scoreList.add(object);
            super.add(object);
        }
        catch ( NumberFormatException e ) {
            if (category == 0){
                scoreList.add(object);
                super.add(object);

            }
        }
        //ordinamento
	}

    @Override
	public int getCount() {
		return this.scoreList.size();
	}

    @Override
	public String[] getItem(int index) {
		return this.scoreList.get(index);
	}

    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
        ItemViewHolder viewHolder;
		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) this.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.item_layout, parent, false);
            viewHolder = new ItemViewHolder();
            viewHolder.name = (TextView) row.findViewById(R.id.name);
            viewHolder.score = (TextView) row.findViewById(R.id.score);
            row.setTag(viewHolder);
		} else {
            viewHolder = (ItemViewHolder)row.getTag();
        }
        String[] linea = getItem(position);

        viewHolder.name.setText(linea[1]);
        switch (category) {
            case 0:
                break;
            case 3:
                writeText(linea, viewHolder, category);
                break;
            case 4:
                writeText(linea, viewHolder, category);
                break;
            case 5:
                writeText(linea, viewHolder, category);
                break;
            case 6:
                writeText(linea, viewHolder, category);
                break;
            case 7:
                writeText(linea, viewHolder, category);
                break;
            case 17:
                viewHolder.score.setText(linea[17]+ "%");
                break;
            case 16:
                writeText(linea, viewHolder, category);
                break;
        }
		return row;
	}

	public void writeText (String[] row, ItemViewHolder viewHolder, int cat){
        String[] linea = row;
        float population = Float.valueOf(linea[2]);
        float elem = -1;
        try {
            elem = Float.valueOf(linea[cat]);
        }
        catch ( NumberFormatException e ) {
        }
        if (elem != -1){
            float res = 0;
            if (population != 0){
                res = elem / population;
            }
            viewHolder.score.setText((String.valueOf(res)));
        }
        else {
            viewHolder.score.setText(linea[cat]);
        }
    }
}
