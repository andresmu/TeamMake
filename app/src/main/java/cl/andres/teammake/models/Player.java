package cl.andres.teammake.models;

import com.orm.SugarRecord;

/**
 * Created by Andrés on 30-05-2017.
 */

public class Player extends SugarRecord {
    private String name;
    private long teamId;

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }
}
