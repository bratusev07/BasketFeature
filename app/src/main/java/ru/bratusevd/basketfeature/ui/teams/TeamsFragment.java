package ru.bratusevd.basketfeature.ui.teams;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

import ru.bratusevd.basketfeature.R;
import ru.bratusevd.basketfeature.models.TeamModel;
import ru.bratusevd.basketfeature.ui.player.PlayerFragment;

public class TeamsFragment extends Fragment {

    private ImageView addTeam;
    private ListView teamList;

    private View rootView;
    private String logTag = "Teams";
    private TeamAdapter teamAdapter;

    public TeamsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_teams, container, false);
        makeLog("onCreate");
        findViews();
        setOnClick();
        return rootView;
    }

    private void findViews() {
        makeLog("findView");
        addTeam = rootView.findViewById(R.id.team_add);
        teamList = rootView.findViewById(R.id.team_list);
        setListAdapter();
    }

    private void setOnClick() {
        makeLog("setOnClick");
        addTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTeamClick();
            }
        });

        teamList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                openFragment(new PlayerFragment());
            }
        });
    }

    private void addTeamClick() {
        makeLog("addTeamClick");
        showAlertDialog();
    }

    private void setListAdapter() {
        makeLog("setListAdapter");
        ArrayList<TeamModel> teamModels = new ArrayList<>();
        teamModels.add(new TeamModel("Team 1"));
        teamModels.add(new TeamModel("Team 2"));
        teamModels.add(new TeamModel("Team 3"));
        teamModels.add(new TeamModel("Team 4"));
        teamModels.add(new TeamModel("Team 5"));
        teamModels.add(new TeamModel("Team 6"));
        teamModels.add(new TeamModel("Team 7"));
        teamModels.add(new TeamModel("Team 8"));
        teamModels.add(new TeamModel("Team 9"));
        teamModels.add(new TeamModel("Team 10"));
        teamModels.add(new TeamModel("Team 11"));
        teamModels.add(new TeamModel("Team 12"));

        teamAdapter = new TeamAdapter(getContext(), teamModels);
        teamList.setAdapter(teamAdapter);
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void showAlertDialog() {
        makeLog("showAlertDialog");
    }

    private void makeToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void makeLog(String message) {
        Log.d(logTag, message);
    }
}