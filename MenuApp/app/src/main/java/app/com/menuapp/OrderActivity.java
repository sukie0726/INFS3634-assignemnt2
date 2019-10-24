package app.com.menuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {
    ImageView imageView;
    TextView name, price, description;
    EditText editNumber;
    Button btnLess, btnMore, btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        imageView = findViewById(R.id.image);
        editNumber = findViewById(R.id.number);
        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        price = findViewById(R.id.price);
        btnLess = findViewById(R.id.less);
        btnMore = findViewById(R.id.more);
        btnOk = findViewById(R.id.add);


        final Item item = (Item) getIntent().getSerializableExtra("item");

        imageView.setImageResource(item.getImageId());
        editNumber.setText(item.number + "");
        name.setText(item.name + String.format("\n(%.2f)", item.price));
        price.setText(String.format("Total: %.2f", item.getTotal()));
        description.setText(item.description);

        btnLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.number > 1) {
                    item.number = item.number - 1;
                    editNumber.setText(item.number + "");
                    price.setText(String.format("Total: %.2f", item.getTotal()));
                }
            }
        });

        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.number = item.number + 1;
                editNumber.setText(item.number + "");
                price.setText(String.format("Total: %.2f", item.getTotal()));
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewOrderActivity.items.add(item);
                finish();
            }
        });
    }
}
