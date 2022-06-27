package ru.bratusevd.basketfeature.ui.teams;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

import ru.bratusevd.basketfeature.R;
import ru.bratusevd.basketfeature.models.TeamModel;

public class TeamAdapter extends ArrayAdapter<TeamModel> {

    public TeamAdapter(Context context, ArrayList<TeamModel> teamModel) {
        super(context, android.R.layout.simple_list_item_2, teamModel);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TeamModel teamModel = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_team, null);
        }

        ((TextView)convertView.findViewById(R.id.team_name)).setText(teamModel.getTeamName());
        return convertView;
    }
}
