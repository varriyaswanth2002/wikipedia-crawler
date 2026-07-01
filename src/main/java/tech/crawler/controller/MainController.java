package tech.crawler.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import tech.crawler.entity.TimeApi;
import tech.crawler.entity.WikiResult;
import tech.crawler.entity.WikipediaDownloader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


@Controller
@RequestMapping("/")
public class MainController extends BaseController {

    private static Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/helloworld")
    public String getQuiz(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        return "hello";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/time")
    public @ResponseBody String getTime(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        TimeApi timeApi = new TimeApi(new Date().toString(),new Date().getTime());
        return new Gson().toJson(timeApi);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/api/wiki")
    public @ResponseBody String getWikiResultGson(@RequestParam("keyword") String key,ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        WikipediaDownloader wikipediaDownloader = new WikipediaDownloader(key);
        //now wikipediaDownloader is an object to the class
        //.getResult() will give use wikiResult
        WikiResult wikiResult = wikipediaDownloader.getResult();
        return new Gson().toJson(wikiResult);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/api/wiki/html")
    public String getWikiResultHtml(@RequestParam("keyword") String key, ModelMap modelMap, HttpServletResponse response, HttpServletRequest request, Model model) {
        WikipediaDownloader wikipediaDownloader = new WikipediaDownloader(key);
        //now wikipediaDownloader is an object to the class
        //.getResult() will give use wikiResult
        WikiResult wikiResult = wikipediaDownloader.getResult();
        modelMap.addAttribute("IMAGE",wikiResult.getImage_url());
        modelMap.addAttribute("DESCRIPTION",wikiResult.getText_result());

        return "wikiapi";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/handle")
    public
    @ResponseBody
    String handleEncrypt(@RequestBody String data, HttpServletRequest request, HttpServletResponse response) {
        return "ok";
    }
}