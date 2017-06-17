package com.lithub.team8.wheresmystuff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set up the login form.
        final EditText mUserView = (EditText) findViewById(R.id.username);

        //Get info from Password field
        final EditText mPasswordView = (EditText) findViewById(R.id.password);

        //Get info after button is clicked
        Button mSignInButton = (Button) findViewById(R.id.sign_in_button);
        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Store values at the time of the login attempt.
                String user = mUserView.getText().toString();
                String password = mPasswordView.getText().toString();


                if(user.equals("admin") && password.equals("123456")) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }
        });
    }
}
