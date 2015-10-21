package androidpath.ll.coordinatorlayoutaction.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidpath.ll.coordinatorlayoutaction.behaviors.FooterBarBehavior;

/**
 * Created by Le on 2015/10/20.
 */
@CoordinatorLayout.DefaultBehavior(FooterBarBehavior.class)
public class FooterBarLayout extends FrameLayout {
    public FooterBarLayout(Context context) {
        super(context);
    }

    public FooterBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FooterBarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
