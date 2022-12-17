package id.ac.umn.map_uas_2022;

import android.content.Intent;
import android.content.res.Resources;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MyInformations extends Fragment {

    ImageView profilePicture;
    TextView displayName;
    ImageButton settingsButton;

    public MyInformations() {
        super(R.layout.my_informations);
//        setDisplayName("John Doe");
//        setSettingsButton();

//        profilePicture = getView().findViewById(R.id.profilePicture);
//        Resources res = getResources();
//        profilePicture.setImageDrawable(res.getDrawable(R.drawable.default_profile_picture));

    }

    public void setProfilePicture(Resources res, int resId) {
        profilePicture = requireView().findViewById(R.id.profilePicture);
        profilePicture.setImageResource(resId);
    }

    public void setDisplayName(String name) {
        displayName = requireView().findViewById(R.id.displayName);
        displayName.setText(name);
    }

    public void setSettingsButton() {
        settingsButton = requireView().findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MyInformationsSettings.class);
            startActivity(intent);
        });
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