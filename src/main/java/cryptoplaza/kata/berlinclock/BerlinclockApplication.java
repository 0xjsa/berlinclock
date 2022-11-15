package cryptoplaza.kata.berlinclock;

import cryptoplaza.kata.berlinclock.services.BerlinClockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BerlinclockApplication implements CommandLineRunner {

	@Autowired
	BerlinClockService berlinClockService;

	public static void main(String[] args) {
		SpringApplication.run(BerlinclockApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Integer hours 	= 24;
		Integer minutes	= 0;
		Integer seconds = 0;

		log.info(berlinClockService.getTimeBerlinClock(seconds,hours,minutes));
	}
}
