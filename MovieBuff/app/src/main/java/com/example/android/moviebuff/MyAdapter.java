package com.example.android.moviebuff;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{

    private ArrayList<MovieMeta> dataset=new ArrayList();
    private View vw;
    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView imageView;
        public TextView textView;
        public MyViewHolder(View v)
        {
            super(v);
            this.textView=v.findViewById(R.id.caption);
            this.imageView=v.findViewById(R.id.thumbnail);

        }
    }
    public MyAdapter()
    {
        this.dataset.add(new MovieMeta("helo","world",1));
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.textview,parent,false);
        MyViewHolder vh=new MyViewHolder(v);
        this.vw=v;
        return vh;
    }
    public void setData(ArrayList<MovieMeta>mv)
    {
        this.dataset=mv;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder,int position)
    {
        holder.textView.setText(dataset.get(position).getTitle());
        ImageView image = holder.imageView;
        final String id=dataset.get(position).getId()+"";
        String Image_Base_url="https://image.tmdb.org/t/p/w500";
        Picasso.with(vw.getContext()).load(Image_Base_url+dataset.get(position).getUrl()).into(image);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(v.getContext(),ProductPage.class);
                intent.putExtra("movie_id",id);
                v.getContext().startActivity(intent);
            }
        });
    }
    public int getItemCount()
    {
        return dataset.size();
    }
}
