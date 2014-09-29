package android.rhymes;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by HP on 15/08/2014.
 */
public class RhymeLab {
    private static RhymeLab mRhymeLab;
    private Context mAppContext;
    private ArrayList<Rhyme> mRhymes;

    public static RhymeLab getInstance(Context c) {
        if (mRhymeLab == null) {
            mRhymeLab = new RhymeLab(c.getApplicationContext());
        }
        return mRhymeLab;
    }

    private RhymeLab(Context appContext) {
        mAppContext = appContext;
        mRhymes = new ArrayList<Rhyme>();
            mRhymes.add(new Rhyme(0,"cleanup","Clean Up"));
        mRhymes.add(new Rhyme(1,"headshoulderknee","Head Shoulder Knee And Toe"));
        mRhymes.add(new Rhyme(2,"lettersoundsong","The Letters Sound Song"));
        mRhymes.add(new Rhyme(3,"raingoaway","Rain Rain Go Away"));
        mRhymes.add(new Rhyme(4,"roostergoodmorning","Good Morning  Mr. Rooster"));
//        mRhymes.add(new Rhyme(5,"littlesnowflake","Snowflake Snowflake"));
//        }
    }

    public ArrayList<Rhyme> getRhymes() {
        return mRhymes;
    }

    public Rhyme getRhyme(int id) {

        for (Rhyme rhyme : mRhymes) {
            if (rhyme.getId()==id)
                return rhyme;
        }
        return null;
    }
}
