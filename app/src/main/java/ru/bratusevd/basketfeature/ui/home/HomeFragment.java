package ru.bratusevd.basketfeature.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import ru.bratusevd.basketfeature.R;
import ru.bratusevd.basketfeature.customViews.SearchableSpinner;
import ru.bratusevd.basketfeature.models.GameModel;
import ru.bratusevd.basketfeature.models.TeamModel;
import ru.bratusevd.basketfeature.ui.match.MatchFragment;

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
        View promptsView = View.inflate(getContext(), R.layout.add_game_alert, null);
        AlertDialog alertDialog = new MaterialAlertDialogBuilder(getContext(), R.style.RoundShapeTheme)
                .setView(promptsView)
                .create();

        ArrayList<String> teams = new ArrayList<>();
        teams.add(("Team 1"));
        teams.add(("Team 2"));
        teams.add(("Team 3"));
        teams.add(("Team 4"));

        final TextInputEditText gameName = promptsView.findViewById(R.id.createGame_name);
        final TextInputEditText gameDate = promptsView.findViewById(R.id.createGame_date);
        SearchableSpinner teamA = promptsView.findViewById(R.id.teamA_spinner);
        SearchableSpinner teamB = promptsView.findViewById(R.id.teamB_spinner);

        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, teams);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        teamA.setAdapter(adapter);
        teamB.setAdapter(adapter);
        teamA.setSelection(1);
        teamB.setSelection(1);

        promptsView.findViewById(R.id.saveGame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = gameName.getText().toString();
                String date = gameDate.getText().toString();
                String teamModelA = teamA.getSelectedItem().toString();
                String teamModelB = teamB.getSelectedItem().toString();
                Log.d(logTag, name + " " + date + " " + teamModelA + " " + teamModelB);
                openFragment(new MatchFragment());
            }
        });

        alertDialog.show();
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