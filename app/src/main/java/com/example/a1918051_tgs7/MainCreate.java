package com.example.a1918051_tgs7;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama_player, Eposisi;
    private String Snama_player, Sposisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama_player = (EditText) findViewById(R.id.create_nama_player);
        Eposisi = (EditText) findViewById(R.id.create_posisi);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama_player = String.valueOf(Enama_player.getText());
                Sposisi = String.valueOf(Eposisi.getText());
                if (Snama_player.equals("")) {
                    Enama_player.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Player", Toast.LENGTH_SHORT).show();
                } else if (Sposisi.equals("")) {
                    Eposisi.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Posisi",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enama_player.setText("");
                    Eposisi.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.Createpersipura(new persipura(null, Snama_player, Sposisi));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
