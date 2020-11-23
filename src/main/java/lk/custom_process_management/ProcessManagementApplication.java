package lk.custom_process_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProcessManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessManagementApplication.class, args);
	}

}
