package com.example.emedel.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private GridView gridView;
    private List<String> names = new ArrayList<String>();
    private MyAdapter myAdapter;
    private int bandera=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = (GridView) findViewById(R.id.gridView);

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

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridActivity.this, "Posicion: " + position + "\nLa letra es: " + names.get(position) + "\n Con id: " + id, Toast.LENGTH_LONG).show();
            }
        });

        myAdapter = new MyAdapter(this,R.layout.grid_item,names);
        gridView.setAdapter(myAdapter);

        registerForContextMenu(gridView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.addItem:
                this.names.add("Added No: "+ ++bandera);
                //Notifica al adaptador que cambio el numero del array
                this.myAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(names.get(info.position));
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.deleteItem:
                names.remove(info.position);
                this.myAdapter.notifyDataSetChanged();
            default:
                return super.onContextItemSelected(item);
        }
    }

}
