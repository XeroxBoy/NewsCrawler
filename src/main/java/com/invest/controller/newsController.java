package com.invest.controller;

import com.invest.page.newsPage;
import com.invest.pojo.news;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.invest.service.newsService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by AlexAnderIch on 2017/10/20.
 */
@Controller
@RequestMapping("/news")
public class newsController {
    @Autowired
    private newsService NewsService;

    /*
    * 分页查询数据库中爬虫爬取的新闻
    * */
    @RequestMapping("/selectNews.do")
    public ModelAndView updateNewsByPage(HttpServletRequest request) {
        ModelAndView mav=new ModelAndView("views/index");
        int pageSize=10;
        int startPage=Integer.valueOf(request.getParameter("pageNo"));//页码
        int totalnum = NewsService.selectTotalNum();//统计数据库中新闻的数量
        int page = 1 + totalnum / 10;//一页显示10个新闻,总页数为page
        int restNews = totalnum % 10;//最后一页显示的新闻数
        newsPage<news> newsPage= NewsService.selectNewsByPage(startPage, pageSize);
        mav.addObject(newsPage);
        return mav;
    }
}


