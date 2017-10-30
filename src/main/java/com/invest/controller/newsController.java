package com.invest.controller;

import com.invest.page.newsPage;
import com.invest.pojo.news;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.invest.service.newsService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

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
    @RequestMapping("/selectNews")
    public ModelAndView updateNewsByPage(@RequestParam("pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("views/News");
        this.crawlInfo();//爬取信息 更新新闻数据库
        int pageSize = 10;
        int startPage = pageNo;//页码'
        int totalnum = NewsService.selectTotalNum();//统计数据库中新闻的数量
        if(totalnum==0) return new ModelAndView("views/login"); //如果没有记录 返回登陆页面
        int page = 1 + totalnum / 10;//一页显示10个新闻,总页数为page
        int restNews = totalnum % 10;//最后一页显示的新闻数
        newsPage<news> newsPage = NewsService.selectNewsByPage(startPage, pageSize);
        mav.addObject(newsPage);
        return mav;
    }
    /*
  * 使用爬虫爬取指定网站上的信息 获取后弄到自己的网页上
  *
  * */
    public void crawlInfo() {
// TODO
        String urlStart = "http://blog.csdn.net/ranking.html";
        String url = "http://blog.csdn.net/";
        String Agent="Mozilla/5.0 (Windows NT 6.1; rv:47.0) Gecko/20100101 Firefox/47.0";
        try {
            Document doc = Jsoup.connect(urlStart).userAgent(Agent)
                    .get();
            Elements rankingArticle = doc.select(".blog_pad a");//选中热门榜前10作者
            int time = 1;//作者排行榜排名
            for (Element oneArticle : rankingArticle) {  //
                time++;
                news newI = new news();//新建news对象 储存爬取的信息
                if (time == 10) break;// 只筛选排名前十的文章
                String userId = oneArticle.attr("href").split("/")[1];//获取作者ID 用于访问主页

                newI.setWriter(userId);//文章作者

                System.out.println(userId);
                String writerUrl=url+userId;//作者主页
                Document userPage = Jsoup.connect(writerUrl).userAgent(Agent).get();//访问文章作者主页
                Elements titles = userPage.select(".article_item");//获取
                for (Element title : titles) {
                    String fullUrl = url + title.select(".link_title a").attr("href");//文章链接
                    newI.setResource(fullUrl);
                    newI.setTitle(title.select(".link_title a").text());//文章标题
                    newI.setSummary(title.select(".article_description").text());//文章摘要
                    newI.setTime(title.select(".link_postdate").text());//文章时间
                    NewsService.insertNews(newI);//保存查询到的文章
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


