package app.com.menuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewOrderActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    static List<Item> items = new ArrayList<>();
    OrderAdapter adapter;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);


        recyclerView = findViewById(R.id.recyclerView);
        total = findViewById(R.id.total);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        adapter = new OrderAdapter(items, getApplicationContext());
        recyclerView.setAdapter(adapter);

        double amount = 0;
        for(Item item : items){
            amount += item.getTotal();
        }

        total.setText(String.format("Total: %.2f", amount));
    }


}
