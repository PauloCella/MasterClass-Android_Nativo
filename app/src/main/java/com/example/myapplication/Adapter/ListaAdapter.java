package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.Entity.Item;
import com.example.myapplication.R;

import java.util.List;

public class ListaAdapter extends ArrayAdapter<Item> {

	public ListaAdapter(Context context, List<Item> objects) {
		super(context, R.layout.list_itens_adapter, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) this.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.list_item_entry, parent, false);
		}
		
		Item item = getItem(position);

        ((TextView)row.findViewById(R.id.tvNome)).setText(item.getNome());
        ((TextView)row.findViewById(R.id.tvEmail)).setText(item.getEmail());

		return row;
	}

}
