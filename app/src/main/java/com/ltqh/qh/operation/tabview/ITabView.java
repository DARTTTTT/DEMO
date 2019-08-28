package com.ltqh.qh.operation.tabview;

/**
 * Description
 * Author zhaolizhi
 * Date  2019/1/8.
 */
public interface ITabView {
    void setStateDrawable(int selected, int unSelected);

    void setStateImageUrl(String selectedUrl, String unSelectedUrl);

    void showDot(boolean show);
}
