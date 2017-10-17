package com.invest.filter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by AlexAnderIch on 2017/10/9.
 */
public class startFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.crawlInfo();
    }

    /*
    *
    requestRank=urllib2.Request(urlstart,headers=headers)
    rankpage=urllib2.urlopen(requestRank).read()

    rankSoup=BeautifulSoup(rankpage,"lxml")
    userblog=rankSoup.select(".blog_pad a")
    i=0
    for user in userblog:
        i+=1
        if i==10:
            break
        userid=str(user.attrs["href"]).split("/")[-1]
        print(userid)
        requestHtml=urllib2.Request(url+userid,headers=headers)
        html=urllib2.urlopen(requestHtml)
        page=html.read()
        Soup=BeautifulSoup(page,"lxml")
        images=Soup.select(".article_title a")
        for image in images:
            print image.get_text(),"http://blog.csdn.net"+image.attrs["href"]

    * */
    public void crawlInfo() {
// TODO
        String urlStart = "http://blog.csdn.net/ranking.html";
        String url = "http://blog.csdn.net/";
        try {
            Document doc = Jsoup.connect(urlStart).userAgent("Mozilla").get();
            Elements rankingArticle = doc.select(".blog_pad a");
            int time = 0;
            for (Element oneArticle : rankingArticle) {
                time++;
                if (time == 10) break;
                String userId = oneArticle.attr("href").split("/")[1];
                System.out.println(userId);
                Document userPage = Jsoup.connect(url + userId).userAgent("Mozilla").get();
                Elements images = userPage.select(".article_title a");
                for (Element image : images) {
                    System.out.println(image.text() + url + image.attr("href"));

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
