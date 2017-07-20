package test.com.testapplication;


import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import test.com.testapplication.pager_indicator.CirclePageIndicator;


@SuppressWarnings("ALL")
public class HomeFragment extends Fragment  {
    private Context context;
    private ViewPager videoPager;
    private CirclePageIndicator videoPageIndicator;
    private  VideoPagerAdapter videoPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<VideosLists> videosLists=new ArrayList<>();
    int[] videoImages={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    String[] videoNames={"chain smoker new album 2016","new solo song","Jublie ","Mustafa","Parry",};
    String[] videoSubTitles={"ft rihana and user","ft michel","ft nicholas ","ft michel","Parry",};
    String[] tabNames={"VIDEOS","IMAGES","MILESTONES"};
    private int[] tabIcons = {
            R.drawable.video,
            R.drawable.image,
            R.drawable.milestone
    };


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_home, null);

        addList();

        findId(view);

        setVideoPagerAdapter();



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                tab.getIcon().setColorFilter(ContextCompat.getColor(context,R.color.colorPrimary), PorterDuff.Mode.SRC_IN);


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(ContextCompat.getColor(context,R.color.colorBlack), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    private void addList() {

        for (int i = 0; i <videoImages.length ; i++) {

            VideosLists videoList=new VideosLists();
            videoList.setVideoName(videoNames[i]);
            videoList.setVideoImage(videoImages[i]);
            videoList.setVideoSubtitle(videoSubTitles[i]);
            videosLists.add(videoList);
        }
    }

    private void setVideoPagerAdapter() {

        videoPagerAdapter = new VideoPagerAdapter(context,getFragmentManager(),videosLists);
        videoPager.setAdapter(videoPagerAdapter);
        videoPageIndicator.setViewPager(videoPager);
        videoPagerAdapter.notifyDataSetChanged();
    }

    private void findId(View view) {

        videoPager= (ViewPager) view.findViewById(R.id.view_pager_video);
        videoPageIndicator= (CirclePageIndicator) view.findViewById(R.id.video_page_indicator);

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(1);
        setupViewPager(viewPager);

        viewPager.setCurrentItem(0);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(videosLists.size());
        setupTabIcons();

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void setupTabIcons() {


        tabLayout.getTabAt(0).setIcon(R.mipmap.select_video);
        tabLayout.getTabAt(1).setIcon(R.mipmap.image);
        tabLayout.getTabAt(2).setIcon(R.mipmap.milestone);


     /*   TextView tabThree = (TextView) LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        tabThree.setText("MILESTONES");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.milestone, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);*/
    }

    private List<String> mFragmentTitleList = new ArrayList<>();


    public class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return TabFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return tabNames.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabNames[position];
        }

    }



}

