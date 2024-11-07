package com.example.sportscardapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyOnClickListener{
    RecyclerView recyclerView;
    List<Sport> itemList;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();
        Sport sport1 = new Sport("Cricket", R.drawable.cricket);
        Sport sport2 = new Sport("Football", R.drawable.football);
        Sport sport3 = new Sport("Baseball", R.drawable.baseball);
        Sport sport4 = new Sport("BasketBall", R.drawable.basketball);
        Sport sport5 = new Sport("VollyBall", R.drawable.volleball);
        itemList.add(sport1);
        itemList.add(sport2);
        itemList.add(sport3);
        itemList.add(sport4);
        itemList.add(sport5);
        adapter = new MyAdapter(itemList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onCLick(View v, int position) {
        Toast.makeText(this, "Play "+ itemList.get(position).getSportName(), Toast.LENGTH_LONG).show();
    }
}