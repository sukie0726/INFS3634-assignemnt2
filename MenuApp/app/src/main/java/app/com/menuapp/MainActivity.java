package app.com.menuapp;

import android.content.Intent;
import android.hardware.Sensor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Item> items;
    MenuAdapter adapter;
    Button viewOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        viewOrder = findViewById(R.id.viewOrder);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);


        items = new ArrayList<>();
        adapter = new MenuAdapter(items, getApplicationContext());
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, Item item, int position) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra("item", item);
                startActivity(intent);
            }
        });

        viewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ViewOrderActivity.class);
                startActivity(intent);
            }
        });
        setSensorList();
    }

    private void setSensorList() {
        Item[] array = new Item[] {new Item("Apple",2.4,"Apple", R.drawable.apple),
                new Item("Chili",5.2,"Chili", R.drawable.chili),
                new Item("Grape",8.2,"Grape", R.drawable.grape),
                new Item("Pear",12.5,"Pear", R.drawable.pear),
                new Item("Tangerine",4.3,"Tangerine", R.drawable.tangerine),
                new Item("Banana",9.7,"Banana", R.drawable.banana),
                new Item("Eggplant",20,"Eggplant", R.drawable.eggplant),
                new Item("Onion",12,"Onion", R.drawable.onion),
                new Item("Pineapple",3.4,"Pineapple", R.drawable.pineapple),
                new Item("Tomato",6.7,"Tomato", R.drawable.tomato),
                new Item("Cabbage",8.2,"Cabbage", R.drawable.cabbage),
                new Item("Fig",9.3,"Fig", R.drawable.fig),
                new Item("Peach",5.4,"Peach", R.drawable.peach),
                new Item("Pitaya",4.7,"Pitaya", R.drawable.pitaya),
                new Item("Watermelon",8.9,"Watermelon", R.drawable.watermelon)};


        items.addAll(Arrays.asList(array));
    }

}
