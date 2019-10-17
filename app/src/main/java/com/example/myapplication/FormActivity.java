package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Entity.Item;
import com.example.myapplication.dao.ItemDAO;

public class FormActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etEmail;
    private Button btnSalvar;
    private Item item;
    private ItemDAO itemDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        itemDAO = new ItemDAO(getApplicationContext());

        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Clicou", Toast.LENGTH_SHORT).show();
                item  = new Item(etNome.getText().toString(), etEmail.getText().toString());
                itemDAO.insert(item);

                Intent resultIntent = new Intent();
                resultIntent.putExtra("item", item);
                setResult(1,resultIntent);
                finish();
            }
        });

        item = getIntent().getExtras().getParcelable("item");
        etNome.setText(item.getNome());
        etEmail.setText(item.getEmail());

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
}
