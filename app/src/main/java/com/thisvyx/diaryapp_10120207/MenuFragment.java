
/**
 * NIM : 10120207
 * Nama : Vikri Frediansyah
 * Kelas : IF-5
 */

package com.thisvyx.diaryapp_10120207;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuFragment extends Fragment {

    private Button btnAddNote;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);
        // Inflate the layout for this fragment

        Intent intent = new Intent(getActivity(), MenuActivity.class);
        btnAddNote = (Button) rootView.findViewById(R.id.btn_pindah);
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        return rootView;

    }


}