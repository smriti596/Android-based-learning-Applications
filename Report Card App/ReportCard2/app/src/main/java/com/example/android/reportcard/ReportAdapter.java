package com.example.android.reportcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ReportAdapter extends ArrayAdapter<reportCardClass>{
    public ReportAdapter(@NonNull Context context, ArrayList<reportCardClass> report) {
        super(context,0,report );
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        reportCardClass currentreport = getItem(position);
        TextView sub_name_text_view = (TextView) row.findViewById(R.id.sub_name);
        sub_name_text_view.setText(currentreport.getSname());
        TextView sub_marks_text_view= (TextView)row.findViewById(R.id.sub_marks);
        sub_marks_text_view.setText(currentreport.getSmarks());
        TextView sub_grade_text_view= (TextView)row.findViewById(R.id.sub_grade);
        sub_grade_text_view.setText(currentreport.getSgrade());
      return row;
    }


    }



