package androidpath.ll.hackdemo;


import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_lazy_loading)
    public void goToLazyLoadingDemo(View view) {
        actionStart(MainActivity.this, TestActivity.class);
    }
}
