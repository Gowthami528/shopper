package com.example.mypc.shopper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.app.ProgressDialog;


public class MainActivity extends AppCompatActivity {
    EditText userorders,userid,orders;
    public ProgressDialog progressDialog;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userorders=(EditText)findViewById(R.id.editText);
        userid=(EditText)findViewById(R.id.editText2);
        orders=(EditText)findViewById(R.id.editText3);
        progressDialog = new ProgressDialog(this);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReferenceFromUrl("https://shopper-37af1.firebaseio.com/shopper/");

    }
    public void ok(View v)
    {

        DatabaseReference id = databaseReference .push();
        id.child("userorders").setValue(userorders.getText().toString());
        id.child("userid").setValue(userid.getText().toString());
        id.child("orders").setValue(orders.getText().toString());

        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
    }

}
