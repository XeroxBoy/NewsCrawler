package com.invest.controller;

import com.invest.page.newsPage;
import com.invest.pojo.news;
import com.invest.service.newsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        session.setAttribute("inSearch", false);//设置状态 确认不在搜索页面中
        newsPage<news> newsPage;
        Calendar today = Calendar.getInstance();
        Integer thisMonth = today.getTime().getMonth() + 1;//因为这个类的月份从0开始- -
        int pageSize = 10;//每页的大小
        int startPage = pageNo;//页码'
        newsPage=NewsService.selectNewsByPage(0,pageSize);
        boolean haveCrawl=false;
        if(newsPage.getList().isEmpty()){
            this.crawlInfo();//进入爬虫
            newsPage=NewsService.selectNewsByPage(0,pageSize);
            haveCrawl=true;
        }
        int totalCount = newsPage.getTotalCount();//获取总记录数
        int listIndex = totalCount % 10;//避免访问的List下标越界
        int totalnum = NewsService.selectTotalNum();//统计数据库中新闻的数量
        int totalPage = totalnum / 10-1 ;//总页数
        if (listIndex != 0) {
            listIndex = listIndex - 1;
            totalPage++;//如果最后一位不是0 那么多出一页应该装不满10条的记录
        }
        Integer date = Integer.valueOf(newsPage.getList().get(listIndex).getTime().split("-")[1]);//类型转换,取出一条新闻的日期,判断是不是这个月
        System.out.println(date + " ");
        if(!haveCrawl) {
            if (!date.equals(thisMonth) && !date.equals(thisMonth - 1) && !thisMonth.equals((date + 1) % 12)) {//查询的是这两个月还没有爬取过的信息

                System.out.println("进入爬虫");
                this.crawlInfo();//爬取信息 更新新闻数据库
            }
        }
        totalnum = NewsService.selectTotalNum();//更新统计中数据库中新闻的数量
        int lastNewsNum = totalnum % 10;//最后一页应该显示的新闻数
        totalPage=totalnum/10;//重新计算页数
        if (totalnum%10 != 0) {
            totalPage++;//如果最后一位不是0 那么多出一页应该装不满10条的记录
        }
        newsPage = NewsService.selectNewsByPage(startPage, pageSize);//再从最早的新闻开始查询
        if (totalnum == 0) return new ModelAndView("views/login"); //如果没有记录 返回登陆页面
        session.setAttribute("totalPage", totalPage);
        session.setAttribute("lastNewsNum", lastNewsNum);//将这俩个信息保存在session中
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
        String urlStart = "https://blog.csdn.net/ranking.html";
        String url = "https://blog.csdn.net/";
        String Agent = "Mozilla/5.0 (Windows NT 10.0; WOW64)";//headers内容
        try {
            Document doc = Jsoup.connect(urlStart).userAgent(Agent)
                    .get();
          // System.out.println(doc.body());
            String str="博客周排行";
            String str1="文章周排行";
            Elements rankingArticle = doc.select(".ranking:contains("+str+") .ranking_c .blog_pad");//选中热门榜前10作者
            Elements rankingArt= doc.select(".ranking:contains("+str1+") .ranking_c li");//选中热门榜前10文章

            int time = 1;//作者排行榜排名
            int artTime=1;//文章排行榜排名
            for(Element aRankingArt:rankingArt){
                Element oneArt=aRankingArt;
                System.out.println("文章"+aRankingArt.data());

                artTime++;
                news newA=new news();
                if(artTime==10) break;
                Elements titles=oneArt.select("a");
                newA.setWriter("翔哥");
                for(Element title:titles){
                    String oneTitle=title.text();
                    String href=title.attr("href");
                    System.out.println("标题"+oneTitle+"链接"+href);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    newA.setTime(sdf.format(new Date()));
                    newA.setSummary(oneTitle);
                    newA.setTitle(oneTitle);
                    newA.setResource(href);
                    NewsService.insertNews(newA);

                }
            }
            for (Element aRankingArticle : rankingArticle) {  //使用迭代器遍历
              //  System.out.println(aRankingArticle.html());
                System.out.println("进入循环");
                System.out.println("article信息"+aRankingArticle.data());
                Element oneArticle = aRankingArticle;
                time++;
                news newI = new news();//新建news对象 储存爬取的信息
                if (time == 10) break;// 只筛选排名前十的文章
                String userId = oneArticle.select("a").attr("href").split("/")[3];//获取作者ID 用于访问主页
                newI.setWriter(userId);//文章作者
                String writerUrl = url + userId;//作者主页
                System.out.println("writerUrl:"+writerUrl);
                Document userPage = Jsoup.connect(writerUrl).userAgent(Agent).get();//访问文章作者主页
                Elements titles = userPage.select(".article-item-box");//获取
                for (Element title : titles) {
                    System.out.println("进入作者文章循环");
                    String fullUrl =
                            //url +
                            title.select("a").attr("href");//文章链接
                    newI.setResource(fullUrl);
                    System.out.println("url:"+fullUrl+"   title："+title.select("a").text()+" content:"+title.select(".text-truncate a").text()+" time: "+title.select(".date").text());
                    newI.setTitle(title.select(".text-truncate a").text());//文章标题

                    newI.setSummary(title.select(".content a").text());//文章摘要
                    newI.setTime(title.select(".date").text());//文章时间
                    NewsService.insertNews(newI);//保存查询到的文章
                    System.out.println("保存新闻成功" + newI);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
    * 搜索新闻
    *
    * */
    @RequestMapping("search")
    public ModelAndView searchNews(HttpSession session, @RequestParam("key") String key) { //显示在一页内
        ModelAndView errormav=new ModelAndView("views/News");
        ModelAndView mav = new ModelAndView("views/News");
        newsPage<news> newsPage = NewsService.searchNews(key, session);//搜索信息
        if(newsPage==null || newsPage.getList().get(0)==null) return errormav;//没有查询出结果来

        session.setAttribute("lastNewsNum", newsPage.getList().size());//将这俩个信息保存在session中
        session.setAttribute("currPage",0);//将这俩个信息保存在session中
        session.setAttribute("totalPage",1);//将这俩个信息保存在session中

        mav.addObject(newsPage);
        return mav;
    }
}


