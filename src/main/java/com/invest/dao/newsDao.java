package com.invest.dao;

import com.invest.page.newsPage;
import com.invest.pojo.news;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by AlexAnderIch on 2017/10/17.
 */
@Component
public interface newsDao {
    public void insertNews(news news);
    public void deleteNews(String title);
    public void updateNews(news news);
    public news selectNews(int id);
    public List<news> selectNewsByPage(@Param("startPage") int startPage, @Param("pageSize") int pageSize);
    public int selectTotalNum();//查询新闻总数
}
