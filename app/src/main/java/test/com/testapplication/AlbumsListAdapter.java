package test.com.testapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@SuppressLint("ALL")
public class AlbumsListAdapter extends RecyclerView.Adapter<AlbumsListAdapter.MyViewHolder>{
    private LayoutInflater inflater;
    private Context context;
    private List<AlbumsList> albumsLists=new ArrayList<>();

    public AlbumsListAdapter(Context context, List<AlbumsList> albumsLists) {
        this.context=context;
        this.albumsLists=albumsLists;
        inflater = LayoutInflater.from(this.context);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_item_album, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {


        holder.tvAlbumName.setText(albumsLists.get(position).getAlbumName());
        holder.tvAlbumTime.setText(albumsLists.get(position).getTime());
        holder.tvAlbumDetail.setText(albumsLists.get(position).getAlbumDetails());
        holder.ivAlbumImage.setImageResource(albumsLists.get(position).getAlbumPic());


    }
    @Override
    public int getItemCount() {
        return albumsLists.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvAlbumName;
        private TextView tvAlbumTime;
        private TextView tvAlbumDetail;
        private ImageView ivAlbumImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvAlbumName= (TextView) itemView.findViewById(R.id.tv_album_name);
            tvAlbumTime= (TextView) itemView.findViewById(R.id.tv_album_time);
            tvAlbumDetail= (TextView) itemView.findViewById(R.id.tv_album_detail);
            ivAlbumImage= (ImageView) itemView.findViewById(R.id.iv_album_image);

        }
    }
}
