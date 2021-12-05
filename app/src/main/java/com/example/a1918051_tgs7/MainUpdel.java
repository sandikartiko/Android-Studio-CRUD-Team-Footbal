package com.example.a1918051_tgs7;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama_player, Sposisi;
    private EditText Enama_player, Eposisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama_player = i.getStringExtra("Inama player");
        Sposisi = i.getStringExtra("Iposisi");
        Enama_player = (EditText) findViewById(R.id.updel_nama_player);
        Eposisi = (EditText) findViewById(R.id.updel_posisi);
        Enama_player.setText(Snama_player);
        Eposisi.setText(Sposisi);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama_player = String.valueOf(Enama_player.getText());
                Sposisi = String.valueOf(Eposisi.getText());
                if (Snama_player.equals("")){
                    Enama_player.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama player",
                            Toast.LENGTH_SHORT).show();
                } else if (Sposisi.equals("")){
                    Eposisi.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi posisi",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.Updatepersipura(new persipura(Sid, Snama_player, Sposisi));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.Deletepersipura(new persipura(Sid, Snama_player, Sposisi));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
