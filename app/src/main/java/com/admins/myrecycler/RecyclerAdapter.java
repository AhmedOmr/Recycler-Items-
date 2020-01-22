package com.admins.myrecycler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RecyclerAdapter extends
        RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ViewHolder viewHolder;
    private Context context;
    List<String> questionList;
    List<String> displayedList;
    private int currentIndex = 0;

    public RecyclerAdapter(Context context,
                           List<String> allQuestionesList,
                           List<String> displayedList) {
        this.context = context;
        this.questionList = allQuestionesList;
        this.displayedList = displayedList;
        displayedList.add(allQuestionesList.get(0));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // create a new view
        @SuppressLint("InflateParams")
        View itemLayoutView = LayoutInflater.from(context)
                .inflate(R.layout.recycler_item_adapter, null);
        // create ViewHolder
        viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder,
                                 int position) {
        viewHolder.setIsRecyclable(false);
        setData(viewHolder, position);
        setAction(viewHolder, position);
        //animate(viewHolder);
    }

    // set data to items
    private void setData(ViewHolder viewHolder, int position) {
        viewHolder.txt.setText(displayedList.get(position));
    }




    // on click action
    private void setAction(final ViewHolder viewHolder,
                           final int position) {

        viewHolder.noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (displayedList.size() < questionList.size()) {
                    questionList.get(displayedList.size());

                    displayedList.add(questionList.get(displayedList.size()));
                    notifyDataSetChanged();
                }

            }
        });
        viewHolder.yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (displayedList.size() < questionList.size()) {
                    displayedList.add(questionList.get(displayedList.size()));
                    notifyDataSetChanged();
                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return displayedList != null ?
                displayedList.size() : 0;
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        notifyDataSetChanged();
    }


    // inner class to hold a reference to each item of RecyclerView
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        Button yesBtn, noBtn;
        View view;

        ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txt = itemLayoutView.findViewById(R.id.question);
            noBtn = itemLayoutView.findViewById(R.id.answer_no_item);
            yesBtn = itemLayoutView.findViewById(R.id.answer_yes_item);
            view = itemLayoutView;
        }

    }


}