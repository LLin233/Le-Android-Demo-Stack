package androidpath.ll.hackdemo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Le on 2015/11/10.
 */
public class BaseActivity extends AppCompatActivity {

    public static void actionStart(Context context, @Nullable String data1, @Nullable String data2, Class<?> classname) {
        Intent intent = new Intent(context, classname);
        if (data1 != null) {
            intent.putExtra("param1", data1);
        }
        if (data2 != null) {
            intent.putExtra("param2", data2);
        }
        context.startActivity(intent);
    }

    public static void actionStart(Context context, Class<?> classname) {
        actionStart(context, null, null, classname);
    }
}
