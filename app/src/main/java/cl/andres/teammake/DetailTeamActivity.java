package cl.andres.teammake;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cl.andres.teammake.models.Player;
import cl.andres.teammake.models.Team;

public class DetailTeamActivity extends AppCompatActivity {

    private DetailTeamActivityFragment detailTeamActivityFragment;
    private Team team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_team);

        final long id = getIntent().getLongExtra(TeamsListFragment.TEAM_ID, 0);

        team = team.findById(Team.class, id);
        Toast.makeText(getApplicationContext(),String.valueOf(team.getName()), Toast.LENGTH_SHORT).show();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(team.getName());

        detailTeamActivityFragment = (DetailTeamActivityFragment) getSupportFragmentManager().findFragmentById(R.id.DetailTeamActivityFragment);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.playerEt);
                String namePlayer = editText.getText().toString();

                if (namePlayer.trim().length() > 0){
                    Player player = new Player();
                    player.setName(namePlayer);
                    player.setTeam_id(id);
                    player.save();

                    detailTeamActivityFragment.addPlayer(player);

                    editText.setText("");

                } else {
                    Toast.makeText(DetailTeamActivity.this, "Agrega un jugador", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }

}
