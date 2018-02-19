package cn.weir.simpleOptionView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SimpleOptionView extends RelativeLayout {

    private TextView tvLeft;
    private TextView tvRight;
    private View lineTop;
    private View lineBottom;
    private ImageButton imageLeft;
    private ImageButton imageRight;
    private LinearLayout customItem;

    public SimpleOptionView(Context context) {
        this(context, null);
    }

    public SimpleOptionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleOptionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inti(context);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomLabelView, defStyleAttr, 0);
        for (int i = 0; i < a.getIndexCount(); i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.CustomLabelView_labelNavRes) {
                imageRight.setImageDrawable(a.getDrawable(attr));
                imageRight.setVisibility(VISIBLE);
            } else if (attr == R.styleable.CustomLabelView_labelContent) {
                tvLeft.setText(a.getString(attr));
                tvLeft.setVisibility(VISIBLE);
            } else if (attr == R.styleable.CustomLabelView_labelHint) {
                tvLeft.setHint(a.getString(attr));
                tvLeft.setVisibility(VISIBLE);
            } else if (attr == R.styleable.CustomLabelView_labelImageRes) {
                imageLeft.setVisibility(VISIBLE);
                imageLeft.setImageDrawable(a.getDrawable(attr));
            } else if (attr == R.styleable.CustomLabelView_showBottomLine) {
                lineBottom.setVisibility(VISIBLE);
            } else if (attr == R.styleable.CustomLabelView_rightContentTextColor) {
                tvRight.setTextColor(a.getColor(attr, Color.parseColor("#B3B2B2")));
            } else if (attr == R.styleable.CustomLabelView_rightContentTextSize) {
                tvRight.setTextSize(TypedValue.COMPLEX_UNIT_PX, a.getDimension(attr, 16));
            } else if (attr == R.styleable.CustomLabelView_rightContent) {
                tvRight.setVisibility(VISIBLE);
                tvRight.setText(a.getString(attr));
            } else if (attr == R.styleable.CustomLabelView_showTopLine) {
                lineTop.setVisibility(VISIBLE);
            } else if (attr == R.styleable.CustomLabelView_labelContentTextColor) {
                tvLeft.setTextColor(a.getColor(attr, Color.parseColor("#B3B2B2")));
            } else if (attr == R.styleable.CustomLabelView_rightContentHintColor) {
                tvRight.setHintTextColor(a.getColor(attr, Color.parseColor("#B3B2B2")));
            } else if (attr == R.styleable.CustomLabelView_rightContentHintText) {
                tvRight.setHint(a.getString(attr));
                tvRight.setVisibility(VISIBLE);
            } else if (attr == R.styleable.CustomLabelView_labelContentTextSize) {
                tvLeft.setTextSize(TypedValue.COMPLEX_UNIT_PX, a.getDimension(attr, 16));
            }
        }
        a.recycle();
    }

    private void inti(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_item_view, this);
        findViews(v);
        defaultData();
    }

    private void findViews(View v) {
        imageLeft = (ImageButton) v.findViewById(R.id.imageleft);
        imageRight = (ImageButton) v.findViewById(R.id.imageRight);
        customItem = (LinearLayout) v.findViewById(R.id.custom_item);
        tvLeft = (TextView) v.findViewById(R.id.tvLeft);
        tvRight = (TextView) v.findViewById(R.id.tvRight);
        lineTop = v.findViewById(R.id.custom_line_top);
        lineBottom = v.findViewById(R.id.custom_line_bottom);
    }

    private void defaultData() {


    }


    public void setRightImage(int res) {
        if (res != 0) {
            imageRight.setImageResource(res);
        }
    }

    public void setRightImageVisibility(int visibility) {
        imageRight.setVisibility(visibility);
    }

    public void setLeftImage(int res) {
        imageLeft.setVisibility(VISIBLE);
        if (res != 0) {
            imageLeft.setImageResource(res);
        }
    }

    public void setShowLeftImage() {
        imageLeft.setVisibility(VISIBLE);
    }

    public void setRightHint(String text) {
        if (TextUtils.isEmpty(text)) {

        } else {
            tvRight.setText(text);
            tvRight.setVisibility(VISIBLE);
        }
    }


    public void setRightText(String text) {
        if (TextUtils.isEmpty(text)) {
            tvRight.setText("");
        } else {
            tvRight.setVisibility(View.VISIBLE);
            tvRight.setText(text);
        }
    }

    public void setRightEditMode(boolean isEditMode) {
        tvRight.setVisibility(View.GONE);
    }

    public void setRightTextColor(int res) {
        if (res != 0) {
            tvLeft.setVisibility(View.VISIBLE);
            tvLeft.setTextColor(res);
        }
    }

    public void setRightHintColor(int res) {
        if (res != 0) {
            tvRight.setVisibility(View.GONE);
        }
    }


    public void setRightInputType(int type) {
        if (type != 0) {
            tvRight.setVisibility(View.GONE);
        }
    }

    public void setRightInputWatcher(TextWatcher textWatcher) {

    }

    public String getRightText() {
        return tvRight.getText().toString();
    }

    public void setLeftHint(String text) {
        if (TextUtils.isEmpty(text)) {

        } else {
            tvLeft.setVisibility(View.GONE);
        }
    }

    public void setLeftText(String text) {
        if (TextUtils.isEmpty(text)) {

        } else {
            tvLeft.setVisibility(View.VISIBLE);
            tvLeft.setText(text);
        }
    }

    public void setLeftEditMode(boolean isEditMode) {
        tvLeft.setVisibility(View.GONE);
    }

    public void setLeftTextColor(int res) {
        if (res != 0) {
            tvLeft.setVisibility(View.VISIBLE);
            tvLeft.setTextColor(res);
        }
    }

    public void setLeftHintColor(int res) {
        if (res != 0) {
            tvLeft.setVisibility(View.GONE);
        }
    }

    public void setLeftInputType(int type) {
        if (type != 0) {
            tvRight.setVisibility(View.GONE);
        }
    }

    private TextWatcher textWatcherLeft;

    public void setLeftInputWatcher(TextWatcher textWatcher) {
        textWatcherLeft = textWatcher;
        if (textWatcherLeft != null) {
            tvLeft.setVisibility(View.GONE);
        }
    }

    public CharSequence getLeftText() {
        return tvLeft.getText();
    }

    private OnClickListener itemClick;

    public void setItemClick(OnClickListener listener) {
        itemClick = listener;
        customItem.setEnabled(true);
        customItem.setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS); //父View优先获得焦点
        customItem.setOnClickListener(itemClick);
    }

    public void showLineBottom(boolean isShow) {
        if (isShow) {
            lineBottom.setVisibility(View.VISIBLE);
        } else {
            lineBottom.setVisibility(View.GONE);
        }
    }

    public void hideLineTop() {
        lineTop.setVisibility(View.GONE);
    }

    public void hideLineBottom() {
        lineBottom.setVisibility(View.GONE);
    }
}
