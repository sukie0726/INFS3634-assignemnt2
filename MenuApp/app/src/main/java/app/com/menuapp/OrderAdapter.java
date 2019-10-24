package app.com.menuapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Item> items;
    private Context context;

    public OrderAdapter(List<Item> items, Context context){
        this.items = items;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_order, null, false);
        RecyclerView.ViewHolder holder  = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ((MyViewHolder) holder).name.setText(items.get(position).getName());
        ((MyViewHolder) holder).price.setText(String.format("Total: %.2f", items.get(position).getTotal()));
        ((MyViewHolder) holder).number.setText(String.format("Number: %d", items.get(position).getNumber()));
        ((MyViewHolder) holder).image.setImageResource(items.get(position).getImageId());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price, number;
        public ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            number = itemView.findViewById(R.id.number);
            image = itemView.findViewById(R.id.image);
        }
    }
}

