package cl.andres.teammake;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cl.andres.teammake.models.Team;

public class MainActivity extends AppCompatActivity {

    private TeamsListFragment teamsListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        teamsListFragment = (TeamsListFragment) getSupportFragmentManager().findFragmentById(R.id.teamsListFragment);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText = (EditText) findViewById(R.id.nameEt);
                String nameTeam = editText.getText().toString();

                if (nameTeam.trim().length() > 0){
                    Team team = new Team();
                    team.setName(nameTeam);
                    team.save();
                    teamsListFragment.addTeam(team);
                    editText.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Agrega tu equipo por favor", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
