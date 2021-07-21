package QuizList;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.english.R;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<QuizListInfo> {
    Context context;
    ArrayList<QuizListInfo> arrayList;
    int layoutR;
    SharedPreferences preferencesResult;

    public CustomArrayAdapter(QuizListView contexts ,int listitem,ArrayList<QuizListInfo> arrayList) {
        super(contexts, listitem, arrayList);
        this.context=contexts;
        this.arrayList = arrayList;
        this.layoutR = listitem;

    }

    public View getView(int position, View convertView, ViewGroup parent){


        preferencesResult= context.getSharedPreferences("shareCorrect", Context.MODE_PRIVATE);
        String qqq= preferencesResult.getString("totalQuestion","");
        LayoutInflater inflater=LayoutInflater.from(context);
        convertView=inflater.inflate(layoutR,null);
        //inflate tập tin tài nguyên xác định layout của các phần tử

        TextView tv1=convertView.findViewById(R.id.tv1);
        tv1.setText(arrayList.get(position).getLever());

        TextView tv2=convertView.findViewById(R.id.info22);
        tv2.setText(qqq);

        ImageView img =convertView.findViewById(R.id.img1);
        img.setImageResource(arrayList.get(position).getImg());

        return  convertView;


    }
}
