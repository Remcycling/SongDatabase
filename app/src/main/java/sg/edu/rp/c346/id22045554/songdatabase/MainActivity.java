package sg.edu.rp.c346.id22045554.songdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnShow;
    EditText etTitle, etSingers, etYear;
    RadioGroup star;
    RadioButton rb1, rb2, rb3, rb4, rb5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);
        etTitle = findViewById(R.id.editTextId);
        etSingers = findViewById(R.id.editTextSingers);
        etYear = findViewById(R.id.editTextYear);
        star = findViewById(R.id.ratings);
        rb1 = findViewById(R.id.radioButton1);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        rb5 = findViewById(R.id.radioButton5);



        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                String t = etTitle.getText().toString();
                String s = etSingers.getText().toString();
                String y = etYear.getText().toString();
                int date = Integer.parseInt(y);

                int num = 0;
                int starCheck = star.getCheckedRadioButtonId();
                if (starCheck == R.id.radioButton1) {
                    num = 1;
                } else if (starCheck == R.id.radioButton2) {
                    num = 2;
                } else if (starCheck == R.id.radioButton3) {
                    num = 3;
                } else if (starCheck == R.id.radioButton4) {
                    num = 4;
                } else {
                    num = 5;
                }

                // Insert a task
                db.insertSong(t, s, date, num);

                etSingers.setText("");
                etTitle.setText("");
                etYear.setText("");
                rb1.setChecked(false);
                rb2.setChecked(false);
                rb3.setChecked(false);
                rb4.setChecked(false);
                rb5.setChecked(false);
                Toast.makeText(MainActivity.this, "Song added!", Toast.LENGTH_LONG).show();

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                Intent intent = new Intent(MainActivity.this, RecordActitvity1.class);
                startActivity(intent);



            }
        });
    }


}