package com.example.myapi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapi.model.sample.response.food.CategoriesItem;
import com.example.myapi.model.sample.response.food.DataResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<CategoriesItem> dataModalList;
    private Context context;

    private OnClickListener onClickListener;

    public MyAdapter(Context context, List<CategoriesItem> dataModalList){
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
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
//    holder.name.setText(dataModalList.get(position).getIdCategory());
    holder.name.setText(dataModalList.get(position).getStrCategory());
      /*  Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttpDownloader(context));
        builder.build().load(dataModalList.get(position).getImageurl())
                .placeholder((R.drawable.voyager))
                .error(R.drawable.voyager)
                .into(holder.imageView);*/
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent1=new Intent(context, ItemDetails.class);
            intent1.putExtra("image",dataModalList.get(position).getStrCategoryThumb());
            intent1.putExtra("name",dataModalList.get(position).getStrCategory());
            intent1.putExtra("decription",dataModalList.get(position).getStrCategoryDescription());
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }
    });
        Picasso.with(holder.itemView.getContext())
                .load(dataModalList.get(position).getStrCategoryThumb())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataModalList.size();
    }
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    public interface OnClickListener {
        void onClick(int position, DataResponse model);
    }
}
