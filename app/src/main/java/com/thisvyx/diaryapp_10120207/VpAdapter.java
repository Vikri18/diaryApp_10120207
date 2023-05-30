/**
 * NIM : 10120207
 * Nama : Vikri Frediansyah
 * Kelas : IF-5
 */

package com.thisvyx.diaryapp_10120207;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class VpAdapter extends FragmentStateAdapter {

    ArrayList<Fragment> arr;

    public VpAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<Fragment> arr) {
        super(fragmentActivity);
        this.arr = arr;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return arr.get(position);
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }
}
