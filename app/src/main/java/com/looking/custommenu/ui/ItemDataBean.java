package com.looking.custommenu.ui;

/**
 * User: YangHai (1454025171@qq.com)
 * Date: 2016-12-06
 * Time: 09:27
 */
public class ItemDataBean {
    public int iconId;
    public String title;
    public String value;
    public String unit;
    public String flag;
    public int isVisible;
    public int markVisible;
    public int textColor;

    public boolean isDivider = false;
    public float textsize;

    public ItemDataBean(int iconId, String title, String unit, String flag) {
        this.title = title;
        this.iconId = iconId;
        this.unit = unit;
        this.flag = flag;
    }

    public ItemDataBean(String title, String value, String unit, String flag) {
        this.value = value;
        this.title = title;
        this.unit = unit;
        this.flag = flag;
    }

    public ItemDataBean(int iconId) {
        this.iconId = iconId;
    }

    public ItemDataBean(String title, String value, String flag) {
        this.title = title;
        this.value = value;
        this.flag = flag;
    }

    public ItemDataBean(String title,  int textColor,String value, String flag) {
        this.flag = flag;
        this.textColor = textColor;
        this.title = title;
        this.value = value;
    }

    public ItemDataBean(String title, String value, float textsize, String flag) {
        this.flag = flag;
        this.textsize = textsize;
        this.title = title;
        this.value = value;
    }

    public ItemDataBean(String title, String value, int textColor, float textsize, String flag) {
        this.flag = flag;
        this.textColor = textColor;
        this.title = title;
        this.value = value;
        this.textsize = textsize;
    }

    public ItemDataBean(int isVisible, String title, String value, String unit, String flag) {
        this.isVisible = isVisible;
        this.flag = flag;
        this.unit = unit;
        this.value = value;
        this.title = title;
    }

    public ItemDataBean(int iconId, int isVisible, String title, String value, String unit, String flag) {
        this.iconId = iconId;
        this.title = title;
        this.value = value;
        this.unit = unit;
        this.flag = flag;
        this.isVisible = isVisible;
    }

    public ItemDataBean(int isVisible, int markVisible, String title, String value, String flag) {
        this.markVisible = markVisible;
        this.title = title;
        this.value = value;
        this.unit = unit;
        this.flag = flag;
        this.isVisible = isVisible;
    }

    public ItemDataBean(boolean isDivider) {
        this.isDivider = isDivider;
    }
}
