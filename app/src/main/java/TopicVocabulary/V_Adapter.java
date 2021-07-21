package TopicVocabulary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.english.R;
import java.util.ArrayList;

public class V_Adapter extends ArrayAdapter<V_Topic> {
    Context context;
    int layoutResource;
    ArrayList<V_Topic> arrayListTopic;

    public V_Adapter(Context context,int resource,ArrayList<V_Topic>arrayList) {
        super(context, resource,arrayList);
        this.context=context;
        this.layoutResource=resource;
        this.arrayListTopic=arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        convertView=inflater.inflate(layoutResource,null);
        //Ham khoi tao them du lieu vao cac View tu arraylist thong qua position
        TextView tv1=convertView.findViewById(R.id.tvTopic);
        tv1.setText(arrayListTopic.get(position).getTitle());

        ImageView imageView=convertView.findViewById(R.id.imgTopic);
        imageView.setImageResource(arrayListTopic.get(position).getImg());

        return convertView;
    }
}
