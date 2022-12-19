package id.ac.umn.map_uas_2022;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class LoginActivity extends AppCompatActivity {
    Button loginButton, cancelButton;
    EditText usernameText, passwordText;

    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button) findViewById(R.id.loginButton);
        usernameText = (EditText) findViewById(R.id.usernameText);
        passwordText = (EditText) findViewById(R.id.passwordText);

        cancelButton = (Button) findViewById(R.id.cancelButton);

        loginButton.setOnClickListener(v -> {
//            if(usernameText.getText().toString().equals("admin") &&
//                    passwordText.getText().toString().equals("admin")) {
//                Toast.makeText(getApplicationContext(),
//                        "Redirecting...",Toast.LENGTH_SHORT).show();
//            }else{
//                Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
//            }
            username = usernameText.getText().toString();
            password = passwordText.getText().toString();

            DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("User/" + username);
            myRef.child("password").get().addOnCompleteListener(task -> {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    String password = String.valueOf(task.getResult().getValue());
                    Log.d("firebase", password);
                    if (comparePassword(password)) {
                        Log.d("firebase", "Password match");
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("username", username);
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "Username or Password is Incorrect", Toast.LENGTH_LONG).show();
                        usernameText.setText("");
                        passwordText.setText("");
                        Log.d("firebase", "Password doesn't match");
                    }
                }
            });
        });

        cancelButton.setOnClickListener(v -> finish());
    }

    private boolean comparePassword(String password) {
        return this.password.equals(password);
    }
}