package com.example.simplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {
    Button book;
    EditText name,hostel,branch,id;
    int arraySize;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("WingMates");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        book=findViewById(R.id.book);
        name=findViewById(R.id.name);
        hostel=findViewById(R.id.hostel);
        branch=findViewById(R.id.branch);
        id=findViewById(R.id.id);
        arraySize=getIntent().getIntExtra("size",1);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addwingie(name.getText().toString(),hostel.getText().toString(),id.getText().toString(),branch.getText().toString());
                Intent change=new Intent(AddActivity.this,MainActivity.class);
                startActivity(change);
                
            }
        });



    }

    private void addwingie(String toString, String toString1, String toString2, String toString3) {
        Wing wing=new Wing(toString,toString1,toString2,toString3);
        databaseReference.child("WingMates" +arraySize).setValue(wing);
    }

}
