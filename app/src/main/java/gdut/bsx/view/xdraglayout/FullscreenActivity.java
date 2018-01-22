package gdut.bsx.view.xdraglayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import gdut.bsx.view.FloatDragLayout;
import gdut.bsx.view.utils.DisplayUtil;

/**
 * FullscreenActivity
 * @author baishixian
 */
public class FullscreenActivity extends AppCompatActivity {

    private View mDecorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        mDecorView = getWindow().getDecorView();
        ViewGroup rootView = mDecorView.findViewById(android.R.id.content);

        FloatDragLayout floatDragLayout = new FloatDragLayout(this);
        floatDragLayout.setBackgroundResource(R.mipmap.ic_launcher_round);
        int size = DisplayUtil.dp2px(this, 45);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(size, size);
        floatDragLayout.setLayoutParams(layoutParams);

        layoutParams.gravity = Gravity.CENTER_VERTICAL;
        rootView.addView(floatDragLayout, layoutParams);

        floatDragLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FullscreenActivity.this, "点击了悬浮可拖动按钮", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            mDecorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
