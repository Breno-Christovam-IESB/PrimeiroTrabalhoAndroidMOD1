package com.breno.primeirotrabalhoandroidmod1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.breno.primeirotrabalhoandroidmod1.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tv_login;

    private Button bt_light, bt_dark, bt_os;

    private ListView listView;
    private EditText editText;
    private Button addButton;
    private Button removeButton;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.et_name);
        addButton = findViewById(R.id.addButton);
        removeButton = findViewById(R.id.removeButton);

        tv_login = findViewById(R.id.tv_login);
        bt_light = findViewById(R.id.bt_light);
        bt_dark = findViewById(R.id.bt_dark);
        bt_os = findViewById(R.id.bt_os);

        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarTexto();
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removerTexto();
            }
        });

        Intent intent = getIntent();
        String loginReceived = intent.getStringExtra("KEY_EMAIL");
//        int numberReceived = intent.getIntExtra("KEY_NUMBER", 0);
        tv_login.setText("Olá " + loginReceived);

//        System.out.println("Email: " + loginReceived);

        bt_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

            }
        });
        bt_dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

            }
        });
        bt_os.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

            }
        });
    }
    private void adicionarTexto() {
        String novoTexto = editText.getText().toString();
        if (!novoTexto.isEmpty()) {
            itemList.add(novoTexto);
            adapter.notifyDataSetChanged();
            editText.setText(""); // Limpar o campo de texto
        }
    }

    private void removerTexto() {
        if (itemList.size() > 0) {
            itemList.remove(itemList.size() - 1);
            adapter.notifyDataSetChanged();
        }
    }
}