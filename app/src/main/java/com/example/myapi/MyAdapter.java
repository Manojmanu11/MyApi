package com.example.myapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<DataModal>dataModalList;
    private Context context;

    public MyAdapter(Context context,List<DataModal> dataModalList){
        this.context = context;
        this.dataModalList = dataModalList;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        public final View mView;

        TextView name;
        private ImageView imageView;

        MyViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
           name =mView.findViewById(R.id.name);
           imageView=mView.findViewById(R.id.imageview);


       }

    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.design, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
    holder.name.setText(dataModalList.get(position).getName());
      /*  Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttpDownloader(context));
        builder.build().load(dataModalList.get(position).getImageurl())
                .placeholder((R.drawable.voyager))
                .error(R.drawable.voyager)
                .into(holder.imageView);*/

        Picasso.with(holder.itemView.getContext())
                .load(dataModalList.get(position).getImageurl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataModalList.size();
    }
}
