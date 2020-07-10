package com.example.helloworld;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {
    ArrayList<Name> name = new ArrayList<Name>();
    Context context;

    public RecAdapter(ArrayList<Name> name) {
        this.name = name;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.txt.setText(name.get(position).getName());
        Glide.with(context).load(name.get(position).getImageId()).into(holder.imageView);
        holder.down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.expand.setVisibility(View.VISIBLE);
                holder.descript.setText("Hello You Expanded CardView Of " + name.get(position).getName() + "\n\n\t Good Bye :-) ");
                holder.down.setVisibility(View.GONE);
            }
        });
        holder.up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.expand.setVisibility(View.GONE);
                holder.down.setVisibility(View.VISIBLE);
            }
        });
        holder.card.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(context, "Going To Delete CardView Of " + name.get(position).getName(), Toast.LENGTH_SHORT).show();
                final Name temp = name.get(position);
                name.remove(position);
                notifyDataSetChanged();
                if(name.size()!=1)
                {
                Snackbar.make(view, "Deleted " + temp.getName(), Snackbar.LENGTH_LONG)
                        .setTextColor(context.getColor(R.color.haunter))
                        .setAction(" UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                name.add(position,temp);
                                notifyDataSetChanged();

                            }
                        }).show();}
                return false;
            }
        });
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context,WebView.class);
               context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txt, descript;
        private ImageView imageView;
        private CardView card;
        private RelativeLayout expand;
        private ImageView down, up;

        public ViewHolder(View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.rtv);
            card = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.image);
            expand = itemView.findViewById(R.id.min);
            down = itemView.findViewById(R.id.down);
            descript = itemView.findViewById(R.id.descript);
            up = itemView.findViewById(R.id.up);

        }
    }
}
