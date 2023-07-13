package sg.edu.rp.c346.id22045554.songdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class RecordActitvity1 extends AppCompatActivity {

    ListView lvSongs;
    ArrayList<Song> alSongs;
    ArrayList<Song> alFive;
    Button btn5;
    Song data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_actitvity1);

        lvSongs = findViewById(R.id.lvSonglist);
        btn5 = findViewById(R.id.btnPopular);

        Intent i = getIntent();
        data1 = (Song) i.getSerializableExtra("data");




        Intent intentReceived = getIntent();



        DBHelper db = new DBHelper(RecordActitvity1.this);


        alSongs = db.getSongs();
        ArrayAdapter aaSongs = new ArrayAdapter<>(RecordActitvity1.this, android.R.layout.simple_list_item_1,alSongs);
        lvSongs.setAdapter(aaSongs);




        db.close();





        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(RecordActitvity1.this);


                alFive = db.get5songs();
                ArrayAdapter aaFive = new ArrayAdapter<>(RecordActitvity1.this, android.R.layout.simple_list_item_1,alFive);
                lvSongs.setAdapter(aaFive);

                db.close();

            }
        });


        lvSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song data = alSongs.get(position);

                Intent intent = new Intent(RecordActitvity1.this, RecordActivity2.class);
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });




//        alSongs.clear();
//        for (int i = 0; i < localArrayList.size(); i++) {
//            Log.d("Database Content", i +". "+ localArrayList.get(i));
//            alSongs.add(localArrayList.get(i));
//
//        }
//        aaSongs.notifyDataSetChanged();














    }
}