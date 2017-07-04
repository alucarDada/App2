package com.example.emedel.app2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> names = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        names.add("A");
        names.add("B");
        names.add("C");
        names.add("D");
        names.add("E");
        names.add("A");
        names.add("B");
        names.add("C");
        names.add("D");
        names.add("E");
        names.add("A");
        names.add("B");
        names.add("C");
        names.add("D");
        names.add("E");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, names);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Posicion: " + position + "\nLa letra es: " + names.get(position) + "\n Con id: " + id, Toast.LENGTH_LONG).show();
            }
        });

        MyAdapter myAdapter = new MyAdapter(this,R.layout.linea_item,names);
        listView.setAdapter(myAdapter);

    }
}

