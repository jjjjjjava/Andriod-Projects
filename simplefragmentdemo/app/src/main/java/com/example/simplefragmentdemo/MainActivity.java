// MainActivity.java
package com.example.simplefragmentdemo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            ListFragment listFragment = new ListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container_list, listFragment)
                    .commit();
        }
    }

    @Override
    public void onItemSelected(String item) {
        DetailFragment detailFragment = DetailFragment.newInstance(item);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_detail, detailFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }
}
