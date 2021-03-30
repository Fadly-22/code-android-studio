package com.example.bacamanga2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JudulAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Judul>juduls;

    void setJuduls(ArrayList<Judul> juduls) {
        this.juduls = juduls;
    }

    JudulAdapter(Context context) {
        this.context = context;
        juduls = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return juduls.size();
    }

    @Override
    public Object getItem(int i) {
        return juduls.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_judul, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Judul judul = (Judul) getItem(i);
        viewHolder.bind(judul);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDetail;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDetail = view.findViewById(R.id.txt_detail);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Judul judul){
            txtName.setText(judul.getName());
            txtDetail.setText(judul.getDetail());
            imgPhoto.setImageResource(judul.getPhoto());
        }
    }
}
