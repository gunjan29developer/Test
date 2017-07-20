package test.com.testapplication;

/**
 * Created by gunjan.kumar on 20/7/17.
 */
public class AlbumsList {

    private String albumName;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumDetails() {
        return albumDetails;
    }

    public void setAlbumDetails(String albumDetails) {
        this.albumDetails = albumDetails;
    }

    private String time;
    private String albumDetails;

    public int getAlbumPic() {
        return albumPic;
    }

    public void setAlbumPic(int albumPic) {
        this.albumPic = albumPic;
    }

    private int albumPic;
}
