package ru.bratusevd.basketfeature.ui.match;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ru.bratusevd.basketfeature.R;
import ru.bratusevd.basketfeature.models.PlayerModel;

public class MatchAdapter extends ArrayAdapter<PlayerModel> {

    public MatchAdapter(Context context, ArrayList<PlayerModel> playerModels) {
        super(context, android.R.layout.simple_list_item_2, playerModels);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PlayerModel playerModel = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_match, null);
        }

        ((TextView)convertView.findViewById(R.id.player_number)).setText(playerModel.getNumber());
        return convertView;
    }
}
