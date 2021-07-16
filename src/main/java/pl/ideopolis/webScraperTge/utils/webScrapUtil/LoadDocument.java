package pl.ideopolis.webScraperTge.utils.webScrapUtil;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LoadDocument {

    private final static Logger log = LoggerFactory.getLogger(LoadDocument.class);

    private String url;
    private Document doc;
    private int timeout = 10 * 1000;
    private String userAgent = "Mozilla";
    private Connection connect;
    private String requestKey = "query";
    private String requestValue = "Java";
    private String cookieName = "auth";
    private String cookieValue = "token";

    public LoadDocument() {
        log.trace("No parameter constructor.");
    }

    public LoadDocument configure() {
        log.trace("configure method.");
        log.info("Configuration of connection parameters: url = {}, data = {}, {}, userAgent = {}, cookie = {}, {}, timeout = {}", url, requestKey, requestValue, userAgent, cookieName, cookieValue, timeout);
        connect = Jsoup
                .connect(url)
                .data(requestKey, requestValue)
                .userAgent(userAgent)
                .cookie(cookieName,cookieValue)
                .timeout(timeout);
        return this;
    }

    public LoadDocument connect() throws IOException {
        log.trace("connect method.");
        connect.post();
        log.info("Connecting to the source and downloading a document.");
        doc = connect.get();
        return this;
    }

    public Document getDoc() {
        return doc;
    }

    /**
     * Required configuration
     **/
    public LoadDocument setUrl(String url) {
        log.trace("setUrl method. url = {}", url);
        this.url = url;
        return this;
    }

    /**
     * Optional configuration
     **/
    public LoadDocument setTimeout(int timeout) {
        log.trace("setTimeout method. timeout = {}", timeout);
        this.timeout = timeout;
        return this;
    }

    /**
     * Optional configuration
     **/
    public LoadDocument setUserAgent(String userAgent) {
        log.trace("setUserAgent method. userAgent = {}", userAgent);
        this.userAgent = userAgent;
        return this;
    }

}
