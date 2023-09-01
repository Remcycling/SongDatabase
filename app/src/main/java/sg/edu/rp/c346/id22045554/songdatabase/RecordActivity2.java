package sg.edu.rp.c346.id22045554.songdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RecordActivity2 extends AppCompatActivity {

    Button btnUpdate, btnDelete, btnCancel;
    EditText etTitle, etSingers, etYear;
    TextView tvId;
    RadioGroup star;
    RadioButton rb1, rb2, rb3, rb4, rb5;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record2);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);
        tvId = findViewById(R.id.textViewId);
        etTitle = findViewById(R.id.editTextTitle2);
        etSingers = findViewById(R.id.editTextSingers2);
        etYear = findViewById(R.id.editTextYear2);
        star = findViewById(R.id.ratings2);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);


        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        tvId.setText(""+data.getId());
        etTitle.setText(data.getTitle());
        etSingers.setText(data.getSingers());
        etYear.setText(""+data.getYear());


        if (data.getStars()==1) {
            rb1.setChecked(true);
        } else if (data.getStars()==2) {
            rb2.setChecked(true);
        } else if (data.getStars()==3) {
            rb3.setChecked(true);
        } else if (data.getStars()==4) {
            rb4.setChecked(true);
        } else {
            rb5.setChecked(true);
        }


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(RecordActivity2.this);

                String y = etYear.getText().toString();
                int date = Integer.parseInt(y);

                int num = 0;
                int starCheck = star.getCheckedRadioButtonId();
                if (starCheck == R.id.rb1) {
                    num = 1;
                } else if (starCheck == R.id.rb2) {
                    num = 2;
                } else if (starCheck == R.id.rb3) {
                    num = 3;
                } else if (starCheck == R.id.rb4) {
                    num = 4;
                } else {
                    num = 5;
                }



                data.setSongContent(etTitle.getText().toString(), etSingers.getText().toString(),date, num);
                dbh.updateSong(data);
                dbh.close();

                Intent i = new Intent(RecordActivity2.this,
                        RecordActitvity1.class);
                startActivity(i);
                finish();


            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(RecordActivity2.this);
                dbh.deleteSong(data.getId());


                Intent i = new Intent(RecordActivity2.this,
                        RecordActitvity1.class);
                startActivity(i);
                finish();


            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(RecordActivity2.this,
                        RecordActitvity1.class);
                startActivity(i);
                finish();

            }
        });




    }
}