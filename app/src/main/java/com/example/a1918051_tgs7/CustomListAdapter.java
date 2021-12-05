package com.example.a1918051_tgs7;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<persipura> persipura;
    public CustomListAdapter(Activity activity, List<persipura> persipura) {
        this.activity = activity;
        this.persipura = persipura;
    }
    @Override
    public int getCount() {
        return persipura.size();
    }
    @Override
    public Object getItem(int location) { return persipura.get(location); }
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
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView nama_player = (TextView)
                convertView.findViewById(R.id.text_nama_player);
        TextView posisi = (TextView)
                convertView.findViewById(R.id.text_posisi);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        persipura p = persipura.get(position);
        nama_player.setText("Nama Player : "+ p.get_nama_player());
        posisi.setText("Posisition : "+ p.get_posisi());
        return convertView;
    }
}
