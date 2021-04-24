package com.example.sharedperferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Textname,Textemail;
    Button save;
    SharedPreferences sharedPreferences;
    // create a sharedpreference object and call it a getsharedprefence method()


private  static final   String SHARED_PREF_NAME  ="mypref";
private  static final  String KEY_NAME ="name";
private static  final String KEY_EMAIL ="email";


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText editTextname =(EditText)findViewById(R.id.edittext_name);
        EditText editTextemail= (EditText) findViewById(R.id.edittext_email);
        Button btnsave =(Button)findViewById(R.id.btnsave);
            sharedPreferences =getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
//WHen open activity first check shared perefrences  data available or not
            String name =sharedPreferences.getString(KEY_NAME,null);
if (name != null){
    //if data is available so it directly call on homeactivity.....
    Intent intent =new Intent(MainActivity.this,HomeActivity.class);
    startActivity(intent);
            }
           btnsave.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   //when click a button  put data on sharedpreferenced

                   SharedPreferences.Editor editor =sharedPreferences.edit();
                   editor.putString(KEY_NAME,editTextname.getText().toString());
                   editor.putString(KEY_NAME,editTextemail.getText().toString());
                   editor.apply();
                   Intent intent =new Intent(MainActivity.this,HomeActivity.class);
                   startActivity(intent);
                   Toast.makeText(MainActivity.this,"Login sucess",Toast.LENGTH_LONG);
               }
           });
    }
}