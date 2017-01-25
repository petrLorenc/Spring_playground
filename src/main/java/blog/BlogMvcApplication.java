package blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by United121 on 1/23/2017.
 */
@SpringBootApplication
public class BlogMvcApplication {
    public static void main(String[] args) {
        //Calling SpringApplication.run(…) will start an embedded Tomcat Web application server at http://localhost:8080
        SpringApplication.run(BlogMvcApplication.class,args);
    }
}
