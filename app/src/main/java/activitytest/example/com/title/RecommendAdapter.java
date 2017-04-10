package activitytest.example.com.title;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Administrator on 2017/2/26 0026.
 */

public class RecommendAdapter extends ArrayAdapter<Recommend> {
    private int resourceId;
    public RecommendAdapter(Context context, int textViewResourceId, List<Recommend>objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Recommend recommend=getItem(position);
        View view;
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        }else {
            view=convertView;
        }
        TextView recommendTitleText=(TextView)view.findViewById(R.id.recommend_title);
        recommendTitleText.setText(recommend.getTitle());
        return view;
    }
}
