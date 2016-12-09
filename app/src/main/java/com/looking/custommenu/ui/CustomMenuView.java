package com.looking.custommenu.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xin on 2016/12/9.
 */

public class CustomMenuView extends LinearLayout {


    public List<ItemDataBean> list = new ArrayList<>();
    private OnMineMenuListener listener;
    private boolean clickEnable = true;

    public CustomMenuView(Context context) {
        super(context);
        initView();
    }

    public CustomMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CustomMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        this.setOrientation(LinearLayout.VERTICAL);
    }

    public void setData(List<ItemDataBean> datas) {
        for (ItemDataBean data : datas) {
            this.addView(createItem(data));
        }
    }

    private View createItem(ItemDataBean data) {
        if (data.isDivider) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setMinimumHeight(20);
            linearLayout.setBackgroundResource(android.R.color.transparent);
            linearLayout.setTag(data);
            return linearLayout;
        } else {
            MenuMixView menuMixView = createItemMenu(data);
            bindMenuListener(menuMixView);
            return menuMixView;
        }
    }

    private void bindMenuListener(final MenuMixView menuMixView) {
        menuMixView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickEnable) {
                    if (listener != null) {
                        listener.onClickItem((ItemDataBean) menuMixView.getTag());
                    }
                }
            }
        });
    }

    private MenuMixView createItemMenu(ItemDataBean data) {
        MenuMixView menuMixView = new MenuMixView(getContext());
        menuMixView.setData(data);
        menuMixView.setTag(data);
        return menuMixView;
    }

    public CustomMenuView updateValue(int iconId, String value) {
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            if (!((ItemDataBean) childView.getTag()).isDivider) {
                MenuMixView menuMixView = (MenuMixView) childView;
                if (menuMixView.getIcon() == iconId) {
                    menuMixView.setValue(value);
                }
            }
        }
        return this;
    }

    /**
     * 更新菜单左边部分标题
     *
     * @param flag
     * @param title
     * @return
     */
    public CustomMenuView updateTitle(String flag, String title) {
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            if (!((ItemDataBean) childView.getTag()).isDivider) {
                MenuMixView menuMixView = (MenuMixView) childView;
                if (menuMixView.getData().flag.equals(flag)) {
                    menuMixView.setTitle(title);
                }
            }
        }
        return this;
    }

    /**
     * 设置图标动态的显示或者隐藏
     *
     * @param flag
     * @param visible
     * @return
     */
    public CustomMenuView updateItemPointVisible(String flag, int visible) {
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            if (!((ItemDataBean) childView.getTag()).isDivider) {
                MenuMixView menuMixView = (MenuMixView) childView;
                if (menuMixView.getData().flag.equals(flag)) {
                    menuMixView.setImgVisible(visible);
                }
            }

        }
        return this;
    }

    public void setOnMineMenuListener(OnMineMenuListener listener) {
        this.listener = listener;
    }

    public void setClickEnable(boolean clickEnable) {
        this.clickEnable = clickEnable;
    }

    /**
     * 添加菜单栏
     *
     * @param iconId
     * @param title
     * @param value
     * @param unit
     * @param flag
     * @return
     */
    public CustomMenuView addItem(int iconId, int isvisible, String title, String value, String unit, String flag) {
        list.add(new ItemDataBean(iconId, isvisible, title, value, unit, flag));

        return this;
    }

    public CustomMenuView addItem(int isvisible, String title, String value, String unit, String flag) {
        list.add(new ItemDataBean(isvisible, title, value, unit, flag));
        return this;
    }

    public CustomMenuView addItem(String title, String value, String unit, String flag) {
        list.add(new ItemDataBean(title, value, unit, flag));
        return this;
    }

    public CustomMenuView addItem(String title, int color, String value, String flag) {
        list.add(new ItemDataBean(title, color, value, flag));
        return this;
    }

    public CustomMenuView addItem(String title, String value, float textsize, String flag) {
        list.add(new ItemDataBean(title, value, textsize, flag));
        return this;
    }

    public CustomMenuView addDivider(boolean isDivider) {
        list.add(new ItemDataBean(isDivider));
        return this;
    }

    public void build() {
        setData(list);
    }

    public interface OnMineMenuListener {
        void onClickItem(ItemDataBean data);

    }
}
