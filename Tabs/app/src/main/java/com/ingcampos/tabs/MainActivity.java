package com.ingcampos.tabs;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ingcampos.tabs.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
//        Este objeto toma fragmentos y los pega en la activity
        ViewPager viewPager = findViewById(R.id.view_pager);
//        viewPager permite trabajar con las pestañas
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
//        Tablayout organiza las pestañas
        tabs.setupWithViewPager(viewPager);
//        Se asigna al adaptador
        FloatingActionButton fab = findViewById(R.id.fab);
//        Se crea el boton
        fab.setOnClickListener(new View.OnClickListener() {//Se crea un escuchador
            @Override
            public void onClick(View view) {//view es el boton
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
//                Al presionar el boton flotante se muestra este mensaje y se ejecuta la accion
            }
        });
    }
}