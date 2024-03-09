package com.example.android5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] items = {"Item 1", "Item 2", "Item 3"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        listView = findViewById(R.id.listView);
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
//        listView.setAdapter(adapter);
//
//        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        switch (item.getItemId()) {
            case R.id.menu_red:
                if (listView.getChildAt(position) != null) {
                    listView.getChildAt(position).setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                }
                return true;
            case R.id.menu_green:
                if (listView.getChildAt(position) != null) {
                    listView.getChildAt(position).setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                }
                return true;
            case R.id.menu_yellow:
                if (listView.getChildAt(position) != null) {
                    listView.getChildAt(position).setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                }
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_sort:
                // Implement sorting logic here
                return true;
            case R.id.menu_delete:
                adapter.clear(); // Clear the adapter to delete all items
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
