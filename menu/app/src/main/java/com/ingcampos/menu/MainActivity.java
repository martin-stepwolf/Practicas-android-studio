package com.ingcampos.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(MainActivity.this, button);

                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());

                popup.setOnMenuItemClickListener(
                        new PopupMenu.OnMenuItemClickListener(){
                            public boolean onMenuItemClick(MenuItem item){
                                Toast.makeText(MainActivity.this,"You Clicked" + item.getTitle(), Toast.LENGTH_SHORT).show();
                                return true;
                            }
                        }
                );
                popup.show();
            }
        });
    }
}
