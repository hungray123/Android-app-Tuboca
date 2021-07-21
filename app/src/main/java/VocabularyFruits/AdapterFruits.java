package VocabularyFruits;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.english.R;

import java.util.List;

import DB_VOCABULARY.VocabularyDBHelper;

public class AdapterFruits extends RecyclerView.Adapter<AdapterFruits.ViewHolder> {
    //Initialize variable;
     final private Context context;
     final  private List<Fruits> fruitsList;
     VocabularyDBHelper databaseFruit;
//     View.OnClickListener listener;


//    public AdapterSports(Context context ,List<Sports> sportsList){
//        this.context=context;
//        this.sportsList=sportsList;
//
//    }
    //Initialize the dataset of the Adapter.
    //Constructor
    public AdapterFruits(Context context, List<Fruits> fruitsList, VocabularyDBHelper databaseFruit) {
        this.context = context;
        this.fruitsList = fruitsList;
        this.databaseFruit = databaseFruit;
//        this.listener=listener;

    }

//    private  int[] images;
//    public AdapterSports(int[] images)
//    {
//        this.images = images;
//    }

    @NonNull
    @Override
    public AdapterFruits.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fruits,parent,false);
         return  new ViewHolder(view);

    }

    @Override
    public long getItemId(int position) {
        Toast.makeText(context,"you clicked on: "
                +  position  , Toast.LENGTH_SHORT).show();
        return super.getItemId(position);
    }

    @Override
    public void onBindViewHolder(@NonNull  AdapterFruits.ViewHolder holder, int position ) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
//        holder.getImageSports().setBackgroundResource(images[position]);
//       set data on data view
        Fruits data = fruitsList.get(position);
        holder.getImageSports().setImageResource(data.getImageFruits());
        holder.Word.setText(data.getWord());
        holder.IPA.setText(data.getIpa());
        holder.Mean.setText(data.getMean());



//        Toast.makeText(context,"day la position "
//                +  position , Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getItemCount() {
        //return array length
//
//        return images.length;
        return fruitsList.size();
    }
     // Provide a reference to the type of views that you are using
     //custom ViewHolder
    public static  class ViewHolder extends RecyclerView.ViewHolder {
        //Initialize variable
       final ImageView imageSports;
        TextView Word;
        TextView  IPA;
        TextView Mean;
        ImageView icStar;


        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            // Define click listener for the ViewHolder's View
            imageSports=itemView.findViewById(R.id.image_fruit);
            Word=itemView.findViewById(R.id.wordFruit);
            IPA=itemView.findViewById(R.id.ipaFruit);
            Mean=itemView.findViewById(R.id.meanFruit);
            icStar=itemView.findViewById(R.id.StarFruit);
            icStar.setClickable(true);
            icStar.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    icStar.setBackgroundResource(R.drawable.start_boder_32);
                    return  true;
                }
            });
            icStar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    icStar.setBackgroundResource(R.drawable.star_32);
                }
            });

        }
        public ImageView getImageSports(){
            return  imageSports;
        }


    }
}
