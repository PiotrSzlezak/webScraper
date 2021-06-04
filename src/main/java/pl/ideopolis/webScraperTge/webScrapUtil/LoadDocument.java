package pl.ideopolis.webScraperTge.webScrapUtil;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class LoadDocument {

    private String url;
    private Document doc;
    private int timeout = 10*1000;
    private String userAgent = "Mozilla";
    private Connection connect;

    public LoadDocument(String url) {
        this.url = url;
        configure();
    }

    private void configure(){
        connect = Jsoup.connect(url)
                .data("query", "Java")
                .userAgent(userAgent)
                .cookie("auth", "token")
                .timeout(timeout);
    }

    public void connect() throws IOException {
        connect.post();
        doc = connect.get();
    }

    public Document getDoc() {
        if (doc == null) {
            try {
                connect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return doc;
    }

    /**
     Optional configuration
     **/
    public LoadDocument timeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public LoadDocument userAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public LoadDocument url(String url){
        this.url = url;
        return this;
    }

}
