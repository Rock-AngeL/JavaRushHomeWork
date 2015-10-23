package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HHStrategy implements Strategy
{
    private static final String USER_AGENT = "Mozilla/5.0 (jsoup)";
    private static final int TIMEOUT = 5 * 1000;
    private static final String REFERER = "http://hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2";

    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";//"http://javarush.ru/testdata/big28data.html?text=java+%s&page=%s";//

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> list = new ArrayList<Vacancy>();
        Document doc;
        int i = 0;

            while (true)
            {
                try
                {
                    doc = getDocument(searchString, i++);
                }
                catch (IOException e)
                {
                    break;
                }

                Elements all = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (all.size() == 0)
                    break;

                for (Element e : all)
                {
                    Vacancy vac = new Vacancy();
                    vac.setUrl(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));
                    vac.setTitle(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                    vac.setSalary(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());
                    vac.setCity(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                    vac.setCompanyName(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                    vac.setSiteName(doc.title());
                    list.add(vac);
                }
            /*
            Elements all = doc.select("div.search-result-item");
            if (all.size() > 0) {
                for (Element e : all) {
                    Vacancy vac = new Vacancy();
                    vac.setUrl(e.select("a.search-result-item__name").attr("href"));
                    vac.setTitle(e.select("a.search-result-item__name").text());
                    vac.setSalary(e.select("div.b-vacancy-list-salary").text());
                    vac.setCity(e.select("span.searchresult__address").text());
                    vac.setCompanyName(e.select("a.link-secondary").text());
                    vac.setSiteName(doc.title());
                    list.add(vac);
                }
            } else {
                break;
            }*/
            }

        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {
        String url = String.format(URL_FORMAT, searchString, page);
        return Jsoup.connect(url).userAgent(USER_AGENT).timeout(TIMEOUT).referrer(REFERER).get();
    }
}
