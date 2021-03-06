package com.pdc.metronome.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.github.florent37.viewanimator.ViewAnimator;
import com.pdc.metronome.R;


public class Indicator extends RelativeLayout {

    private ImageView indicator;

    public Indicator(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.indicator, this);

        indicator = findViewById(R.id.indicator);
    }

    public void colorChanged(boolean isSelected) {
        if (isSelected) {
            ViewAnimator.animate(indicator).scale(0.5f,1f).duration(100).start();
            indicator.setColorFilter(Color.parseColor("#1cf91e"));
        } else {
            indicator.setColorFilter(Color.WHITE);
        }
    }

    public void setSize(){
        indicator.getLayoutParams().height = dpToPx(8);
        indicator.getLayoutParams().width = dpToPx(8);
    }

    private static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
