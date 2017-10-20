package com.invest.page;

import com.invest.pojo.news;

import java.util.ArrayList;

/**
 * Created by AlexAnderIch on 2017/10/20.
 */
public class newsPage {
    private ArrayList newsList=new ArrayList();
    public void add(news news) {
        newsList.add(news);
    }
}
