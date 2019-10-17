package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.myapplication.Adapter.ListaAdapter;
import com.example.myapplication.Entity.Item;
import com.example.myapplication.db.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity {

    private List<Item> itens;
    private ListView listItens;
    private Button btnAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        DataBaseHelper.getHelper(getApplicationContext()).getWritableDatabase();
        itens = new ArrayList<>();

        listItens = findViewById(R.id.listItens);
        listItens.setAdapter(new ListaAdapter(getApplicationContext(), itens));

        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), FormActivity.class);
                i.putExtra("item", new Item());
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            Item item = data.getParcelableExtra("item");
            itens.add(item);
        }
    }

}
