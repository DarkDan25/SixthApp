package com.zyablik.sixthapp;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Duck extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duck);

        ActionBar actionBar = getSupportActionBar();

        EdgeToEdge.enable(this);
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Ducks");

            BottomNavigationView BotNavView = findViewById(R.id.botbar);
            fragmentManager.beginTransaction().add(R.id.ducky, ducky.class, null).commit();
            BotNavView.setOnNavigationItemSelectedListener(item -> {
                FragmentTransaction ftrans = fragmentManager.beginTransaction();
                if (item.getItemId() == R.id.settings) {
                    System.out.println("SETTINGS");
                    actionBar.setTitle("Settings");
                    Fragment f1 = new ducky();
                    ftrans.replace(R.id.fduck, f1, "ducky").commit();
                } else if (item.getItemId() == R.id.home) {
                    System.out.println("HOME");
                    actionBar.setTitle("Home");
                    Fragment f2 = new home();
                    ftrans.replace(R.id.fduck, f2, "home").commit();
                } else if (item.getItemId() == R.id.chats) {
                    System.out.println("CHATS");
                    actionBar.setTitle("Chats");
                    Fragment f3 = new chats();
                    ftrans.replace(R.id.fduck, f3, "chats").commit();
                }
                return false;
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(Duck.this, MainActivity.class));
        return super.onOptionsItemSelected(item);
    }
}