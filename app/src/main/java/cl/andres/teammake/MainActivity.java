package cl.andres.teammake;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import cl.andres.teammake.data.Queries;
import cl.andres.teammake.models.Player;
import cl.andres.teammake.models.Team;


public class MainActivity extends AppCompatActivity {
    private List<Player> teams = new Queries().Players();
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

         if (teams == null) {
             AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
             alertDialog.setTitle("Bienvenido");
             alertDialog.setMessage("Bienvenido a Team Maker, aqui podras crear tus equipos/grupos de todas tus actividades. Solo debes agregar el nombre del grupo/equipo y pulsar el botón de agregar, para agregar jugadores debes hacer lo mismo despues de ingresar al nombre de tus grupos. Que lo disfrutes");
             alertDialog.setPositiveButton("Gracias", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     dialog.dismiss();
                 }
             });
             alertDialog.show();
         }


    }

}
