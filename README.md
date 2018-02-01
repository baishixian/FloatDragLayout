## 悬浮可拖动布局

A floating draggable layout for Android.

![Sample](https://github.com/baishixian/FloatDragLayout/blob/master/VEditor_20180122162419.gif)


### 方式一：FloatDragLayout 

FloatDragLayout 是 Android 中可拖动悬浮按钮布局，可在多种布局模式下的自适应拖动范围，并且支持横竖屏切换和退出后台再恢复时的位置状态保持。

```java
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
                 //todo floatDragLayout click event
            }
        });
```

### 方式二：FloatDragPopupWindow

FloatDragPopupWindow 悬浮可拖动的 PopupWindow，并且拖动完成后可以自动贴靠屏幕边缘，不使用时自动降低其存在感（隐藏一半、降低透明度）

> 1. 为在兼容低版本 Unity Editor 打包应用时出现的点击事件透传和视图被覆盖，因此只能弃用原有将布局通过 addView 到 DecorView 实现的 FloatDragLayout ，考虑换用 PopupWindow 重新实现。
> 2. 使用 WindowManager.addView 也可以实现弹出系统窗口进行全局覆盖，但这种方式需要考虑很多兼容性问题，而且在新版本中也要考虑权限问题，并且要根据当前应用状态手动控制其可见性才行，而 PopupWindow 只是当前应用窗口的子窗口，可跟随其父窗口自动保持一致的可见性控制。因此不推荐使用系统窗口和 addView 的方式实现，最终选择 PopupWindow 实现。

```java

// 创建 contentView
ImageView contentView = new ImageView(this);
contentView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
contentView.setImageResource(R.mipmap.ic_launcher_round);

// 创建 FloatDragPopupWindow，并将 contentView 添加到布局中
FloatDragPopupWindow floatDragPopupWindow = new FloatDragPopupWindow.Builder(this)
                            .setContentView(contentView)
                            .setPosition(0, 300)
                            .setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    //todo contentView click event
                                }
                            })
                            .build();
// 显示 FloatDragPopupWindow 
floatDragPopupWindow.show();
```

## Add dependencies

**Project build.gradle**

```xml
repositories {
    jcenter()
}
```

**Module build.gradle**

```xml
compile 'gdut.bsx:xdraglayout:1.1.1'
```
