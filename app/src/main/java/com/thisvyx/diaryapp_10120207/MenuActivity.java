
/**
 * NIM : 10120207
 * Nama : Vikri Frediansyah
 * Kelas : IF-5
 */


package com.thisvyx.diaryapp_10120207;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button btnAddNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnAddNote = findViewById(R.id.btn_addNote);

        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AddNoteActivity.class);
                startActivity(intent);
            }
        });
    }
}