package com.invest.dao;

import com.invest.pojo.news;
import org.springframework.stereotype.Component;

/**
 * Created by AlexAnderIch on 2017/10/17.
 */
@Component
public interface newsDao {
    public void insertNews(news news);
    public void deleteNews(String title);
    public void updateNews(news news);
    public news selectNews(int id);
    public int selectTotalNum();//查询新闻总数
}
