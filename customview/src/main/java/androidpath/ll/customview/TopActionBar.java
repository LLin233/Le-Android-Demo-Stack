package androidpath.ll.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Le on 2015/9/8.
 */
public class TopActionBar extends RelativeLayout {
    private final int BUTTON_LEFT = 0;
    private final int BUTTON_RIGHT = 1;

    private Context mContext;

    private Button leftBtn, rightBtn;
    private TextView tvTitle;
    private int leftTextColor, rightTextColor;
    private Drawable leftBackground, rightBackground, mainBarBackground;
    private String leftText, rightText;
    private float titleTextSize;
    private int titleTextColor;
    private String titleText;

    private LayoutParams leftParams, rirhtParams, titleParams;
    private topActionBarClickListener mTopActionBarClickListener;

    public interface topActionBarClickListener {
        public void onLeftClick();

        public void onRightClick();
    }

    public void setOnTopActionBarClickListener(topActionBarClickListener listener) {
        mTopActionBarClickListener = listener;
    }

    public TopActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.TopActionBar);
        mainBarBackground = mTypedArray.getDrawable(R.styleable.TopActionBar_mainBarBackground);
        //left
        leftText = mTypedArray.getString(R.styleable.TopActionBar_leftText);
        leftTextColor = mTypedArray.getColor(R.styleable.TopActionBar_leftTextColor, Color.BLACK);
        leftBackground = mTypedArray.getDrawable(R.styleable.TopActionBar_leftBackground);
        //right
        rightText = mTypedArray.getString(R.styleable.TopActionBar_rightText);
        rightTextColor = mTypedArray.getColor(R.styleable.TopActionBar_rightTextColor, Color.BLACK);
        rightBackground = mTypedArray.getDrawable(R.styleable.TopActionBar_rightBackground);
        //title
        titleText = mTypedArray.getString(R.styleable.TopActionBar_titleText);
        titleTextSize = mTypedArray.getDimension(R.styleable.TopActionBar_titleTextSize, 12);
        titleTextColor = mTypedArray.getColor(R.styleable.TopActionBar_titleTextColor, Color.BLACK);

        mTypedArray.recycle();

        //init
        leftBtn = new Button(context);
        rightBtn = new Button(context);
        tvTitle = new TextView(context);

        leftBtn.setTextColor(leftTextColor);
        leftBtn.setBackground(leftBackground);
        leftBtn.setText(leftText);

        rightBtn.setTextColor(rightTextColor);
        rightBtn.setBackground(rightBackground);
        rightBtn.setText(rightText);

        tvTitle.setTextColor(titleTextColor);
        tvTitle.setTextSize(titleTextSize);
        tvTitle.setText(titleText);
        tvTitle.setGravity(Gravity.CENTER);

        setBackground(mainBarBackground);

        // 设置布局 - 左
        leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        leftParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
        leftParams.setMargins(15, 15, 15, 15);
        addView(leftBtn, leftParams);


        // 设置布局 - 右
        rirhtParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rirhtParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        rirhtParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
        rirhtParams.setMargins(15, 15, 15, 15);
        addView(rightBtn, rirhtParams);


        // 设置布局 - 标题
        titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(tvTitle, titleParams);

        leftBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTopActionBarClickListener.onLeftClick();
            }
        });
        rightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTopActionBarClickListener.onRightClick();
            }
        });
    }

    public void setLeftButtonVisable(boolean flag) {
        this.setButtonVisable(BUTTON_LEFT, flag);
    }

    public void setRightButtonVisable(boolean flag) {
        this.setButtonVisable(BUTTON_RIGHT, flag);
    }


    private void setButtonVisable(int ButtonPosition, boolean flag) {
        if (ButtonPosition == BUTTON_LEFT) {
            if (flag) {
                leftBtn.setVisibility(View.VISIBLE);
            } else {
                leftBtn.setVisibility(View.GONE);
            }
        } else if (ButtonPosition == BUTTON_RIGHT) {
            if (flag) {
                rightBtn.setVisibility(View.VISIBLE);
            } else {
                rightBtn.setVisibility(View.GONE);
            }
        }
    }
}
