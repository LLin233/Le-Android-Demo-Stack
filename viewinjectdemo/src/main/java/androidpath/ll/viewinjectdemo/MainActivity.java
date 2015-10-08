package androidpath.ll.viewinjectdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidpath.ll.viewinjectdemo.lib.ContentView;
import androidpath.ll.viewinjectdemo.lib.ViewInject;
import androidpath.ll.viewinjectdemo.lib.ViewInjectUtils;


@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @ViewInject(R.id.id_btn)
    private Button mBtn1;
    @ViewInject(R.id.id_btn02)
    private Button mBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewInjectUtils.inject(this);

        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_btn:
                Toast.makeText(MainActivity.this, "Why do you click me ?",
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.id_btn02:
                Toast.makeText(MainActivity.this, "I am sleeping !!!",
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }

}