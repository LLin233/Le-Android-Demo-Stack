package androidpath.ll.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BlinkCycleActivity extends AppCompatActivity {
    private CustomView mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blink_cycle);

        TopActionBar bar = (TopActionBar) findViewById(R.id.topbar);

        //bar.setLeftButtonVisable(false);

        bar.setOnTopActionBarClickListener(new TopActionBar.topActionBarClickListener() {
            @Override
            public void onLeftClick() {
                Toast.makeText(BlinkCycleActivity.this, "Left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightClick() {
                Toast.makeText(BlinkCycleActivity.this, "Right", Toast.LENGTH_SHORT).show();
            }
        });

        mCustomView = (CustomView) findViewById(R.id.main_cv);
        new Thread(mCustomView).start();
    }
}
