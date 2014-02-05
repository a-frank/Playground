package de.lex.gameclock;

import java.util.LinkedList;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView players;
	private Button time;
	
	private PlayerListAdapter playerListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		players = (ListView) findViewById(R.id.players);
		playerListAdapter = new PlayerListAdapter(this, new LinkedList<String>());
		players.setAdapter(playerListAdapter);
		players.setLongClickable(true);
		players.setOnItemLongClickListener(new DeletePlayerListener());
		
		time = (Button) findViewById(R.id.time);
		time.setOnClickListener(new ChangeTimeListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		if(item.getItemId() == R.id.add_player){
			addPlayer();
			return true;
		} else if(item.getItemId() == R.id.start){
			start();
			return true;
		} else if(item.getItemId() == R.id.remove_all_players){
			clearAllPlayers();
			return true;
		}
		return false;
	}

	private void clearAllPlayers() {
		playerListAdapter.clearPlayers();
	}

	private void start() {
		// TODO Auto-generated method stub
	}

	private void addPlayer() {
		Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.player_name);
		final EditText name = new EditText(this);
		name.setHint(R.string.name);
		name.setInputType(InputType.TYPE_CLASS_TEXT);
		builder.setView(name);
		builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				playerListAdapter.addPlayer(name.getText().toString());
			}
		});
		builder.setNegativeButton(R.string.cancel, null);
		builder.show();
	}
	
	private final class DeletePlayerListener implements OnItemLongClickListener {
		@Override
		public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long arg3) {
			playerListAdapter.removePlayer(position);
			return true;
		}
	}

	private final class ChangeTimeListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			
		}
	}
}
