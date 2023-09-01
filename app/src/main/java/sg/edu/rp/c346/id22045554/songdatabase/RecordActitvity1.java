package sg.edu.rp.c346.id22045554.songdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    ArrayList<Song> alSongsYear;
    ArrayList<Song> alFive;
    ArrayAdapter<Integer> dataAdapter;
    CustomAdapter adapter;
    CustomAdapter adapter2;
    Spinner spnYear;
    Button btn5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_actitvity1);

        lvSongs = findViewById(R.id.lvSonglist);
        btn5 = findViewById(R.id.btnPopular);
        spnYear = findViewById(R.id.spinnerYear);

        DBHelper db = new DBHelper(RecordActitvity1.this);


        dataAdapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, db.getAllYears());
        spnYear.setAdapter(dataAdapter);





        // Set the OnItemSelectedListener if needed
        spnYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedValue = parent.getItemAtPosition(position).toString();
                int selected =  Integer.parseInt(selectedValue);
                alSongsYear = db.retrieveSongsbyYear(selected);
                adapter = new CustomAdapter(RecordActitvity1.this, R.layout.row, alSongsYear);
                lvSongs.setAdapter(adapter);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle case where nothing is selected
                alSongs = db.getSongs();
                adapter = new CustomAdapter(RecordActitvity1.this, R.layout.row, alSongs);
                lvSongs.setAdapter(adapter);
            }
        });
        db.close();



        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(RecordActitvity1.this);
                alFive = db.get5songs();
                adapter2 = new CustomAdapter(RecordActitvity1.this, R.layout.row, alFive);
                lvSongs.setAdapter(adapter2);
                db.close();
                lvSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Song data = alFive.get(position);
                        Intent intent = new Intent(RecordActitvity1.this, RecordActivity2.class);
                        intent.putExtra("data", data);
                        startActivity(intent);
                    }
                });

            }
        });

        lvSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song data = alSongsYear.get(position);
                Intent intent = new Intent(RecordActitvity1.this, RecordActivity2.class);
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });





    }


}