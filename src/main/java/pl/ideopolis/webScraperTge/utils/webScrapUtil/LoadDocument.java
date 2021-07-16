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

    // TODO: 14.06.2021 optimize to not download same page multiple times
    public LoadDocument() {
        log.trace("No parameter constructor.");
    }

    private void configure() {
        log.trace("configure method.");
        connect = Jsoup
                .connect(url)
                .data("query", "Java")
                .userAgent(userAgent)
                .cookie("auth", "token")
                .timeout(timeout);
    }

    public void connect() throws IOException {
        log.trace("connect method.");
        configure();
        connect.post();
        doc = connect.get();
    }

    public Document getDoc() {
        return doc;
    }

    /**
     * Required configuration
     **/
    public LoadDocument setUrl(String url) {
        log.trace("setUrl method. url = " + url);
        this.url = url;
        return this;
    }

    /**
     * Optional configuration
     **/
    public LoadDocument setTimeout(int timeout) {
        log.trace("setTimeout method. timeout = " + timeout);
        this.timeout = timeout;
        return this;
    }

    /**
     * Optional configuration
     **/
    public LoadDocument setUserAgent(String userAgent) {
        log.trace("setUserAgent method. userAgent = " + userAgent);
        this.userAgent = userAgent;
        return this;
    }

}
