package cl.andres.teammake.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import cl.andres.teammake.R;
import cl.andres.teammake.data.Queries;
import cl.andres.teammake.models.Team;

/**
 * Created by Andrés on 30-05-2017.
 */

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    private List<Team> teams = new Queries().Teams();
    private TeamsClick listener;

    public TeamsAdapter(TeamsClick listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_team, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Team team = teams.get(position);
        CheckBox checkBox = holder.checkBox;
        checkBox.setChecked(false);

        TextView textView = holder.textView;
        textView.setText(team.getName());

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){

                    int auxPosition = holder.getAdapterPosition();
                    teams.get(auxPosition);
                    teams.remove(auxPosition);
                    team.delete();
                    notifyItemRemoved(auxPosition);
                }
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Team auxTeam = teams.get(holder.getAdapterPosition());
                listener.clicked(auxTeam.getId());
            }
        });

    }

    public void deleteSecond(){

        teams.remove(1);
        notifyItemRemoved(1);
    }

    public void addTeam(Team team){
        teams.add(0, team);
        notifyItemInserted(0);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CheckBox checkBox;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            checkBox = (CheckBox) itemView.findViewById(R.id.teamCb);
            textView = (TextView) itemView.findViewById(R.id.teamTv);
        }
    }
}
