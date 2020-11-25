package com.example.cacthuattoansapxep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class trangso2 extends AppCompatActivity {

   ListView listView;
  ArrayList<Integer> arrayList1 = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangso2);
        Toast.makeText(trangso2.this,MainActivity.s3,Toast.LENGTH_SHORT).show();
        listView =(ListView)findViewById(R.id.lw1);

        //Toast.makeText(trangso2.this,String.valueOf(soluong),Toast.LENGTH_SHORT).show();
        //MainActivity.insertionSort(MainActivity.arrayList,soluong);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("hiep1");
        arrayList1.addAll(bundle.getIntegerArrayList("is"));
       ArrayAdapter arrayAdapter = new ArrayAdapter(trangso2.this,android.R.layout.simple_expandable_list_item_1,arrayList1);
        listView.setAdapter(arrayAdapter);
    }

}