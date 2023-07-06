package sg.edu.rp.c346.id22045554.songdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RecordActitvity1 extends AppCompatActivity {

    ListView lvSongs;
    ArrayList<Song> alSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_actitvity1);

        lvSongs = findViewById(R.id.lvSonglist);
        alSongs = new ArrayList<Song>();
        ArrayAdapter aaSongs = new ArrayAdapter<>(RecordActitvity1.this, android.R.layout.simple_list_item_1,alSongs);
        lvSongs.setAdapter(aaSongs);

        Intent intentReceived = getIntent();
        String questionsSelected = intentReceived.getStringExtra("playlist");

        DBHelper db = new DBHelper(RecordActitvity1.this);
        ArrayList<Song> localArrayList  = db.getSong();
        db.close();

        alSongs.clear();
        for (int i = 0; i < localArrayList.size(); i++) {
            Log.d("Database Content", i +". "+ localArrayList.get(i));
            alSongs.add(localArrayList.get(i));

        }
        aaSongs.notifyDataSetChanged();














    }
}