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

    private MyInformations myInformations;
    private Chats chats;
    private Contacts contacts;

    BottomNavigationView navView;

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

        if (savedInstanceState != null) {
            if (savedInstanceState.getString("navView") != null) {
                int viewId = Integer.parseInt(savedInstanceState.getString("navView"));
                navView.setSelectedItemId(viewId);
                if (viewId == R.id.navigation_contacts) {
                    contactsPage();
                } else if (viewId == R.id.navigation_chats) {
                    chatsPage();
                } else if (viewId == R.id.navigation_myInformations) {
                    myInformationsPage();
                }
            } else {
                myInformationsPage();
            }
        }

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");
//
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onSaveInstanceState(new Bundle());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("navView", navView.getSelectedItemId());
        super.onSaveInstanceState(outState);
    }

    void myInformationsPage() {
        Bundle bundle = new Bundle();
        bundle.putString("name", "John Doe");

        // temporary testing
        Log.d(TAG, "myInformationsPage success");

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, MyInformations.class, bundle).commit();
        navView.getMenu().findItem(R.id.navigation_myInformations).setChecked(true);
    }

    void contactsPage() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, Contacts.class, null).commit();
        navView.getMenu().findItem(R.id.navigation_contacts).setChecked(true);
    }

    void chatsPage() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, Chats.class, null).commit();
        navView.getMenu().findItem(R.id.navigation_chats).setChecked(true);
    }
}