package android.rhymes;

import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
* {} interface
 * to handle interaction events.
 * Use the {@link RhymeFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class RhymeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters
    private Rhyme mRhyme;
    private EditText mTitleField;
    int mVideoCount=0;
//    private  VideoView mVidView;
    int mVideoProgress;
    boolean mPlaybackWasStarted;
    String tag="RhymeFragment";

//    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RhymeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RhymeFragment newInstance(int rhymeId) {
        RhymeFragment fragment = new RhymeFragment();
        Bundle args = new Bundle();
        args.putInt("rhyme_id", rhymeId);
        fragment.setArguments(args);
        return fragment;
    }
    public RhymeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            int  rhymeId = (int)getArguments().getInt("rhyme_id");
            mRhyme=RhymeLab.getInstance(getActivity()).getRhyme(rhymeId);
        }
        Log.d(tag,"On Create called");
//        setRetainInstance(true);
    }

    private String getVideoName(int rhymeId){
        Rhyme rhyme=RhymeLab.getInstance(getActivity()).getRhyme(rhymeId);
        mTitleField.setText(rhyme.getTitle());
        return rhyme.getName();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_rhyme, container, false);
        mTitleField = (EditText) v.findViewById(R.id.rhyme_list_item_title_text);
        mTitleField.setText(mRhyme.getTitle());
        if(savedInstanceState!=null)
            mPlaybackWasStarted =savedInstanceState.getBoolean("isSaved");
        Log.d("RhymeFragment",""+ mPlaybackWasStarted);
         final VideoView mVidView= (VideoView)v.findViewById(android.rhymes.R.id.videoView);

//        String videoName=mRhyme.getName();
        mVideoCount=mRhyme.getId();

        playVideo(mVidView, getVideoName(mVideoCount));
        RhymeMediaController vidControl = new RhymeMediaController(getActivity(),false);
        vidControl.setAnchorView(mVidView);
        mVidView.setMediaController(vidControl);

        vidControl.setPrevNextListeners(new View.OnClickListener() {
            public void onClick(View v) {
                if(mVideoCount==4) {
                    return;
                }

                mVideoCount++;
                playVideo(mVidView,getVideoName(mVideoCount));

            }
        }, new View.OnClickListener() {
            public void onClick(View v) {
                if(mVideoCount==0) {
                    return;
                }
                mVideoCount--;
                playVideo(mVidView,getVideoName(mVideoCount));
            }
        });

//        vidView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//
//            public void onCompletion(MediaPlayer mp) {
//
//                mp.stop();
//                Log.d("onCompletionListenr before",""+mVideoCount);
//
//                if(mVideoCount==5) {
//                    return;
//                }
//                mVideoCount++;
//                playVideo(vidView,getVideoName(mVideoCount));
//
//            }
//        });
//        setRetainInstance(true);
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isSaved", true);
    }
//    @Override
//    public void onPause() {
//        super.onPause();
//        Log.d(tag,"onPauseCalled");
//        if(mPlaybackWasStarted) {
//            mVidView.pause();
//            mVideoProgress = mVidView.getCurrentPosition();
//        }
//    }
//    @Override
//    public void onResume() {
//        super.onResume();
//        Log.d(tag,"onResumeCalled");
//        if(mPlaybackWasStarted && mVideoProgress !=0) {
//            mVidView.seekTo(mVideoProgress);
//            mVidView.start();
//        }
//    }
private void playVideo(VideoView mVidView,String VideoName){
    String uri = "android.resource://" + getActivity().getPackageName() + "/raw/" +VideoName;
    mVidView.setVideoURI(Uri.parse(uri));
    mVidView.start();

}
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }


}
