package hello;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication	
public class EurekaServiceApplication {
    
    public static void main(String[] args) {
    	new SpringApplicationBuilder(EurekaServiceApplication.class).web(true).run(args);
//        SpringApplication.run(EurekaServiceApplication.class, args);
    }
}
	