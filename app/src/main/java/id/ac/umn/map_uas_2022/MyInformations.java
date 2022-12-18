package id.ac.umn.map_uas_2022;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyInformations extends Fragment {

    ImageView profilePicture;
    TextView displayName;
    ImageButton settingsButton;

    public MyInformations() {
        super(R.layout.my_informations);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        String username = requireArguments().getString("username");

        // take name from database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User/" + username + "/name");
        myRef.get().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.e("firebase", "Error getting data", task.getException());
            }
            else {
                String name = String.valueOf(task.getResult().getValue());
                Log.d("firebase", name);
                setDisplayName(name);
            }
        });

        setSettingsButton();

        super.onViewCreated(view, savedInstanceState);
    }

    public void setProfilePicture(Resources res, int resId) {
        profilePicture = requireView().findViewById(R.id.profilePicture);
        profilePicture.setImageResource(resId);
    }

    public void setDisplayName(String name) {
        displayName = (TextView) requireView().findViewById(R.id.displayName);
        displayName.setText(name);
    }

    public void setSettingsButton() {
        settingsButton = (ImageButton) requireView().findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MyInformationsSettings.class);
            startActivity(intent);
        });
    }
}