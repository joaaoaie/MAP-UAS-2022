package id.ac.umn.map_uas_2022;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navView;

    String name; // temporary testing

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navView = findViewById(R.id.nav_view);
        navView.getMenu().findItem(R.id.navigation_contacts).setOnMenuItemClickListener(item -> {
            contactsPage();
            return true;
        });
        navView.getMenu().findItem(R.id.navigation_myInformations).setOnMenuItemClickListener(item -> {
            myInformationsPage();
            return true;
        });
        navView.getMenu().findItem(R.id.navigation_chats).setOnMenuItemClickListener(item -> {

            chatsPage();
            return true;
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    void myInformationsPage() {
        MyInformations myInformations = new MyInformations();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myInformations).commit();
        navView.getMenu().findItem(R.id.navigation_myInformations).setChecked(true);

        // temporary testing
//        name = "John Doe";
//        myInformations.setDisplayName(name);
//        Log.d(TAG, "myInformationsPage success");
    }

    void contactsPage() {
        Contacts contacts = new Contacts();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, contacts).commit();
        navView.getMenu().findItem(R.id.navigation_contacts).setChecked(true);
    }

    void chatsPage() {
        Chats chats = new Chats();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, chats).commit();
        navView.getMenu().findItem(R.id.navigation_chats).setChecked(true);
    }
}