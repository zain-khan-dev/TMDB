package com.example.android.moviebuff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Movie> movies=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =findViewById(R.id.r_view);
//        if(R.layout.activity_mai.getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT)
//        {
            layoutManager=new GridLayoutManager(this,2);
//        }
//        else
//        {
//            layoutManager=new GridLayoutManager(this,3);
//        }
        recyclerView.setLayoutManager(layoutManager);
        mAdapter=new MyAdapter();
        recyclerView.setAdapter(mAdapter);
        Controller controller = new Controller();
        controller.start(mAdapter);
    }

}
