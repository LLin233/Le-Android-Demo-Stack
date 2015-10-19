package androidpath.ll.coordinatorlayoutaction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener {

    private String[] mItems;
    private Intent[] mActions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView list = new ListView(this);
        setContentView(list);

        buildActionsList();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mItems);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    private void buildActionsList() {
        mItems = new String[]{
                "Simple Behavior",
                "Quicker Hide"
        };

        mActions = new Intent[]{
                new Intent(this, SimpleBehaviorActivity.class),
                new Intent(this, QuickerHideActivity.class),

        };
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent action = mActions[position];
        startActivity(action);
    }
}
