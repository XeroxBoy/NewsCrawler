package com.invest.service;

import com.invest.dao.newsDao;
import com.invest.page.newsPage;
import com.invest.pojo.news;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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

    /*
    * 分页查询新闻
    * */
    public newsPage<news> selectNewsByPage(int pageNo, int pageSize) {
        newsPage<news> page = new newsPage<>();
        page.setList(newsdao.selectNewsByPage(pageNo, pageSize));
        // List<news> newses = newsdao.selectNewsByPage(pageNo, pageSize);
        //System.out.println(newses);

        page.setCurrPage(pageNo + 1);//传过来的初始值是0
        page.setPageSize(pageSize);//每页的数量
        page.setTotalCount(this.selectTotalNum());//总记录数
        page.setTotalPage(this.selectTotalNum() / pageSize + 1);//总页数
        return page;
    }
    //搜索新闻
    public newsPage<news> searchNews(String key, HttpSession session){
        newsPage<news> page = new newsPage<>();
        int startPage=0;//一开始设置startPage=0,即是第一次点击搜索框的状态
        if(session.getAttribute("inSearch").equals(true)) {
            startPage = (int) session.getAttribute("currPage");//如果在搜索状态中 那么从currPage中提取值
        }

        session.setAttribute("inSearch",true);//设置状态 确认在搜索页面中
        List<news> newses = newsdao.searchNews(key, startPage);
        page.setList(newses);
        page.setCurrPage(1);
        int size= newses.size();
        if(size==0) return null;//如果没有查询结果 返回null
        page.setPageSize(size);
        page.setTotalCount(size);
        page.setTotalPage(1);
        return page;
    }
}
