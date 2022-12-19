package id.ac.umn.map_uas_2022;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    // Username for the current user (Development only)
//    String[] username = new String[]{
//            "JonathanO",
//            "JonathanOctavien"
//    };
    String username;

    BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = getIntent().getStringExtra("username");

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
        bundle.putString("username", username);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, MyInformations.class, bundle).commit();
        navView.getMenu().findItem(R.id.navigation_myInformations).setChecked(true);
    }

    void contactsPage() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, Contacts.class, null).commit();
        navView.getMenu().findItem(R.id.navigation_contacts).setChecked(true);
    }

    void chatsPage() {
//        LinkedList<String> chatsList = new LinkedList<>();
//
//        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("Chat/JonathanOctavien-JonathanO/221218-110211/message");
//        myRef.get().addOnCompleteListener(task -> {
//            if (!task.isSuccessful()) {
//                Log.e("firebase", "Error getting data", task.getException());
//            }
//            else {
//                String value = String.valueOf(task.getResult().getValue());
//                JSONObject jsonObject = null;
//                try {
//                    jsonObject = new JSONObject(value);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                if (jsonObject != null) {
//                    Iterator<String> keys = jsonObject.keys();
//                    while( keys.hasNext() ) {
//                        String key = (String) keys.next();
//                        chatsList.add(key);
//                    }
//                }
//
//                String name = String.valueOf(task.getResult().getValue());
//                Log.d("firebaseaaa", name);
//                chatsList.add(name);
//            }
//        });

//        Bundle bundle = new Bundle();
//        bundle.putString("testText", chatsList.toString());

//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, Chats.class, bundle).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, Chats.class, null).commit();
        navView.getMenu().findItem(R.id.navigation_chats).setChecked(true);
    }
}