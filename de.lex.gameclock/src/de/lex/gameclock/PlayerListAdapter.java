package de.lex.gameclock;

import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

public class PlayerListAdapter extends ArrayAdapter<String>{

	private List<String> players;

	public PlayerListAdapter(Context context, List<String> players) {
		super(context, android.R.layout.simple_list_item_1, players);
		this.players = players;
	}

	public void removePlayer(int position) {
		players.remove(position);
		notifyDataSetChanged();
	}

	public void addPlayer(String name) {
		players.add(name);
		notifyDataSetChanged();
	}

	public void clearPlayers() {
		clear();
		notifyDataSetChanged();
	}
	
}
