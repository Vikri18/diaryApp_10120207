/**
 * NIM : 10120207
 * Nama : Vikri Frediansyah
 * Kelas : IF-5
 */

package com.thisvyx.diaryapp_10120207;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class AddNoteActivity extends AppCompatActivity {

    //atribut
    EditText tittle, category, details;
    Button btnAddnote;
    String todayDate, currentTime;
    Calendar calendar;

    //method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);


        tittle = findViewById(R.id.et_tittle);
        category = findViewById(R.id.et_kategori);
        details = findViewById(R.id.et_isiNote);
        btnAddnote = findViewById(R.id.btn_addNote);

        calendar = Calendar.getInstance();
        todayDate = calendar.get(Calendar.DAY_OF_MONTH) +"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.YEAR);
        currentTime = pad(calendar.get(Calendar.HOUR))+":"+pad(calendar.get(Calendar.MINUTE));

        Log.d("Calender", "Date and Time" + todayDate + " and "+currentTime);

        btnAddnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoteModel nodeModel = new NoteModel(tittle.getText().toString(), category.getText().toString(), details.getText().toString(), todayDate ,currentTime);
                NoteDatabase db = new NoteDatabase(AddNoteActivity.this);
                db.AddNote(nodeModel);

                Intent intent = new Intent(AddNoteActivity.this, MenuActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(),"Note Saved", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public String pad(int i){
        if(i < 0)
            return "0"+i;
        return String.valueOf(i);
    }
}