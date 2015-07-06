package androidpath.ll.eventbusdemo;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidpath.ll.eventbusdemo.Models.Item;
import de.greenrobot.event.EventBus;

import static androidpath.ll.eventbusdemo.Models.Event.ItemListEvent;

/**
 * Created by Le on 2015/5/26.
 */
public class ItemListFragment extends ListFragment {

    protected DrawerLayout mDrawerLayout;
    protected View mDrawer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Register
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        mDrawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        mDrawer = (View) getActivity().findViewById(R.id.drawer);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Unregister
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //called after onCreateView()
        super.onViewCreated(view, savedInstanceState);

        // open a thread to load list

        /**
         *  Posts the given event to the event bus and wait for onEvent method to consume it. {@link #onEventMainThread(ItemListEvent)}
         */
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000 * 5); // pretend to load a updated list from server
                    ItemListEvent requestedListEvent = new ItemListEvent(Item.ITEMS); //build an event contains list we have got from the server.
                    EventBus.getDefault().post(requestedListEvent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void onEventMainThread(ItemListEvent event) {
        setListAdapter(new ArrayAdapter<Item>(getActivity(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1, event.getItems()));
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position,
                                long id) {
        super.onListItemClick(listView, view, position, id);
        Toast.makeText(getActivity(),
                getListView().getItemAtPosition(position).toString(),
                Toast.LENGTH_SHORT).show();
        mDrawerLayout.closeDrawer(mDrawer);
        EventBus.getDefault().post(getListView().getItemAtPosition(position));

    }

}