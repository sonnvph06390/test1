package com.example.son.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Oto> otoList;
    Database database;
    private EditText edID;
    private EditText edName;
    private EditText edPrice;
    MyAdapter adapter;
    Button btnAdd;
    Button btnUpdate;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edID = findViewById(R.id.edID);
        edName = findViewById(R.id.edName);
        edPrice = findViewById(R.id.edPrice);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate=findViewById(R.id.btnUpdate);
        database=new Database(this);
        recyclerView=findViewById(R.id.rcvList);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edID.getText().toString();
                String name = edName.getText().toString();
                String price = edPrice.getText().toString();

                database.addStudent(new Oto(id,name,price));
                Toast.makeText(MainActivity.this, "Save successfully", Toast.LENGTH_SHORT).show();

                otoList=new ArrayList<>(database.getAllOto());
                adapter=new MyAdapter(MainActivity.this,otoList);

//                adapter = new MyAdapter(MainActivity.this, students);
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(adapter);
            }
        });

    }
}
