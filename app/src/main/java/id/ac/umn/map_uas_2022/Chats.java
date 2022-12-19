package id.ac.umn.map_uas_2022;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;

public class Chats extends Fragment {

//    ImageView profilePicture;Your location
    TextView displayName;
//    ImageButton settingsButton;
    TextView testText;

//    RecyclerView recyclerView;
//    ChatsAdapter chatsAdapter;
    private final LinkedList<String> chatsList = new LinkedList<String>();

    public Chats() {
        super(R.layout.chats);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("Chat");
//        myRef.get().addOnCompleteListener(task -> {
//            if (!task.isSuccessful()) {
//                Log.e("firebase", "Error getting data", task.getException());
//            } else {
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
//                setTestText(chatsList.toString());
//
////                String name = String.valueOf(task.getResult().getValue());
////                Log.d("firebaseaaa", name);
////                chatsList.add(name);
//            }
//        });

//        String testText = requireArguments().getString("testText");
//        setTestText(chatsList.toString());
        Log.d("firebaseTest", chatsList.toString());

//        recyclerView = requireView().findViewById(R.id.chatList);
//        chatsAdapter = new ChatsAdapter(requireContext(), chatsList);
//        recyclerView.setAdapter(chatsAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        super.onViewCreated(view, savedInstanceState);
    }

    public void setTestText(String name) {
        testText = (TextView) requireView().findViewById(R.id.testText);
        testText.setText(name);
//        testText.setText("name");
    }

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_informations);
//
//        profilePicture = findViewById(R.id.profilePicture);
//        displayName = findViewById(R.id.displayName);
//        settingsButton = findViewById(R.id.settingsButton);
//
////        if (this.getResources().getResourceName(R.id.profilePicture).equals("id.ac.umn.map_uas_2022:id/profilePicture")) {
////            profilePicture.setImageResource(R.drawable.profile_picture);
////        }
//
//        String name = "John Doe";
//        displayName.setText(name);
//
//        settingsButton.setOnClickListener(v -> {
//            Intent intent = new Intent(this, MyInformationsSettings.class);
//            startActivity(intent);
//        });
//    }
}