package androidpath.ll.coordinatorlayoutaction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class FooterbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footerbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        SimpleAdapter adapter = new SimpleAdapter(list);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));
    }

}
