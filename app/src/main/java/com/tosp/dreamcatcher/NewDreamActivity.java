package com.tosp.dreamcatcher;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewDreamActivity extends AppCompatActivity {
    EditText dream_title, dream_content;
    FirebaseAuth mAuth;
    DreamEntry newDream = new DreamEntry();
    Integer counter = 0;
    public static final String APP_PREFERENCES = "mysettings";
    String APP_PREFERENCES_COUNTER = "counter";

    SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dream);

        dream_title = findViewById(R.id.dreamTitle);
        dream_content = findViewById(R.id.dreamInput);
        mAuth = FirebaseAuth.getInstance();
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        String user_id = mAuth.getCurrentUser().getUid();
        DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Dreams").child(user_id);

        current_user_db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println(snapshot.getValue());
                if (snapshot.getValue() == null) {
                    counter = 0;
                    SharedPreferences.Editor editor = mSettings.edit();
                    editor.putInt(APP_PREFERENCES_COUNTER, counter);
                    editor.apply();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

    }

    public void saveDreamClicked(View view) {
        String user_id = mAuth.getCurrentUser().getUid();
        DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Dreams").child(user_id);

        newDream.setTitle(dream_title.getText().toString());
        newDream.setText(dream_content.getText().toString());

        if(mSettings.contains(APP_PREFERENCES_COUNTER)) {
            counter = (mSettings.getInt(APP_PREFERENCES_COUNTER, 0));
        }

        //DatabaseReference users_db = FirebaseDatabase.getInstance().getReference("Users");

        //String text = "";
        //final Pattern pattern = Pattern.compile("n[0-9]+");
        //Matcher matcher = pattern.matcher(text);

        Map newUser = new HashMap();
        newUser.put("dream_title", newDream.getTitle());
        newUser.put("dream_content", newDream.getText());


        current_user_db.child("n"+ counter).setValue(newUser);
        //dreamCount.setValue(newUser);
        counter++;
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, counter);
        editor.apply();
    }
}