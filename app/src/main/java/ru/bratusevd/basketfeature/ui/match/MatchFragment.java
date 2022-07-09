package ru.bratusevd.basketfeature.ui.match;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import ru.bratusevd.basketfeature.R;
import ru.bratusevd.basketfeature.models.GameModel;
import ru.bratusevd.basketfeature.models.PlayerModel;
import ru.bratusevd.basketfeature.ui.home.GameAdapter;
import ru.bratusevd.basketfeature.ui.player.PlayerAdapter;

public class MatchFragment extends Fragment {
    private View rootView;
    private String logTag = "Match";
    private MatchAdapter matchAdapter;

    private ListView leftTeam;
    private ListView rightTeam;

    public MatchFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_match, container, false);
        findViews();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        BottomNavigationView navBar = getActivity().findViewById(R.id.nav_view);
        navBar.setVisibility(View.INVISIBLE);
        makeLog("onCreate");
        return rootView;
    }

    private void findViews(){
        makeLog("findView");
        leftTeam = rootView.findViewById(R.id.left_team);
        rightTeam = rootView.findViewById(R.id.right_team);
        setListAdapter();
    }

    private void setListAdapter(){
        makeLog("setListAdapter");
        ArrayList<PlayerModel> playerModels = new ArrayList<>();
        playerModels.add(new PlayerModel("Game 1", "19"));
        playerModels.add(new PlayerModel("Game 2", "19"));
        playerModels.add(new PlayerModel("Game 3", "19"));
        playerModels.add(new PlayerModel("Game 4", "19"));
        playerModels.add(new PlayerModel("Game 5", "19"));

        matchAdapter = new MatchAdapter(getContext(), playerModels);
        leftTeam.setAdapter(matchAdapter);
        rightTeam.setAdapter(matchAdapter);
    }

    @Override
    public void onDestroyView() {
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onDestroy();
    }

    private void makeLog(String message) {
        Log.d(logTag, message);
    }
}
