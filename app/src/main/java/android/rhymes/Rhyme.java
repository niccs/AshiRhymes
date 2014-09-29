package android.rhymes;

/**
 * Created by HP on 12/08/2014.
 */
public class Rhyme {
        private  int mRhymeId=0;
        private String mRhymeTitle;
        private String mRhymeName;
        private String mRhymeImageResource;

    public  String getImageName() {
        return mRhymeImageResource;
    }

    public void setImgRes(String rhymeImageResource) {
        mRhymeImageResource = rhymeImageResource;
    }


//    public Rhyme() {
//        // Generate unique identifier
//        rhymeId = ++rhymeId;
//        rhymeDate = new Date();
//    }
    public Rhyme( int id,String rhymeName,String rhymeTitle) {
        mRhymeName=rhymeName;
        mRhymeTitle=rhymeTitle;
        mRhymeId = id;
        mRhymeImageResource = rhymeName;
    }
    public String getTitle() {
        return mRhymeTitle;
    }
    public String getName() {
        return mRhymeName;
    }

    public void setTitle(String title) {
        mRhymeTitle = title;
    }
    public void setName(String name) {
        mRhymeName = name;
    }
    public int getId() {
        return mRhymeId;
    }

    @Override
    public String toString() {
        return mRhymeId+" "+mRhymeTitle+" "+mRhymeImageResource;
    }
}
