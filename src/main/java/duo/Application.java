//The main Spring application runner
//static void main(String[] args) shows that this is the main and is what will be first run when this built application is run

package duo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}