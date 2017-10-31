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

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

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
    public ModelAndView updateNewsByPage(@RequestParam("pageNo") int pageNo, HttpSession session) {
        ModelAndView mav = new ModelAndView("views/News");
        // Date today=new Date();
        //int thisMonth=today.getMonth();
        Calendar today = Calendar.getInstance();
        int thisMonth = today.getTime().getMonth() + 1;//因为这个类的月份从0开始- -
        int pageSize = 10;//每页的大小
        int startPage = pageNo;//页码'
        newsPage<news> newsPage = NewsService.selectNewsByPage(startPage, pageSize);
        // int lastIndex= newsPage.getTotalCount();
        Integer date = Integer.valueOf(newsPage.getList().get(9).getTime().split("-")[1]);//类型转换
        System.out.println(date + " " + thisMonth);
        if (!date.equals(thisMonth)) {//查询的是这个月还没有爬取过的信息
            System.out.println("进入爬虫");
            this.crawlInfo();//爬取信息 更新新闻数据库
        }
        int totalnum = NewsService.selectTotalNum();//统计数据库中新闻的数量
        if (totalnum == 0) return new ModelAndView("views/login"); //如果没有记录 返回登陆页面
        // int page = 1 + totalnum / 10;//一页显示10个新闻,总页数为page
        //int restNews = totalnum % 10;//最后一页显示的新闻数
//        newsPage<news> newsPage = NewsService.selectNewsByPage(startPage, pageSize);
        mav.addObject(newsPage);
        session.setAttribute("currPage", pageNo);//在session中保存当前的页数
        return mav;
    }

    /*
  * 使用爬虫爬取指定网站上的信息 获取后弄到自己的网页上
  *
  * */
    public void crawlInfo() {
// TODO
        System.out.println("进入爬取流程");
        String urlStart = "http://blog.csdn.net/ranking.html";
        String url = "http://blog.csdn.net/";
        String Agent = "Mozilla/5.0 (Windows NT 10.0; WOW64)";//headers内容
        try {
            Document doc = Jsoup.connect(urlStart).userAgent(Agent)
                    .get();
            Elements rankingArticle = doc.select(".blog_pad a");//选中热门榜前10作者
            int time = 1;//作者排行榜排名
            for (Element aRankingArticle : rankingArticle) {  //使用迭代器遍历
                System.out.println("进入循环");
                Element oneArticle = aRankingArticle;
                time++;
                news newI = new news();//新建news对象 储存爬取的信息
                if (time == 10) break;// 只筛选排名前十的文章
                String userId = oneArticle.attr("href").split("/")[3];//获取作者ID 用于访问主页
                newI.setWriter(userId);//文章作者
                String writerUrl = url + userId;//作者主页
                Document userPage = Jsoup.connect(writerUrl).userAgent(Agent).get();//访问文章作者主页
                Elements titles = userPage.select(".article_item");//获取
                for (Element title : titles) {
                    System.out.println("进入作者文章循环");
                    String fullUrl = url + title.select(".link_title a").attr("href");//文章链接
                    newI.setResource(fullUrl);
                    newI.setTitle(title.select(".link_title a").text());//文章标题
                    //  System.out.println(title.select(".link_title a").text());
                    //System.out.println(title.select(".article_description").text());
                    newI.setSummary(title.select(".article_description").text());//文章摘要
                    newI.setTime(title.select(".link_postdate").text());//文章时间
                    NewsService.insertNews(newI);//保存查询到的文章
                    System.out.println("保存新闻成功" + newI);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


