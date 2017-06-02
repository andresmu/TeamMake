package cl.andres.teammake;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cl.andres.teammake.adapters.PlayersAdapter;
import cl.andres.teammake.models.Player;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailTeamActivityFragment extends Fragment {
    private PlayersAdapter adapter;


    //private PlayersAdapter adapter;

    public DetailTeamActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_team, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);

        long id = getActivity().getIntent().getLongExtra(TeamsListFragment.TEAM_ID, 0);

        adapter = new PlayersAdapter(id);

        recyclerView.setAdapter(adapter);

    }

    public void addPlayer(Player player){
        Toast.makeText(getContext(), player.getName(), Toast.LENGTH_SHORT).show();
        adapter.addPlayer(player);
    }
}
