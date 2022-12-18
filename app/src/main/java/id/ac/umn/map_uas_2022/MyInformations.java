package id.ac.umn.map_uas_2022;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyInformations extends Fragment {

    ImageView profilePicture;
    TextView displayName;
    ImageButton settingsButton;

    public MyInformations() {
        super(R.layout.my_informations);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        String name = requireArguments().getString("name");
        setDisplayName(name);

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