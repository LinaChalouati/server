package com.actia.monitoring;

import com.actia.monitoring.server.model.Server;
import com.actia.monitoring.server.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.actia.monitoring.server.model.Status.SERVER_UP;

@SpringBootApplication
public class 	MonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoringApplication.class, args);}
		@Bean
		CommandLineRunner run(ServerRepo serverRepo){
			return args -> {
			serverRepo.save(new Server(1L,"192.168.1.1","Susa","16 GB","PC",SERVER_UP));
			};

	}

}
