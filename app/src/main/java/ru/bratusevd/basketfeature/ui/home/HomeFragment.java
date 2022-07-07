package ru.bratusevd.basketfeature.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import ru.bratusevd.basketfeature.R;
import ru.bratusevd.basketfeature.models.GameModel;
import ru.bratusevd.basketfeature.models.TeamModel;
import ru.bratusevd.basketfeature.ui.match.MatchFragment;
import ru.bratusevd.basketfeature.ui.teams.TeamAdapter;

public class HomeFragment extends Fragment {

    private ImageView addGame;
    private ListView gameList;

    private View rootView;
    private String logTag = "Games";
    private GameAdapter gameAdapter;

    public HomeFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        makeLog("onCreate");
        findViews();
        setOnClick();
        return rootView;
    }

    private void findViews(){
        makeLog("findView");
        addGame = rootView.findViewById(R.id.game_add);
        gameList = rootView.findViewById(R.id.game_list);
        setListAdapter();
    }

    private void setOnClick(){
        makeLog("setOnClick");
        addGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addGameClick();
            }
        });
    }

    private void addGameClick(){
        makeLog("addGameClick");
        openFragment(new MatchFragment());
        showAlertDialog();
    }

    private void setListAdapter(){
        makeLog("setListAdapter");
        ArrayList<GameModel> gameModels = new ArrayList<>();
        gameModels.add(new GameModel("Game 1", "1/1"));
        gameModels.add(new GameModel("Game 2", "1/1"));
        gameModels.add(new GameModel("Game 3", "1/1"));
        gameModels.add(new GameModel("Game 4", "1/1"));
        gameModels.add(new GameModel("Game 5", "1/1"));
        gameModels.add(new GameModel("Game 6", "1/1"));
        gameModels.add(new GameModel("Game 7", "1/1"));
        gameModels.add(new GameModel("Game 8", "1/1"));
        gameModels.add(new GameModel("Game 9", "1/1"));
        gameModels.add(new GameModel("Game 10", "1/1"));
        gameModels.add(new GameModel("Game 11", "1/1"));
        gameModels.add(new GameModel("Game 12", "1/1"));

        gameAdapter = new GameAdapter(getContext(), gameModels);
        gameList.setAdapter(gameAdapter);
    }

    private void showAlertDialog(){
        makeLog("showAlertDialog");
    }

    private void makeToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void openFragment(Fragment fragment) {
        getActivity().findViewById(R.id.nav_view).setVisibility(View.INVISIBLE);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void makeLog(String message) {
        Log.d(logTag, message);
    }
}