package cl.andres.teammake.models;

import com.orm.SugarRecord;

/**
 * Created by Andrés on 30-05-2017.
 */

public class Player extends SugarRecord {
    private String name;
    private long team_id;
/*    private List<Player> players = new ArrayList<Player>();

    public Player(List<Player> players) {
        this.players = players;
    }*/

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(long team_id) {
        this.team_id = team_id;
    }
}
