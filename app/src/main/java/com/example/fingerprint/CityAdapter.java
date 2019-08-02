package com.example.fingerprint;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CustomViewHolder> {

    private List<ListModel> dataList;
    private Context context;

    public CityAdapter(Context context, List<ListModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView subtitle;
        Button btn;

        CustomViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textView);
            subtitle = itemView.findViewById(R.id.textView2);
            btn = itemView.findViewById(R.id.button);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        holder.title.setText(dataList.get(position).getTitle());
        holder.subtitle.setText(dataList.get(position).getSub());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("Data", dataList.get(position).getBtn());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
