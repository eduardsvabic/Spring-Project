package Demo.Site;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import Demo.Site.Models.Car;
import Demo.Site.Repositories.CarRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CarRepositoryTest {
	@Autowired
	private CarRepository repo;
	/*
	@Test
	public void testNewCar()
	{
		Car car = new Car(
			"Skoda",
			"Fabia",
			"Hatchback",
			1000,
			220000,
			75
			);
			Car savedCar = repo.save(car);
			car = new Car(
					"Ford",
					"Mondeo",
					"Estate",
					9999,
					220000,
					180
					);
					savedCar = repo.save(car);
			Assertions.assertThat(savedCar).isNotNull();
	}
	
	@Test
	public void updateTest()
	{
		repo.updateCarNative("Skoda", "Octavia", "Estate", 140, 1, "vasile", 666, 11L);
	}
	*/
}
