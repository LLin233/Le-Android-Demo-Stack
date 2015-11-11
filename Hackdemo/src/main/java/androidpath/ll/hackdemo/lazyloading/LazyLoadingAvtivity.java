package androidpath.ll.hackdemo.lazyloading;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import androidpath.ll.hackdemo.BaseActivity;
import androidpath.ll.hackdemo.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class LazyLoadingAvtivity extends BaseActivity {


    @Bind(R.id.viewstub1)
    ViewStub viewStub1;
    @Bind(R.id.viewstub2)
    ViewStub viewStub2;

    private boolean isJustStart = true;
    private boolean isViewInflated = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazy_loading_avtivity);
        ButterKnife.bind(this);
    }

    public void onShowHidden(View v) {
        if (isJustStart) {
            viewStub1.inflate();
            viewStub2.inflate();
            isJustStart = false;
        } else {
            if (isViewInflated) {
                viewStub1.setVisibility(View.GONE);
                viewStub2.setVisibility(View.GONE);
                isViewInflated = false;
            } else {
                viewStub1.setVisibility(View.VISIBLE);
                viewStub2.setVisibility(View.VISIBLE);
                isViewInflated = true;

            }

        }
    }

}
