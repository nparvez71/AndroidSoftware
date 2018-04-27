package com.parvez.serviceexample;

/**
 * Created by J2EE-33 on 4/16/2018.
 */

public class ListItem {
    String head;
    String describe;
    String imgUrl;

    public ListItem(String user, String pageURL, String userImageURL) {
        this.head = head;
        this.describe = describe;
        this.imgUrl = imgUrl;
    }

    public String getHead() {
        return head;
    }

    public String getDescribe() {
        return describe;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
