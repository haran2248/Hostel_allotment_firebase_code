package com.example.simplelogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button log;
    Button add;
    RecyclerView recyclerView;
    DatabaseReference wingreference;
    int arraySize=1;
    FirebaseAuth auth;

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()==null)
        {
            Intent login=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(login);
            finish();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();
        log=findViewById(R.id.loginbtn);
        add=findViewById(R.id.add_friend);
        recyclerView=findViewById(R.id.wingies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if(FirebaseAuth.getInstance().getCurrentUser()!=null) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();

            wingreference = FirebaseDatabase.getInstance().getReference().child("users").child("WingMates");


            log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent u = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(u);

                }
            });
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, AddActivity.class);
                    i.putExtra("size",arraySize);
                    startActivity(i);
                }
            });

            wingreference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    ArrayList<Wing> wingList = new ArrayList<>();
                    for (DataSnapshot shot : dataSnapshot.getChildren()) {
                        wingList.add(shot.getValue(Wing.class));
                        Log.i("WING NAME", shot.getValue(Wing.class).getName());
                        ++arraySize;
                    }
                    recyclerView.setAdapter(new WingAdapter(wingList, getApplicationContext()));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

    }
}
