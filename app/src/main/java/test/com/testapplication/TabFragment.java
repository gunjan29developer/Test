package test.com.testapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@SuppressLint("ALL")
public class TabFragment extends Fragment {
    private Context context;
    private int selected_position;
    private String categoryID;
    private RecyclerView rvAlbums;
    private AlbumsListAdapter albumsListAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<AlbumsList> albumsList = new ArrayList<>();
    private String[] albumNames={"EMPTINESS FT. JUSTIN TIBLEKAR","I' M FALLING LOVE WITH YOU","BABY FT. JUSTIN BABER","WHITE HORSE FT. TAYLOR SWIFT"};
    private String[] albumTime={"18 HOURS AGO","20 HOURS AGO","22 HOURS AGO","24 HOURS AGO"};

    private String[] albumDetails={"Lorem Ipsum is simply dummy text of the printing and typesetting industry","Lorem Ipsum is simply dummy text of the printing and typesetting industry",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry","Lorem Ipsum is simply dummy text of the printing and typesetting industry"
            };
    private int[] albuPic={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};

    public static TabFragment newInstance(int pos) {
        TabFragment tabFragment = new TabFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("position",pos);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            selected_position =  bundle.getInt("position");
            categoryID=bundle.getString("category_id");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tag,null);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListItems();
        findId(view);


    }

    private void setListItems() {

        for (int i = 0;  i<albumNames.length ; i++) {

            AlbumsList albumList=new AlbumsList();
            albumList.setAlbumName(albumNames[i]);
            albumList.setTime(albumTime[i]);
            albumList.setAlbumDetails(albumDetails[i]);
            albumList.setAlbumPic(albuPic[i]);

            albumsList.add(albumList);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void findId(View view) {

        rvAlbums= (RecyclerView) view.findViewById(R.id.rv_albums);
        rvAlbums.setLayoutManager(new LinearLayoutManager(context));
        albumsListAdapter = new AlbumsListAdapter(context,albumsList);
        linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        rvAlbums.setLayoutManager(linearLayoutManager);
        rvAlbums.setAdapter(albumsListAdapter);

    }

}
