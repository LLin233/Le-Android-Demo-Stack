package androidpath.ll.customview;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CustomView mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TopActionBar bar = (TopActionBar) findViewById(R.id.topbar);

        //bar.setLeftButtonVisable(false);

        bar.setOnTopActionBarClickListener(new TopActionBar.topActionBarClickListener() {
            @Override
            public void onLeftClick() {
                Toast.makeText(MainActivity.this, "Left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightClick() {
                Toast.makeText(MainActivity.this, "Right", Toast.LENGTH_SHORT).show();
            }
        });



        mCustomView = (CustomView) findViewById(R.id.main_cv);
        new Thread(mCustomView).start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
