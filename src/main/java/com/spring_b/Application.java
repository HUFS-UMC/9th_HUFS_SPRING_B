package umc.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
//import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableScheduling
@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(umc.demo.Application.class);
		app.setWebApplicationType(WebApplicationType.NONE); // 웹 서버 끄기
		app.run(args);
	}

	@Override
	public void run(String... args) throws InterruptedException{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("Batch started at: " + LocalDateTime.now().format(formatter));
//		// 배치 로직
//		for (int i = 1; i <= 5; i++) {
//			System.out.println(i);
//			Thread.sleep(1000);
//		}
		System.out.println("Batch finished at: " + LocalDateTime.now().format(formatter));
	}
}
