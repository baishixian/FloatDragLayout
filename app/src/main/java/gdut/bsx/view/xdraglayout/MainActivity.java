package gdut.bsx.view.xdraglayout;

import android.content.Intent;
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
 * @author baishixian
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup rootView = (ViewGroup)getWindow().getDecorView();
        rootView = rootView.findViewById(android.R.id.content);

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
                Toast.makeText(MainActivity.this, "点击了悬浮可拖动按钮", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.bt_change_to_fullscreen).setOnClickListener(this);
        findViewById(R.id.bt_change_to_no_title).setOnClickListener(this);
        findViewById(R.id.bt_change_to_windows).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_change_to_fullscreen :
                startActivity(new Intent(MainActivity.this, FullscreenActivity.class));
                break;
            case R.id.bt_change_to_no_title :
                startActivity(new Intent(MainActivity.this, NoTitleActivity.class));
                break;
            case R.id.bt_change_to_windows :
                startActivity(new Intent(MainActivity.this, WindowActivity.class));
                break;
                default:break;
        }
    }
}
