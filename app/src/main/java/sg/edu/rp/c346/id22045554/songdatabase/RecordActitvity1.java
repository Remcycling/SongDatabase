package sg.edu.rp.c346.id22045554.songdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class RecordActitvity1 extends AppCompatActivity {

    ListView lvSongs;
    ArrayList<Song> alSongs;
    ArrayList<Song> alFive;
    CustomAdapter adapter;
    Button btn5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_actitvity1);

        lvSongs = findViewById(R.id.lvSonglist);
        btn5 = findViewById(R.id.btnPopular);


        /*Intent i = getIntent();
        Intent intentReceived = getIntent();*/



        DBHelper db = new DBHelper(RecordActitvity1.this);


        alSongs = db.getSongs();

        adapter = new CustomAdapter(this, R.layout.row, alSongs);
        lvSongs.setAdapter(adapter);




        db.close();





        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(RecordActitvity1.this);


                alFive = db.get5songs();
                adapter = new CustomAdapter(RecordActitvity1.this, R.layout.row, alFive);
                lvSongs.setAdapter(adapter);



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


    }


}