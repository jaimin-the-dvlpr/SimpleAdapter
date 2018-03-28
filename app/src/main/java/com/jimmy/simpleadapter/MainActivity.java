package com.jimmy.simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity{

    String [] anialsname = {"Lion","Beer","Dog","Elephant","Fish","Panda"};
    int [] animalsImages ={R.drawable.lion,R.drawable.beer,R.drawable.dog,R.drawable.elephant,R.drawable.fish,R.drawable.panda};
    ListView simplelistview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    simplelistview = findViewById(R.id.simplelist);

        ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
        for (int i=0;i<anialsname.length;i++){
         // Create a Hashmap to store the data in key value
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("name",anialsname[i]);
            hashMap.put("image",animalsImages[i]+"");

            //add the hashmap into arraylist
            arrayList.add(hashMap);
        }

        // create a string array
        String [] from= {"name","image"};
        // create int array of views ids
        int [] to ={R.id.textview,R.id.imageview};

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,arrayList,R.layout.design_file,from,to);
        simplelistview.setAdapter(simpleAdapter);

        simplelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, anialsname[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
