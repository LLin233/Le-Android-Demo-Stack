package androidpath.ll.customview;

import android.content.res.Resources;

/**
 * Created by Le on 2015/11/12.
 */
public class Utils {
    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
