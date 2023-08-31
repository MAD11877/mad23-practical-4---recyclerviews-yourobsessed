package com.example.madpractical3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrieve the random number from the intent
        Intent intent = getIntent();
        int randomNumber = intent.getIntExtra("randomNumber", 0);

        // User Object
        User user = new User();
        user.setName("MAD");
        user.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");

        TextView title = findViewById(R.id.title);
        TextView description = findViewById(R.id.description);
        Button followButton = findViewById(R.id.follow);

        title.setText(user.getName() + " " + randomNumber);
        description.setText(user.getDescription());


        // Add click listener to the follow button
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user.followed = !user.followed;

                // Update the text of the follow button
                if (user.isFollowed()) {
                    followButton.setText("Unfollow");
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                } else {
                    followButton.setText("Follow");
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}