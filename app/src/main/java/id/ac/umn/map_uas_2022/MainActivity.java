package id.ac.umn.map_uas_2022;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

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
//        Imagine that this is the person who logged in
        bundle.putString("username", "JonathanO");
//        bundle.putString("username", "JonathanOctavien");

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