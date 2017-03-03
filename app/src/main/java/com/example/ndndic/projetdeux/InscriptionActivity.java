package com.example.ndndic.projetdeux;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InscriptionActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText editName, editSurname, editEmail, editPseudo, editPassword;
    Button buttonAdd, buttonView, buttonPicture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        myDB = new DatabaseHelper(this);
        buttonAdd = (Button) findViewById(R.id.button);
        buttonView = (Button) findViewById(R.id.button2);
        buttonPicture = (Button) findViewById(R.id.button5);
        editName= (EditText) findViewById(R.id.editText1);
        editSurname = (EditText) findViewById(R.id.editText2);
        editEmail = (EditText) findViewById(R.id.editText3);
        editPseudo = (EditText) findViewById(R.id.editText4);
        editPassword = (EditText) findViewById(R.id.editText5);
        Insert();
        View();
        TakePicture();
    }
    public void Insert (){
        buttonAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                boolean isInserted = myDB.insertData(editName.getText().toString(),
                        editSurname.getText().toString(),
                        editEmail.getText().toString(),
                        editPseudo.getText().toString(),
                        editPassword.getText().toString());
                if (isInserted)
                    Toast.makeText(InscriptionActivity.this, "REGISTERED WITH SUCCESS", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(InscriptionActivity.this, "PROBLEM WITH REGISTERING", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void View(){
        buttonView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Cursor res = myDB.getAllData();
                if (res.getCount()==0){
                    showMessage("Error","No members registered yet");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Name : "+ res.getString(1) +" \n");
                    buffer.append("Surname : "+ res.getString(2) +" \n");
                    buffer.append("Email : "+ res.getString(3) +" \n");
                    buffer.append("Pseudo : "+ res.getString(4) +" \n");
                    buffer.append("Password : "+ res.getString(5) +" \n \n");
                }
                    showMessage("Members", buffer.toString());
            }
        });
    }
    public void TakePicture (){
        buttonPicture.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InscriptionActivity.this, PictureActivity.class);
                startActivity(intent);
            }
        });
    }
    public void showMessage (String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
