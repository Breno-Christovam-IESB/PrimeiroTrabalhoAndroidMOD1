package com.breno.primeirotrabalhoandroidmod1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ListView listView;
    private EditText editText;
    private Button addButton;
    private Button removeButton;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editText);
        addButton = findViewById(R.id.addButton);
        removeButton = findViewById(R.id.removeButton);

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

