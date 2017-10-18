package com.invest.service;

import com.invest.dao.newsDao;
import com.invest.pojo.news;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by AlexAnderIch on 2017/10/17.
 */
@Service("newsService")
public class newsService {
    @Resource
    private newsDao newsdao;//用注解自动注入

    public void insertNews(news news) {
        newsdao.insertNews(news);
    }

    public void deleteNews(String title) {
        newsdao.deleteNews(title);
    }

    public void updateNews(news news) {
        newsdao.updateNews(news);
    }

    public news selectNews(int id) {
        news newsItems = newsdao.selectNews(id);
        if (newsItems != null)//查询结果不为空 返回查询出来的新闻
            return newsItems;
        return null;//否则返回空
    }

    public int selectTotalNum() {
        return newsdao.selectTotalNum();
    }
}