package ru.bratusevd.basketfeature.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ru.bratusevd.basketfeature.R;
import ru.bratusevd.basketfeature.models.GameModel;

public class GameAdapter extends ArrayAdapter<GameModel> {

    public GameAdapter(Context context, ArrayList<GameModel> gameModel) {
        super(context, android.R.layout.simple_list_item_2, gameModel);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GameModel gameModel = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_game, null);
        }

        ((TextView)convertView.findViewById(R.id.game_name)).setText(gameModel.getGameName());
        ((TextView)convertView.findViewById(R.id.scores)).setText(gameModel.getScores());
        return convertView;
    }
}
