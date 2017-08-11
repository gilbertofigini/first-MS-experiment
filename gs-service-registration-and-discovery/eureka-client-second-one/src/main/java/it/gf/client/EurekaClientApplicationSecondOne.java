/**
 * 
 */
package it.gf.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author gilberto
 * 
 * Secondo client Eureka richiama controller con classe esterna
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplicationSecondOne {

	/**
	 * @param args
	 * start applicazione spring boot
	 */
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplicationSecondOne.class, args);
		// possibile eseguire il servizio boot anche con il seguente comando
		// new SpringApplicationBuilder(EurekaClientApplicationSecondOne.class).web(true).run(args);
	}

}

/**
 *  @author gilberto
 *  Controller per la connessione con eureka server
 *
 */
@RestController
class ServiceInstanceRestControllerSecondOne {

	// Oggetto Spring Cloud che mette a disposizione metodi per navigare i servizi esposti
	@Autowired
	private DiscoveryClient discoveryClient;
	
	/**
	 * 
	 * @param applicationName
	 * @return istanza del servizio identificato dal parametro applicationName, il nome viene configurato nel 
	 * file bootstrap.properties spring.application.name
	 */
	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }	
}

