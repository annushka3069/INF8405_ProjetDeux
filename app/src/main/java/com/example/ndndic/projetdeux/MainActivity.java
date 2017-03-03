package com.example.ndndic.projetdeux;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    Button buttonSignIn, buttonSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSignIn = (Button) findViewById(R.id.button3);
        buttonSignUp = (Button) findViewById(R.id.button4);
        SignIn();
        SignUp();
    }
    public void SignIn (){
        buttonSignIn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InscriptionActivity.class);
                startActivity(intent);
                }
        });
    }
    public void SignUp (){
        buttonSignUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConnexionActivity.class);
                startActivity(intent);
            }
        });
    }


}
