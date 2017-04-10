package activitytest.example.com.title;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/26 0026.
 */

public class RecommendTitleFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ListView recommendTitleListView;
    private List<Recommend> recommendList;
    private RecommendAdapter adapter;
    private boolean isTwoPane;
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        recommendList=getRecommend();
        adapter=new RecommendAdapter(activity,R.layout.recommend_item,recommendList);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.recommend_title_frag,container,false);
        recommendTitleListView=(ListView)view.findViewById(R.id.recommend_title_list_view);
        recommendTitleListView.setAdapter(adapter);
        recommendTitleListView.setOnItemClickListener(this);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);
        if (getActivity().findViewById(R.id.recommend_content_layout)!=null){
            isTwoPane=true;
        }else {
            isTwoPane=false;
        }
    }
    @Override
    public void onItemClick(AdapterView<?>parent,View view,int position,long id){
        Recommend recommend=recommendList.get(position);
        if(isTwoPane){
            RecommendContentFragment recommendContentFragment=(RecommendContentFragment)getFragmentManager().findFragmentById(R.id.recommend_content_fragment);
            recommendContentFragment.refresh(recommend.getTitle(),recommend.getContent());
        }else {
            RecommendContentActivity.actionStart(getActivity(),recommend.getTitle(),recommend.getContent());
        }
    }
    private List<Recommend> getRecommend(){
        List<Recommend> recommendList=new ArrayList<Recommend>();
        Recommend recommend1=new Recommend();
        recommend1.setTitle("广东工业大学高等数学大神学习笔记");
        recommend1.setContent("内容待定");
        recommendList.add(recommend1);
        Recommend recommend2=new Recommend();
        recommend2.setTitle("高三化学冲刺拿分，状元告诉你如何学习");
        recommend2.setContent("内容待定");
        recommendList.add(recommend2);
        return recommendList;
    }

}
