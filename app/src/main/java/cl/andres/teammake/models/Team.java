package cl.andres.teammake.models;

import com.orm.SugarRecord;

/**
 * Created by Andrés on 30-05-2017.
 */

public class Team extends SugarRecord {
    private String name;

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
