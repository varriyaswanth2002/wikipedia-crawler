package tech.crawler.entity;

public class TimeApi {
    private String timeStr;
    private Long epochTime;
    public TimeApi() {
    }

    public TimeApi(String timeStr, Long epochTime) {
        this.epochTime = epochTime;
        this.timeStr = timeStr;
    }
}
