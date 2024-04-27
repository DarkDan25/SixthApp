package com.zyablik.sixthapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout dlayout;
    ActionBarDrawerToggle toggle;
    NavigationView navView;
    FragmentManager fragmentManager = getSupportFragmentManager();
    ActionBar abar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        abar = getSupportActionBar();
        if (abar != null) {
            abar.setDisplayHomeAsUpEnabled(true);
            abar.setTitle("Profile");
        }

        dlayout = findViewById(R.id.draw);
        toggle = new ActionBarDrawerToggle
                (MainActivity.this, dlayout, R.string.open, R.string.close);
        if (dlayout != null) {
            dlayout.addDrawerListener(toggle);
        }
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navView = findViewById(R.id.nav);
        fragmentManager.beginTransaction().add(R.id.fprofile, profile.class, null).commit();
        navView.setNavigationItemSelectedListener(item -> {
            FragmentTransaction trans = fragmentManager.beginTransaction();
            if (item.getItemId() == R.id.profile) {
                Fragment f1 = new profile();
                trans.replace(R.id.fragment, f1, "f1").commit();
                abar.setTitle("Profile");
                dlayout.closeDrawer(GravityCompat.START);
            } else if (item.getItemId() == R.id.chars) {
                Fragment f2 = new chars();
                trans.replace(R.id.fragment, f2, "f1").commit();
                abar.setTitle("Chars");
                dlayout.closeDrawer(GravityCompat.START);
            } else if (item.getItemId() == R.id.elem) {
                Fragment f3 = new elements();
                trans.replace(R.id.fragment, f3, "f1").commit();
                abar.setTitle("Elements");
                dlayout.closeDrawer(GravityCompat.START);
            } else if (item.getItemId() == R.id.duck) {
                startActivity(new Intent(MainActivity.this, Duck.class));
                finish();
            }
            return true;
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}