package test.com.testapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

@SuppressWarnings("ALL")
@SuppressLint("ALL")
public class VideoPagerAdapter extends FragmentStatePagerAdapter {

    private Context context;
    List<VideosLists> videosLists;


    public VideoPagerAdapter(Context context, FragmentManager fragmentManager, List<VideosLists> videosLists) {
        super(fragmentManager);
        this.context=context;
        this.videosLists=videosLists;
    }
    @Override
    public int getCount() {
        return videosLists.size();
    }
    @Override
    public Fragment getItem(int position) {
        {
            return   VideoFragment.newInstance(videosLists.get(position).getVideoImage(),videosLists.get(position).getVideoSubtitle()!=null?videosLists.get(position).getVideoSubtitle().toString().trim():"",
                    videosLists.get(position).getVideoName()!=null?videosLists.get(position).getVideoName().toString().trim():"",position);
        }
    }

}
