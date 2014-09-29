package android.rhymes;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;

/**
 * Created by HP on 26/08/2014.
 */
public class RhymeMediaController  extends MediaController {

    ImageButton mShuffleButon;
    Context mContext;
    AlertDialog mLangDialog;


    public RhymeMediaController(Context context, boolean useFastForward) {
        super(context, useFastForward);
        mContext = context;
    }


    @Override
    public void setAnchorView(View view) {
        super.setAnchorView(view);

        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        frameParams.gravity = Gravity.RIGHT|Gravity.TOP;

        View v = makeRhymeView();
        addView(v, frameParams);

    }

    private View makeRhymeView() {
        mShuffleButon = new ImageButton(mContext);
//        mShuffleButon.setImageResource(R.drawable.humptydumpty);

        mShuffleButon.setOnClickListener(new OnClickListener() {


            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//                builder.setSingleChoiceItems(0, 0, new DialogInterface.OnClickListener() {
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //Save Preference and Dismiss the Dialog here
//                        Toast.makeText(mContext, "Which ::: " + which, Toast.LENGTH_LONG).show();
//                    }
//                });
//                mLangDialog = builder.create();
//                mLangDialog.show();
            }
        });

        return mShuffleButon;
    }
}
