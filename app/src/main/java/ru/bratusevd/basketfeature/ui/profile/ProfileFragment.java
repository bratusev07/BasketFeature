package ru.bratusevd.basketfeature.ui.profile;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import ru.bratusevd.basketfeature.R;

public class ProfileFragment extends Fragment {

    private ImageView img_edit;
    private EditText profile_surname;
    private EditText profile_name;
    private EditText profile_season;
    private EditText profile_position;
    private TextView profile_save;
    private View rootView;

    private String logTag = "Profile";

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        makeLog("onCreate");
        findViews();
        setEnabled(false);
        setOnClick();
        return rootView;
    }

    private void findViews() {
        makeLog("findView");
        img_edit = rootView.findViewById(R.id.profile_edit);
        profile_name = rootView.findViewById(R.id.profile_name);
        profile_surname = rootView.findViewById(R.id.profile_surname);
        profile_season = rootView.findViewById(R.id.profile_season);
        profile_position = rootView.findViewById(R.id.profile_position);
        profile_save = rootView.findViewById(R.id.profile_save);
    }

    private void setOnClick() {
        makeLog("setOnClick");
        img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editButton();
            }
        });
        profile_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateHint();
            }
        });
    }

    private void setEnabled(boolean flag) {
        makeLog("setEnabled");
        profile_name.setEnabled(flag);
        profile_surname.setEnabled(flag);
        profile_season.setEnabled(flag);
        profile_position.setEnabled(flag);
    }

    private void updateHint(){
        makeLog("updateText");
        img_edit.setVisibility(View.VISIBLE);
        profile_save.setVisibility(View.INVISIBLE);
        setEnabled(false);
    }

    private void editButton() {
        makeLog("editButton");
        img_edit.setVisibility(View.INVISIBLE);
        profile_save.setVisibility(View.VISIBLE);
        setEnabled(true);
    }

    private void makeToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void makeLog(String message) {
        Log.d(logTag, message);
    }
}