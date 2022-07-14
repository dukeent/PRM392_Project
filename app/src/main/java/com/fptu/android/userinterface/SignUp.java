package com.fptu.android.userinterface;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private TextView banner;
    public Button registerUser, signinUser;
    private FirebaseAuth mAth;
    private EditText editUsername, editPassword, editEmail, editPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAth = FirebaseAuth.getInstance();

        signinUser = findViewById(R.id.signinuser);
        signinUser.setOnClickListener(this);

        banner = findViewById(R.id.banner);
        banner.setOnClickListener(this);

        registerUser = findViewById(R.id.registeruser);
        registerUser.setOnClickListener(this);

        editUsername = findViewById(R.id.username2);
        editPassword = findViewById(R.id.password2);
        editEmail = findViewById(R.id.email);
        editPhone = findViewById(R.id.phone2);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signinuser:
                startActivity(new Intent(this, Login.class));
                break;
            case R.id.registeruser:
                RegisterUser();
                break;
        }
    }

    private void RegisterUser() {
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        String phone = editPhone.getText().toString().trim();
        String userName = editUsername.getText().toString().trim();
        if (userName.isEmpty()) {
            editUsername.setError("Name is Required");
            editUsername.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            editEmail.setError("Email is Required");
            editEmail.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editEmail.setError("please provide correct email");
            editEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editPassword.setError("Password is Required");
            editPassword.requestFocus();
        }
        if (password.length() < 6) {
            editPassword.setError("Password should longer than 6! ");
            editPassword.requestFocus();
            return;

        }
        if (phone.isEmpty()) {
            editPhone.setError("PhoneNumber is reaquired");
            editPhone.requestFocus();
            return;

        }
        if (!phone.matches("(((\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})")) {
            editPhone.setError("viet nam's phone number start with 03,05,07,08,09 or+84,84 and longer than 10. pleas try again!");

            editPhone.requestFocus();
            return;

        }


        mAth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(userName, email, password, phone);
                            FirebaseDatabase.getInstance().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(SignUp.this, "signup successfully", Toast.LENGTH_LONG).show();

                                            } else
                                                Toast.makeText(SignUp.this, "signup fail", Toast.LENGTH_LONG).show();
                                        }
                                    });
                        } else {
                            Toast.makeText(SignUp.this, "signup fail", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

}