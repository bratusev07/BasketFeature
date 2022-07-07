package ru.bratusevd.basketfeature.ui.player;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import ru.bratusevd.basketfeature.R;
import ru.bratusevd.basketfeature.models.PlayerModel;

public class PlayerFragment extends Fragment {
    private ImageView addPlayer;
    private ListView playerList;

    private View rootView;
    private String logTag = "Player";
    private PlayerAdapter playerAdapter;

    public PlayerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_players, container, false);
        makeLog("onCreate");
        findViews();
        setOnClick();
        return rootView;
    }

    private void findViews() {
        makeLog("findView");
        addPlayer = rootView.findViewById(R.id.player_add);
        playerList = rootView.findViewById(R.id.player_list);
        setListAdapter();
    }

    private void setOnClick() {
        makeLog("setOnClick");
        addPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPlayerClick();
            }
        });
    }

    private void addPlayerClick() {
        makeLog("addPlayerClick");
        showAlertDialog();
    }

    private void setListAdapter() {
        makeLog("setListAdapter");
        ArrayList<PlayerModel> playerModels = new ArrayList<>();
        playerModels.add(new PlayerModel("Player 1", "19"));
        playerModels.add(new PlayerModel("Player 2", "19"));
        playerModels.add(new PlayerModel("Player 3", "19"));
        playerModels.add(new PlayerModel("Player 4", "19"));
        playerModels.add(new PlayerModel("Player 5", "19"));
        playerModels.add(new PlayerModel("Player 6", "19"));
        playerModels.add(new PlayerModel("Player 7", "19"));
        playerModels.add(new PlayerModel("Player 8", "19"));
        playerModels.add(new PlayerModel("Player 9", "19"));
        playerModels.add(new PlayerModel("Player 10", "19"));
        playerModels.add(new PlayerModel("Player 11", "19"));
        playerModels.add(new PlayerModel("Player 12", "19"));

        playerAdapter = new PlayerAdapter(getContext(), playerModels);
        playerList.setAdapter(playerAdapter);
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
