package com.aldindo.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aldindo.recyclerviewnew.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ExampleItem> exampleItems=new ArrayList<>();
        exampleItems.add(new ExampleItem(R.drawable.oner,"Clicked in Italy"));
        exampleItems.add(new ExampleItem(R.drawable.twor,"Clicked in Rome"));
        exampleItems.add(new ExampleItem(R.drawable.threer,"Clicked in India"));
        exampleItems.add(new ExampleItem(R.drawable.fourr,"Clicked in US"));
        exampleItems.add(new ExampleItem(R.drawable.fiver,"Clicked in Canada"));
        exampleItems.add(new ExampleItem(R.drawable.sixr,"Clicked in Germany"));
        //Config for RV
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        adapter=new CustomAdapter(exampleItems);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
