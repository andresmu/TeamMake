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
import cl.andres.teammake.models.Player;

/**
 * Created by Andrés on 30-05-2017.
 */

public class PlayersAdapter extends  RecyclerView.Adapter<PlayersAdapter.ViewHolder> {


    private List<Player> players;

    public PlayersAdapter(long id) {
        players = Player.find(Player.class, "teamId = ?", String.valueOf(id));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_detail, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Player player = players.get(position);
        CheckBox checkBox = holder.checkBox;
        checkBox.setChecked(false);

        TextView textView = holder.textView;
        textView.setText(player.getName());

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){

                    int auxPosition = holder.getAdapterPosition();
                    players.get(auxPosition);
                    players.remove(auxPosition);
                    player.delete();
                    notifyItemRemoved(auxPosition);
                }
            }
        });
    }


    public void addPlayer(Player player){
        players.add(0, player);
        notifyItemInserted(0);
    }


    @Override
    public int getItemCount() {
        return players.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CheckBox checkBox;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            checkBox = (CheckBox) itemView.findViewById(R.id.playerCb);
            textView = (TextView) itemView.findViewById(R.id.playerTv);
        }
    }

}
