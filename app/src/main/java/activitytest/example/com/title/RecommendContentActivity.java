package activitytest.example.com.title;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by Administrator on 2017/2/26 0026.
 */

public class RecommendContentActivity extends Activity {
    public static void actionStart(Context context,String recommendTitle,String recommendContent){
        Intent intent=new Intent(context,RecommendContentActivity.class);
        intent.putExtra("recommend_title",recommendTitle);
        intent.putExtra("recommend_content",recommendContent);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.recommend_content);
        String recommendTitle=getIntent().getStringExtra("recommend_title");
        String recommendContent=getIntent().getStringExtra("recommend_content");
        RecommendContentFragment recommendContentFragment=(RecommendContentFragment)getFragmentManager().findFragmentById(R.id.recommend_content_fragment);
        recommendContentFragment.refresh(recommendTitle,recommendContent);
    }
}
