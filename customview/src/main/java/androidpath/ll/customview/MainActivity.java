package androidpath.ll.customview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.view1)
    void startDemoView1() {
        actionStart(MainActivity.this, BlinkCycleActivity.class);
    }

    @OnClick(R.id.view2)
    void startDemoView2() {
        actionStart(MainActivity.this, ProcessingActivity.class);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void actionStart(Context context, Class<?> classname) {
        Intent intent = new Intent(context, classname);
        context.startActivity(intent);
    }

}

