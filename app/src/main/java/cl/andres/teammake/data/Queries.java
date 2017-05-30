package cl.andres.teammake.data;

import android.support.v7.app.AppCompatActivity;

import java.util.List;

import cl.andres.teammake.models.Player;
import cl.andres.teammake.models.Team;

/**
 * Created by Andrés on 30-05-2017.
 */

public class Queries extends AppCompatActivity {

    public List<Team> Teams(){
        return Team.listAll(Team.class);
    }


    public List<Player> Players(){
        //long id = getIntent().getLongExtra(TeamsListFragment.TEAM_ID, 0);
        //String myString = Long.toString(id);
//        return Player.find(Player.class, "teamId = ?", id); --> No comprendi porque no funcionó...
        return Player.listAll(Player.class);

    }

}
