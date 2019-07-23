package com.example.foreheadguessers;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {






    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hide the title bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        //show the activity in full screen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final Button categoryButton = findViewById(R.id.categoryButton);
        registerForContextMenu(categoryButton);

        final Button timeButton = findViewById(R.id.timeButton);
        registerForContextMenu(timeButton);

        categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryButtonClicked(categoryButton);
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeButtonClicked(timeButton);
            }
        });
    }

    private void timeButtonClicked(final Button buttonToBeUpdated) {

        final CharSequence[] items = {"60 secs","120 secs","240 secs"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose a Time to Play");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                buttonToBeUpdated.setText(items[item]);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }



    private void categoryButtonClicked(final Button buttonToBeUpdated) {

        final CharSequence[] items = {"Star Trek","Vegetables", "Dogs", "TV Shows", "Breakfast Cereals", "The Simpsons", "Internet Personalities"};


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose a Category");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                buttonToBeUpdated.setText(items[item]);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }
}