package android.example.reportcardsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ReportCardAdapter extends ArrayAdapter<ReportCard> {


    public ReportCardAdapter(@NonNull Context context, ArrayList reportCards) {
        super(context,0, reportCards);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView==null){
            convertView= LayoutInflater.from(this.getContext()).inflate(R.layout.list_view,parent,false);
        }

        ReportCard reportCard=getItem(position);

        TextView studentName= (TextView)convertView.findViewById(R.id.name);
        studentName.setText(reportCard.getStudentName());

        TextView courseId= (TextView)convertView.findViewById(R.id.courseID);
        courseId.setText(reportCard.getCourseID()+"");

        TextView grade= (TextView)convertView.findViewById(R.id.grades);
        grade.setText(reportCard.getGrade());

        return convertView;

    }
}
