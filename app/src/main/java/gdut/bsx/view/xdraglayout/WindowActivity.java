package gdut.bsx.view.xdraglayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import gdut.bsx.view.FloatDragLayout;
import gdut.bsx.view.utils.DisplayUtil;

public class WindowActivity extends Activity {

    private FrameLayout containerWindows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window);
        containerWindows = findViewById(R.id.fl_windows);
        FloatDragLayout floatDragLayout = new FloatDragLayout(this);
        floatDragLayout.setBackgroundResource(R.mipmap.ic_launcher_round);
        int size = DisplayUtil.dp2px(this, 45);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(size, size);
        floatDragLayout.setLayoutParams(layoutParams);

        layoutParams.gravity = Gravity.CENTER_VERTICAL;
        containerWindows.addView(floatDragLayout, layoutParams);

        floatDragLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WindowActivity.this, "点击了悬浮可拖动按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
