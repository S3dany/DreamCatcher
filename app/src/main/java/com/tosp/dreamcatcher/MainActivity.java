package com.tosp.dreamcatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button newDreamButton;
    private Button viewDreamsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newDreamButton  = (Button) findViewById(R.id.new_dream_buttton);
        viewDreamsButton = (Button) findViewById(R.id.view_dreams_button);

        newDreamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewDreamActivity();
            }
        });

        viewDreamsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewDreamsActivity();
            }
        });
    }


    public void openNewDreamActivity() {
        Intent intent = new Intent(this, NewDreamActivity.class);
        startActivity(intent);
    }

    public void openViewDreamsActivity() {
        Intent intent = new Intent(this, ListAllDreamsActivity.class);
        startActivity(intent);
    }
}