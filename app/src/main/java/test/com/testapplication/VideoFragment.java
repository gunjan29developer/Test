package test.com.testapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressWarnings("ALL")
@SuppressLint("ALL")
public class VideoFragment extends Fragment implements View.OnClickListener{
    private View view;
    private TextView tvVideoName;
    private TextView tvSubtitle;
    private ImageView ivVideo;
    private Context context;
    private String videoName;
    private int videoImage;
    private String videoSubTitle;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    public static VideoFragment newInstance(int videoImage, String videoSubTitle,String videoName, int position) {

        Bundle args = new Bundle();
        VideoFragment fragment = new VideoFragment();
        args.putInt("videoImage",videoImage);
        args.putString("videoSubTitle",videoSubTitle);
        args.putString("videoName",videoName);
        args.putInt("position",position);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_videos,container,false);

        findById();
        setListener();

        Bundle bundle = this.getArguments();
        int pos=bundle.getInt("position");
        videoImage = bundle.getInt("videoImage");
        videoName = bundle.getString("videoName");
        videoSubTitle = bundle.getString("videoSubTitle");

        if(videoName!=null && videoName.length()>0)
        {
            tvVideoName.setText(videoName);
        }

        if(videoSubTitle!=null && videoSubTitle.length()>0)
        {
            tvSubtitle.setText(videoSubTitle);
        }


        ivVideo.setImageResource(videoImage);



        return view;
    }

    private void setListener() {

        ivVideo.setOnClickListener(this);
    }

    private void findById() {

        tvVideoName=(TextView)view.findViewById(R.id.tv_video_name);
        tvSubtitle=(TextView)view.findViewById(R.id.tv_subtitle);
        ivVideo=(ImageView) view.findViewById(R.id.iv_video);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.iv_video:

                /**
                 * PlayVideo
                 */

                break;

            default:

                break;
        }
    }
}
