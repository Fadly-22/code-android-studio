package com.example.bacamanga2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDetail;
    private TypedArray dataPhoto;
    private JudulAdapter adapter;
    private ArrayList <Judul>juduls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new JudulAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>adapterView, View view, int i, long l){
                Toast.makeText(MainActivity.this, juduls.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void prepare (){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDetail = getResources().getStringArray(R.array.data_detail);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
    private void addItem (){
        juduls = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++){

            Judul judul = new Judul();
            judul.setPhoto(dataPhoto.getResourceId(i, -1));
            judul.setName(dataName[i]);
            judul.setDetail(dataDetail[i]);
            juduls.add(judul);
        }
        adapter.setJuduls(juduls);
    }
}