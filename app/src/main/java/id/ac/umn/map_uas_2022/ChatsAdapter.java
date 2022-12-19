package id.ac.umn.map_uas_2022;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ChatsViewHolder> {
    Context context;

    private final LayoutInflater inflater;
    private final LinkedList<String[]> chatsList;

    ChatsAdapter(Context context, LinkedList<String[]> chatsList) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.chatsList = chatsList;
    }

    @NonNull
    @Override
    public ChatsAdapter.ChatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.chats_list, parent, false);
        return new ChatsViewHolder((ViewGroup) itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatsAdapter.ChatsViewHolder holder, int position) {
        String[] current = chatsList.get(position);
        holder.contactName.setText(current[0]);
    }

    @Override
    public int getItemCount() {
        return chatsList.size();
    }

    public class ChatsViewHolder extends RecyclerView.ViewHolder {
        ChatsAdapter adapter;

        LinearLayout chatsView;
        TextView contactName;

        public ChatsViewHolder(@NonNull View itemView, ChatsAdapter chatsAdapter) {
            super(itemView);
            chatsView = itemView.findViewById(R.id.chatList);
            contactName = itemView.findViewById(R.id.contactName);
            this.adapter = chatsAdapter;
        }
    }
}
