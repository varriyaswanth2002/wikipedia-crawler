package tech.crawler.entity;

public class WikiResult {


    private String query;
    private String text_result;
    private String image_url;
    public WikiResult(){

    }
    public WikiResult(String query,String text_result,String image_url){
        this.image_url = image_url;
        this.text_result = text_result;
        this.query = query;
    }
    public String getQuery() {
        return query;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getText_result() {
        return text_result;
    }
}
