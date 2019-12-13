package com.example.artpreparation.crud;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.artpreparation.R;
import com.example.artpreparation.crud.Alat;

import java.util.List;

public class CustomListAdapter extends BaseAdapter{
    private Activity activity;
    private LayoutInflater inflater;
    private List<Alat> movieItems;

    public CustomListAdapter(Activity activity, List<Alat> movieItems)
    {
        this.activity = activity;
        this.movieItems = movieItems;
    }

    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);

        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView jenis = (TextView) convertView.findViewById(R.id.text_jenis);
        TextView fungsi = (TextView) convertView.findViewById(R.id.text_fungsi);

        Alat m = movieItems.get(position);

        nama.setText("Nama : "+ m.get_nama());
        jenis.setText("Jenis : "+ m.get_jenis());
        fungsi.setText("Fungsi : "+ m.get_fungsi());

        return convertView;     }
}
