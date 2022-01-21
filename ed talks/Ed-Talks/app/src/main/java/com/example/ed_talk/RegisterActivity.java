package com.example.ed_talk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView registerUser;
    private EditText editTextUserName, editTextUserAge, editTextUserEmail, editTextUserPassword;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        registerUser= (Button)findViewById(R.id.cirRegisterButton);
        registerUser.setOnClickListener(this);

        editTextUserName=(EditText) findViewById(R.id.editTextName);
        editTextUserAge=(EditText) findViewById(R.id.editTextAge);
        editTextUserEmail=(EditText) findViewById(R.id.editTextEmail);
        editTextUserPassword=(EditText) findViewById(R.id.editTextPassword);
        
    }


    @Override
    public void onClick(View view) {
        switch ((view.getId())){
            case R.id.cirRegisterButton:
                registerUser();
        }

    }

    private void registerUser() {
        String email=editTextUserEmail.getText().toString().trim();
        String password=editTextUserPassword.getText().toString().trim();
        String fullName=editTextUserName.getText().toString().trim();
        String age=editTextUserAge.getText().toString().trim();

        if(fullName.isEmpty()){
            editTextUserName.setError("Full name is required");
            editTextUserName.requestFocus();
            return;
        }
        if(age.isEmpty()){
            editTextUserAge.setError("Age is required");
            editTextUserAge.requestFocus();
            return;
        }
        if(email.isEmpty()){
            editTextUserEmail.setError("Email is required");
            editTextUserEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextUserEmail.setError(("Please provide valid email"));
            editTextUserEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextUserPassword.setError("Password is required");
            editTextUserPassword.requestFocus();
            return;
        }
        if(password.length()<6){
            editTextUserPassword.setError("Min password length should be 6 characters long!");
            editTextUserPassword.requestFocus();
            return;
        }

        //calling firebase object
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            User user=new User(fullName,age,email);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful()){
                                        Toast.makeText(RegisterActivity.this,"User has been registered successfully!",Toast.LENGTH_LONG).show();
                                    }else{
                                        Toast.makeText(RegisterActivity.this,"Failed to register! Try again",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }else{
                            Toast.makeText(RegisterActivity.this,"Failed to register! Try Again!",Toast.LENGTH_LONG).show();
                        }

                    }
                });


    }
}