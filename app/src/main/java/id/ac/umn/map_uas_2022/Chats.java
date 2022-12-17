package id.ac.umn.map_uas_2022;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Chats extends Fragment {

    ImageView profilePicture;
    TextView displayName;
    ImageButton settingsButton;

    public Chats() {
        super(R.layout.fragment_placeholder);
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