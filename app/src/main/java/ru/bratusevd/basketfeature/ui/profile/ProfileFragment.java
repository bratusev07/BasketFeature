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

import androidx.annotation.NonNull;
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
        setFocusable();
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

                profile_name.setText("");
                profile_surname.setText("");
                profile_season.setText("");
                profile_position.setText("");
            }
        });
    }

    private void setFocusable() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if ((profile_name.getFocusable() == View.NOT_FOCUSABLE)) {
                profile_name.setFocusable(View.FOCUSABLE);
                profile_surname.setFocusable(View.FOCUSABLE);
                profile_season.setFocusable(View.FOCUSABLE);
                profile_position.setFocusable(View.FOCUSABLE);
            } else {
                profile_name.setFocusable(View.NOT_FOCUSABLE);
                profile_surname.setFocusable(View.NOT_FOCUSABLE);
                profile_season.setFocusable(View.NOT_FOCUSABLE);
                profile_position.setFocusable(View.NOT_FOCUSABLE);
            }
        }
    }

    private void updateHint(){
        img_edit.setVisibility(View.VISIBLE);
        profile_save.setVisibility(View.INVISIBLE);
        profile_name.setHint(profile_name.getText().toString());
        profile_surname.setHint(profile_surname.getText().toString());
        profile_season.setHint(profile_season.getText().toString());
        profile_position.setHint(profile_position.getText().toString());
    }

    private void editButton() {
        img_edit.setVisibility(View.INVISIBLE);
        profile_save.setVisibility(View.VISIBLE);
        setFocusable();
    }

    private void makeToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void makeLog(String message) {
        Log.d(logTag, message);
    }
}