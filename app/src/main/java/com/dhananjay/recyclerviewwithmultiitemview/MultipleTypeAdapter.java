package com.dhananjay.recyclerviewwithmultiitemview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MultipleTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static int TYPE_MALE = 0;
    private static int TYPE_FEMALE = 1;
    private Context context;
    private ArrayList<Doctor> doctors;
    private OnRecordEventListener listener;

    public MultipleTypeAdapter(Context context, ArrayList<Doctor> doctors, OnRecordEventListener listener) {
        this.context = context;
        this.doctors = doctors;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        if (viewType == TYPE_FEMALE) { // for female layout
            view = LayoutInflater.from(context).inflate(R.layout.item_female, viewGroup, false);
            return new FemaleViewHolder(view, listener);

        } else { // for male layout
            view = LayoutInflater.from(context).inflate(R.layout.item_male, viewGroup, false);
            return new MaleViewHolder(view, listener);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (doctors.get(position).getGender() == TYPE_FEMALE) {
            return TYPE_FEMALE;
        } else {
            return TYPE_MALE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (getItemViewType(position) == TYPE_FEMALE) {
            ((FemaleViewHolder) viewHolder).setFemaleDetails(doctors.get(position));
        } else {
            ((MaleViewHolder) viewHolder).setMaleDetails(doctors.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    class MaleViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMale;
        private TextView txtName;
        private RatingBar ratingBar;
        private RadioButton radio;

        MaleViewHolder(@NonNull View itemView, final OnRecordEventListener listener) {
            super(itemView);
            imgMale = itemView.findViewById(R.id.imgMale);
            txtName = itemView.findViewById(R.id.txtName);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            radio = itemView.findViewById(R.id.radio);

            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    if (fromUser) {
                        listener.onRatingBarChange(getLayoutPosition(), rating);
                    }
                }
            });

            radio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (doctors.get(getLayoutPosition()).getIsInPerson() == 1) {
                        radio.setChecked(false);
                        listener.onRadioCheckedChange(getLayoutPosition(), false);
                    } else {
                        radio.setChecked(true);
                        listener.onRadioCheckedChange(getLayoutPosition(), true);
                    }
                }
            });
        }

        void setMaleDetails(Doctor doctor) {
            imgMale.setImageResource(R.drawable.other);
            txtName.setText(doctor.getName());
            ratingBar.setRating(doctor.getRating());
            radio.setChecked(doctor.getIsInPerson() == 1);
        }
    }

    class FemaleViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFemale;
        private TextView txtName;
        private RatingBar ratingBar;
        private RadioButton radio;

        FemaleViewHolder(@NonNull View itemView, final OnRecordEventListener listener) {
            super(itemView);
            imgFemale = itemView.findViewById(R.id.imgFemale);
            txtName = itemView.findViewById(R.id.txtName);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            radio = itemView.findViewById(R.id.radio);

            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    if (fromUser) {
                        listener.onRatingBarChange(getLayoutPosition(), rating);
                    }
                }
            });

            radio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (doctors.get(getLayoutPosition()).getIsInPerson() == 1) {
                        radio.setChecked(false);
                        listener.onRadioCheckedChange(getLayoutPosition(), false);
                    } else {
                        radio.setChecked(true);
                        listener.onRadioCheckedChange(getLayoutPosition(), true);
                    }
                }
            });
        }

        void setFemaleDetails(Doctor doctor) {
            imgFemale.setImageResource(R.drawable.female);
            txtName.setText(doctor.getName());
            ratingBar.setRating(doctor.getRating());
            radio.setChecked(doctor.getIsInPerson() == 1);
        }
    }
}
