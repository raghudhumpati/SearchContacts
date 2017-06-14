package com.example.android.searchcontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper dbh;
    EditText et1;
    EditText et2;
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbh=new DBHelper(this);

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbh.addcontact(et1.getText().toString(),et2.getText().toString());

                Toast.makeText(MainActivity.this,"CONTACT ADDED", Toast.LENGTH_SHORT).show();


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"SEARCHING CONTACT",Toast.LENGTH_SHORT).show();
                String searchedname=dbh.searchcontact(et1.getText().toString());
                et2.setText(searchedname);

            }
        });


    }
}
