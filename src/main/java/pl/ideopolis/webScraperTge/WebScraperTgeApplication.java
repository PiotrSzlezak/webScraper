package pl.ideopolis.webScraperTge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories
//@EnableJpaRepositories(basePackages={"pl.ideopolis.webScraperTge.tge"})
//@EntityScan(basePackages={"pl.ideopolis.webScraperTge.tge"})
//@ComponentScan(basePackages={"pl.ideopolis.webScraperTge.tge"})
public class WebScraperTgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebScraperTgeApplication.class, args);
    }
}