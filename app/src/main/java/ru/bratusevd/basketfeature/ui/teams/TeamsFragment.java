package ru.bratusevd.basketfeature.ui.teams;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import ru.bratusevd.basketfeature.R;

public class TeamsFragment extends Fragment {

    public TeamsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_teams, container, false);

        return rootView;
    }
}