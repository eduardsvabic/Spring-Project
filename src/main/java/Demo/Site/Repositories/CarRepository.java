package Demo.Site.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import Demo.Site.Models.Car;
import jakarta.transaction.Transactional;

public interface CarRepository extends JpaRepository<Car, Long>{
	@Modifying
	@Transactional
	@Query(value = "UPDATE car SET make = ? , model = ?, body_type = ?, hp = ?, km = ?, path = ?, price = ? where id = ? ", nativeQuery = true)
	public int updateCarNative(
		String make, String model, String body_type, Integer hp, Integer km, String path, Integer price, Long id);
	
	@Query(value = "SELECT * FROM car WHERE make = ?, model = ?, body_type = ?, hp = ?, km = ?, path = ?, price = ?", nativeQuery = true)
	public List<Car> searchByCriteria();
	
	//, model = ?, body_type = ?, hp = ?, km = ?, path = ?, price = ? || , String model, String body_type, Integer hp, Integer km, String path, Integer price,
	
	
	@Query(value = "SELECT * FROM car WHERE make = ?", nativeQuery = true)
	public List<Car> findByMake(String make);
	
}
