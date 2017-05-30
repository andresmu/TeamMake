package cl.andres.teammake;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cl.andres.teammake.adapters.TeamsAdapter;
import cl.andres.teammake.adapters.TeamsClick;
import cl.andres.teammake.data.Queries;
import cl.andres.teammake.models.Team;

/**
 * A placeholder fragment containing a simple view.
 */
public class TeamsListFragment extends Fragment implements TeamsClick{

    public static final String TEAM_ID = "cl.andres.teammake.KEY.TEAM_ID";

    private TeamsAdapter adapter;

    public TeamsListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_teamslist, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);

       adapter = new TeamsAdapter(this);

        recyclerView.setAdapter(adapter);
    }

    public void addTeam(Team team){
        Toast.makeText(getContext(), team.getName(), Toast.LENGTH_SHORT).show();
        //adapter.reset();
        adapter.addTeam(team);

    }

    @Override
    public void clicked(long id) {
        Intent intent = new Intent(getActivity(), DetailTeamActivity.class);
        Intent intent1 = new Intent(getActivity(), Queries.class);
        intent1.putExtra(TEAM_ID, id);
        intent.putExtra(TEAM_ID, id);
        startActivity(intent);
    }
}
