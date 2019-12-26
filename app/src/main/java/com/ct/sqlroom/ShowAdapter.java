package com.ct.sqlroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ct.sqlroom.data.Student;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ShowHolder> {


    private LayoutInflater inflater;
    private List<Student> data;
    private GetItemListener listener;
    private DeleteItemListener deleteItemListener;

    public ShowAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setDeleteItemListener(DeleteItemListener deleteItemListener) {
        this.deleteItemListener = deleteItemListener;
    }

    public void setListener(GetItemListener listener) {
        this.listener = listener;
    }

    public void setData(List<Student> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ShowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShowHolder(inflater.inflate(R.layout.item_student, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShowHolder holder, int position) {
        Student student = data.get(position);
        holder.bindView(student);
        holder.itemView.setOnClickListener(view -> listener.clickItem(position));
        holder.tvDelete.setOnClickListener(view -> deleteItemListener.clickDeleteItem(position));

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }


    interface GetItemListener {
        void clickItem(int id);
    }

    interface DeleteItemListener {
        void clickDeleteItem(int id);
    }

    class ShowHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_class)
        TextView tvClass;
        @BindView(R.id.tv_score)
        TextView tvScore;
        @BindView(R.id.tv_delete)
        TextView tvDelete;

        public ShowHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindView(Student item) {
            tvClass.setText(item.getClassRoom());
            tvName.setText(item.getName());
            tvScore.setText(item.getScore() + "");

        }
    }
}
