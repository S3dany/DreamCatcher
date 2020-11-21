package com.tosp.dreamcatcher;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class NewDreamActivity extends AppCompatActivity {
    EditText dream_title, dream_content;
    FirebaseAuth mAuth;
    DreamEntry newDream = new DreamEntry();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dream);

        dream_title = findViewById(R.id.dreamTitle);
        dream_content = findViewById(R.id.dreamInput);
        mAuth = FirebaseAuth.getInstance();
    }

    public void saveDreamClicked(View view) {
        String user_id = mAuth.getCurrentUser().getUid();
        DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Dreams").child(user_id);

        newDream.setTitle(dream_title.getText().toString());
        newDream.setText(dream_content.getText().toString());


        Map newUser = new HashMap();
        newUser.put("dream title", newDream.getTitle());
        newUser.put("dream content", newDream.getText());

        current_user_db.setValue(newUser);
    }
}