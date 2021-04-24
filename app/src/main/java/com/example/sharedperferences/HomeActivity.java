package com.example.sharedperferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView textView_name,textview_email;
    Button button_logout;
    SharedPreferences sharedPreferences;
    private  static final   String SHARED_PREF_NAME  ="mypref";
    private  static final  String KEY_NAME ="name";
    private static  final String KEY_EMAIL ="email";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView textView_name =(TextView)findViewById(R.id.edittext_name);
        TextView textView_email =(TextView)findViewById(R.id.edittext_email);
        Button button_logout =(Button)findViewById(R.id.button_logout);


        sharedPreferences =getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
 String name= sharedPreferences.getString(KEY_NAME,null);
 String email =sharedPreferences.getString(KEY_EMAIL,null);
 if (name!= null || email != null){
     //so set the data on textview
textView_name .setText("Full Name_____"+name);

textView_email.setText("Email"+email);

 }
 // so call to button for logout session
        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor =  sharedPreferences.edit();
                editor.clear();
                editor.commit();

                Toast.makeText(HomeActivity.this, "LOgout sucessfull",Toast.LENGTH_LONG);

                finish();
            }
        });


    }
}