package com.invest.filter;

import com.invest.pojo.news;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.annotation.Resource;
import javax.servlet.*;
import java.io.IOException;

import com.invest.service.newsService;

/**
 * Created by AlexAnderIch on 2017/10/9.
 */
public class startFilter implements Filter {
    @Resource
    private newsService newsService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.crawlInfo();
    }


    /*
    * 使用爬虫爬取指定网站上的信息 获取后弄到自己的网页上
    *
    * */
    public void crawlInfo() {
// TODO
        String urlStart = "http://blog.csdn.net/ranking.html";
        String url = "http://blog.csdn.net/";
        try {
            Document doc = Jsoup.connect(urlStart).userAgent("Mozilla").get();
            Elements rankingArticle = doc.select(".blog_pad a");//选中热门榜前10作者
            int time = 1;//作者排行榜排名
            for (Element oneArticle : rankingArticle) {  //
                time++;
                news newI = new news();
                if (time == 10) break;// 只筛选排名前十的文章
                String userId = oneArticle.attr("href").split("/")[1];//获取作者ID 用于访问主页

                newI.setWriter(userId);//文章作者

                System.out.println(userId);
                Document userPage = Jsoup.connect(url + userId).userAgent("Mozilla").get();//访问文章作者主页
                Elements titles = userPage.select(".list_item article_item");//获取
                for (Element title : titles) {
                    String fullUrl = url + title.select(".link_title a").attr("href");//文章链接
                    newI.setResource(fullUrl);
                    newI.setTitle(title.select(".link_title a").text());//文章标题
                    newI.setSummary(title.select(".article_description").text());//文章摘要
                    newI.setTime(title.select(".link_postdate").text());//文章时间
                    newsService.insertNews(newI);//保存查询到的文章
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
