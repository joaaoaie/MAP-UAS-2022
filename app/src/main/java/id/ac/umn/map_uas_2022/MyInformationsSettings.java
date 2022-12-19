package id.ac.umn.map_uas_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyInformationsSettings extends AppCompatActivity {
    String username;

    EditText displayName, email, password;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_informations_settings);

        username = getIntent().getStringExtra("username");

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("User/" + username);
        myRef.child("name").get().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.e("firebase", "Error getting data", task.getException());
            }
            else {
                String name = String.valueOf(task.getResult().getValue());
                Log.d("firebase", name);
                setDisplayName(name);
            }
        });
        myRef.child("email").get().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.e("firebase", "Error getting data", task.getException());
            }
            else {
                String email = String.valueOf(task.getResult().getValue());
                Log.d("firebase", email);
                setEmail(email);
            }
        });
        myRef.child("password").get().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.e("firebase", "Error getting data", task.getException());
            }
            else {
                String password = String.valueOf(task.getResult().getValue());
                Log.d("firebase", password);
                setPassword(password);
            }
        });

        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(v -> {
            myRef.child("name").setValue(displayName.getText().toString());
            myRef.child("email").setValue(email.getText().toString());
            myRef.child("password").setValue(password.getText().toString());
            finish();
        });
    }

    public void setDisplayName(String name) {
        displayName = (EditText) findViewById(R.id.displayName);
        displayName.setText(name);
    }

    public void setEmail(String email) {
        this.email = (EditText) findViewById(R.id.myEmail);
        this.email.setText(email);
    }

    public void setPassword(String password) {
        this.password = (EditText) findViewById(R.id.myPassword);
        this.password.setText(password);
    }
}