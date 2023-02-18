package Demo.Site.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Demo.Site.Models.Car;
import Demo.Site.Repositories.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository repo;
	
	public Page<Car> listAll(){
		Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "id"));
		return repo.findAll(pageable);
	}
	
	public void save(Car car)
	{
		repo.save(car);
	}
	
	public void delete(Long id)
	{
		repo.deleteById(id);
	}
	
	public Car findCarById(Long id)
	{
		return repo.getReferenceById(id);
	}
	
	public void updateCar(Car car) {
		
		repo.updateCarNative(
			car.getMake(),
			car.getModel(),
			car.getBodyType(),
			car.getHp(),
			car.getKm(),
			car.getPath(),
			car.getPrice(),
			car.getId());
	}
	
	public List<Car> listAllMake(String make) {
		return repo.findByMake(make);
	}
	
}
