package tech.crawler.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import tech.crawler.global.HttpURLConnectionExample;

import java.util.Date;

public class WikipediaDownloader {


    private String keyword;

    public WikipediaDownloader(){

    }
    public WikipediaDownloader(String keyword) {
        this.keyword = keyword;
    }


    public WikiResult getResult() {
        //1. Get Clean keyword!
        //2. Get the url for Wikipedia
        //3. Make a GET request to wikiPedia!
        //4. parsing the useful result using jsoup
        //5. showing results to the user!
        if(this.keyword == null || this.keyword.isEmpty()){
            return null;
        }
        //STEP 1
        this.keyword = this.keyword.trim().replaceAll("[ ]+","_");//[ ]+ is the regular expression for spaces continuously
        //STEP 2
        String wikiUrl = getWikipediaUrlForQuery(this.keyword);
        String response = "";
        String imageUrl = null;
        try {
            //STEP 3
            String wikipediaResponseHTML = HttpURLConnectionExample.sendGet(wikiUrl);//ctrl+p to see expected parameters


            //STEP 4
            Document document = Jsoup.parse(wikipediaResponseHTML,"https://wikipedia.org");
            Elements childElements = document.body().select(".mw-parser-output > *");
            int state = 0;
            for(Element childElement:childElements){
                if(state == 0) {
                    if (childElement.tagName().equals("table")) {
                        state = 1;
                    }
                }
                else if(state == 1){
                    if(childElement.tagName().equals("p")){
                        state = 2;
                        response = childElement.text();
                        break;
                    }
                }
                try {
                    imageUrl = document.body().select(".infobox img").get(0).attr("src");
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        WikiResult wikiResult = new WikiResult(this.keyword,response,imageUrl);
        //PUSH RESULT INTO DATABASE
        //System.out.println(new Gson().toJson(wikiResult));
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return wikiResult;

    }

    private String getWikipediaUrlForQuery(String cleanKeyword) {
        return "https://en.wikipedia.org/wiki/"+cleanKeyword;
    }

}
