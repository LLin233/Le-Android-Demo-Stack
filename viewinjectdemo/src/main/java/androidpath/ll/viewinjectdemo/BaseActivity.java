package androidpath.ll.viewinjectdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import androidpath.ll.viewinjectdemo.lib.ViewInjectUtils;

/**
 * Created by Le on 2015/10/9.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInjectUtils.inject(this);
    }

}
