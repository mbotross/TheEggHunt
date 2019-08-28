package com.example.saveit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends Activity {


    EditText username,password;
    Button login;
    String user, pass;
    Database mydb;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        mydb=new Database(this);
        intent=new Intent(this,Home.class);

        login.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                user=username.getText().toString();
                pass=password.getText().toString();


                if(user.length()!=0 && pass.length()!=0){
                    //log them in
                    System.out.println(user);


                }
                else{
                    showmessage();

                }


                startActivity(intent);
            }
        });







        System.out.println(user);


    }

    public void showmessage(){

        Toast.makeText(this,"You mus enter a username and password", Toast.LENGTH_SHORT).show();
    }
}
