package com.example.ebuka.testtask.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ebuka.testtask.interfaces.OnAssignmentClickListener;
import com.example.ebuka.testtask.model.Assignment;
import com.example.ebuka.testtask.R;

import java.util.List;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.ViewHolder> {
    private OnAssignmentClickListener listener;
    private List<Assignment> list;

    public AssignmentAdapter(List<Assignment> list, OnAssignmentClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() { return list == null ? 0 : list.size(); }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Assignment assignment = list.get(position);
        if(assignment == null) return;
        holder.onBind(assignment);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView weekEndingDate, employer, workSite, totalHoursWorkedPerWeek;

        public ViewHolder(View v) {
            super(v);
            weekEndingDate = v.findViewById(R.id.weekEndingDate);
            employer = v.findViewById(R.id.employer);
            workSite = v.findViewById(R.id.workSite);
            totalHoursWorkedPerWeek = v.findViewById(R.id.totalHoursWorkedPerWeek);
            v.setOnClickListener(this);
        }

        public void onBind(Assignment assignment){
            weekEndingDate.setText(assignment.getWeekEndingDate());
            employer.setText(assignment.getEmployer());
            workSite.setText(assignment.getWorkSite());
            totalHoursWorkedPerWeek.setText(assignment.getTotalHoursWorkedPerWeek());
        }

        @Override
        public void onClick(View v) {
            Assignment assignment = list.get(getAdapterPosition());
            if(assignment == null) return;

            if(listener != null){
                listener.onClick(assignment);
            }
        }
    }
}