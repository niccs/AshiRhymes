package android.rhymes;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p />
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p />
 * Activities containing this fragment MUST implement the {@linkCallbacks}
 * interface.
 */
public class RhymeListFragment extends Fragment implements AbsListView.OnItemClickListener {
    private ArrayList<Rhyme> rhymes;
    private RhymeLab mRhymeLab;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters

    private OnFragmentInteractionListener mListener;

    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private ListAdapter mAdapter;

    // TODO: Rename and change types of parameters
    public static RhymeListFragment newInstance(String param1, String param2) {
        RhymeListFragment fragment = new RhymeListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RhymeListFragment() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRhymeLab=RhymeLab.getInstance(getActivity());
        rhymes=mRhymeLab.getRhymes();
        mAdapter = new RhymeAdapter(rhymes);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_irhyme, container, false);

        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.
//            mListener.onFragmentInteraction(DummyContent.ITEMS.get(position).id);
            mListener.onItemSelected(rhymes.get(position).getId());
        }
    }

    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyText instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    /**
    * This interface must be implemented by activities that contain this
    * fragment to allow an interaction in this fragment to be communicated
    * to the activity and potentially other fragments contained in that
    * activity.
    * <p>
    * See the Android Training lesson <a href=
    * "http://developer.android.com/training/basics/fragments/communicating.html"
    * >Communicating with Other Fragments</a> for more information.
    */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onItemSelected(int id);
    }

    private class RhymeAdapter extends ArrayAdapter<Rhyme> {
        public RhymeAdapter(ArrayList<Rhyme> rhymes) {
            super(getActivity(), 0, rhymes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(
                        R.layout.list_item_rhyme, null);
            }
            Rhyme rhyme = getItem(position);
            TextView titleTextView = (TextView) convertView
                    .findViewById(R.id.rhyme_list_item_title_text);

            titleTextView.setText(rhyme.getTitle());
            ImageView image=(ImageView)convertView.findViewById(R.id.list_image);

            Resources res = getResources();
//            Drawable drawable = res.getDrawable(R.drawable.twinkletwinkle);
//            thumb_image.setImageDrawable(drawable);
            int imageResource = res.getIdentifier(rhyme.getImageName(), "drawable", getContext().getPackageName() );
//            int resourceId = R.drawable.class.getField(rhyme.getImageName()).getInt(null);
//            int imageResource = getActivity().getResources().getIdentifier("android.rhymes:drawable/" + rhyme.getImageName(), null, null);
//            Log.d("RhymeListFragment", getContext().getPackageName() +"  "+imageResource +" "+rhyme.getImageName());
            image.setImageResource(imageResource);

            return convertView;
        }

    }
}


