package com.example.a1918051_tgs7;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<persipura> Listpersipura = new ArrayList<persipura>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, Listpersipura);
        mListView = (ListView) findViewById(R.id.list_persipura);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        Listpersipura.clear();
        List<persipura> persipuraList = db.Readpersipura();
        for (persipura per : persipuraList) {
            persipura daftar = new persipura();
            daftar.set_id(per.get_id());
            daftar.set_nama_player(per.get_nama_player());
            daftar.set_posisi(per.get_posisi());
            Listpersipura.add(daftar);
            if ((Listpersipura.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        persipura detailper = (persipura) o;
        String Sid = detailper.get_id();
        String Snama_player = detailper.get_nama_player();
        String Sposisi = detailper.get_posisi();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama player", Snama_player);
        goUpdel.putExtra("Iposisi", Sposisi);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        Listpersipura.clear();
        mListView.setAdapter(adapter_off);
        List<persipura> persipuras = db.Readpersipura();
        for (persipura per : persipuras) {
            persipura daftar = new persipura();
            daftar.set_id(per.get_id());
            daftar.set_nama_player(per.get_nama_player());
            daftar.set_posisi(per.get_posisi());
            Listpersipura.add(daftar);
            if ((Listpersipura.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
