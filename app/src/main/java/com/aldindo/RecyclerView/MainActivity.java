package com.aldindo.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.aldindo.recyclerviewnew.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button addButton,delButton;
    private EditText addTExt,delText;
    ArrayList<ExampleItem> exampleItems;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton=findViewById(R.id.buttonadd);
        delButton=findViewById(R.id.buttondelete);
        addTExt=findViewById(R.id.edittextadd);
        delText=findViewById(R.id.edittextdelete);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(addTExt.getText().toString())){
                    addTExt.setError("Invalid Input");
                } else {
                    if (exampleItems.size() == 0) {
                        addTExt.setError("No Cards Left");
                    }
                    else
                    {
                        int position = Integer.parseInt(addTExt.getText().toString());
                        addCard(position);
                    }
                }


            }
        });
        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(delText.getText().toString())) {
                    delText.setError("Invalid Input");
                } else {
                    if (exampleItems.size() == 0) {
                        delText.setError("No Cards Left");
                    }
                    else
                    {
                        int position = Integer.parseInt(delText.getText().toString());
                        delCard(position);
                    }
                }
            }
        });

        generateFakeData();
        recyclerViewCobfig();

    }

    private void recyclerViewCobfig() {
        //Config for RV
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        adapter=new CustomAdapter(exampleItems);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void generateFakeData() {
        exampleItems=new ArrayList<>();
        exampleItems.add(new ExampleItem(R.drawable.oner,"Clicked in Italy"));
        exampleItems.add(new ExampleItem(R.drawable.twor,"Clicked in Rome"));
        exampleItems.add(new ExampleItem(R.drawable.threer,"Clicked in India"));
        exampleItems.add(new ExampleItem(R.drawable.fourr,"Clicked in US"));
        exampleItems.add(new ExampleItem(R.drawable.fiver,"Clicked in Canada"));
        exampleItems.add(new ExampleItem(R.drawable.sixr,"Clicked in Germany"));
    }

    public void addCard(int position){
        exampleItems.add(position,new ExampleItem(R.drawable.node,"New Card Added"));
        adapter.notifyItemInserted(position);

    }
    public void delCard(int position){
        exampleItems.remove(position);
        adapter.notifyItemRemoved(position);

    }
}
