package android.rhymes;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

public class RhymeListActivity extends SingleFragmentActivity implements RhymeListFragment.OnFragmentInteractionListener {
    @Override
    public void onItemSelected(int position) {
        Log.d("RhymeActivity", RhymeLab.getInstance(this).getRhyme(position) + " was clicked");


        FragmentManager fragmentManager = getFragmentManager();
        // Or: FragmentManager fragmentManager = getSupportFragmentManager()
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment detailFragment=new RhymeFragment();
        Bundle args = new Bundle();
        args.putSerializable("rhyme_id", position);
        detailFragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragmentContainer, detailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

        @Override
        protected Fragment createFragment() {
            return new RhymeListFragment();
        }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

//        FragmentManager fm = getFragmentManager();
//// Check to see if the Fragment back stack has been populated
//// If not, create and populate the layout.
//        Log.d("nixie", "comming here1");
//        RhymeListFragment rhymeListFragment =
//                (RhymeListFragment) fm.findFragmentById(R.id.fragmentContainer);
//        if (rhymeListFragment == null) {
//            Log.d("nixie", "comming here2");
//            FragmentTransaction ft = fm.beginTransaction();
//            ft.add(R.id.fragmentContainer, new RhymeListFragment());
////            ft.add(R.id.ui_container, new MyListFragment());
//            ft.commit();
//        }
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.rhyme_list, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
