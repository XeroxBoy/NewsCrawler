package com.invest.controller;

import com.invest.page.newsPage;
import com.invest.pojo.news;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.invest.service.newsService;

import java.util.ArrayList;

/**
 * Created by AlexAnderIch on 2017/10/20.
 */
@RequestMapping("/news")
public class newsController {
    @Autowired
    private newsService NewsService;

    /*
    * 分页查询数据库中爬虫爬取的新闻
    * */
    @RequestMapping("/selectNews.do")
    public String updateNewsByPage() {
        int totalnum = NewsService.selectTotalNum();//统计数据库中新闻的数量
        int page = 1 + totalnum / 10;//一页显示10个新闻,总页数为page
        int restNews = totalnum % 10;//最后一页显示的新闻数
        newsPage newspage;//创建分页查询结果的容器
        ArrayList<newsPage> newspages = new ArrayList<>();//存储每一页的内容
        for (; totalnum > 0; totalnum--) {
            newspage = new newsPage();//每次循环重新初始化，装不同页的内容
            int times;//循环次数
            if (totalnum >= 10) {
                times = 10;//循环10次
            } else
                times = totalnum;//循环totalnum次
            for (; times != 0; times--) {
                news news = NewsService.selectNews(totalnum);
                newspage.add(news);
            }
            newspages.add(newspage);//保存这一页的内容
        }
        return "views/index";
    }
}


