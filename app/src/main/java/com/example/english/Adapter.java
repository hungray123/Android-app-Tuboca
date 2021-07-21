//package com.example.english;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//public class Adapter  extends BaseAdapter {
//
//    private final  String title[];
//    private  final  int image[];
//    Context context;
//
//    public Adapter(String[] title, int[] image, Context context) {
//        this.title = title;
//        this.image = image;
//        this.context = context;
//    }
//
//    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return title.length;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view=layoutInflater.inflate(R.layout.quiz_listitem,null);
//
//        ImageView img=(ImageView)view.findViewById(R.id.lv_icon);
//        TextView tv=(TextView)view.findViewById(R.id.tv1);
//
//        img.setImageResource(image[position]);
//        tv.setText(title[position]);
//        return  view;
//
//    }
//}
//
//
//
