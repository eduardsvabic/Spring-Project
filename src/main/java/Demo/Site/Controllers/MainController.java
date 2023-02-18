package Demo.Site.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import Demo.Site.Models.Car;
import Demo.Site.Services.CarService;

@Controller
public class MainController {
	
	@Autowired
	private CarService service;
	
	@GetMapping("/")
	public String welcome(){
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
		Page<Car> page = service.listAll();
		List<Car> listCars = page.getContent();
		
		model.addAttribute("listCars", listCars);
		return "manage";
	}
	
	@GetMapping("/add-car")
	public String addCarPage() {
		return "add";
	}
	
	@PostMapping("/insert")
	public String insertCar(@ModelAttribute Car car) {
		service.save(car);
		return "redirect:/admin";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCar(@PathVariable(name = "id") Long id)
	{
		service.delete(id);
		return "redirect:/admin";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editCar(@PathVariable(name = "id") Long id)
	{
		ModelAndView mav = new ModelAndView("edit");
		Car car = service.findCarById(id);
		mav.addObject("car", car);
		return mav;
	}
	
	@PostMapping("/update")
	public String updateCar(@ModelAttribute("car") Car car) {
		service.updateCar(car);	
		return "redirect:/admin";
	}
	
	@GetMapping("/search/{make}")
	public ModelAndView listCars(@PathVariable(name = "make") String make) {
		ModelAndView mav = new ModelAndView("list");
		List<Car> listCarsByMake = service.listAllMake(make);
		mav.addObject("listCarsByMake",listCarsByMake);
		return mav;
	}
	
	@GetMapping("/aboutus")
	public String aboutus() {
		return "aboutus";
	}
	
	@GetMapping("/services")
	public String services() {
		return "services";
	}
	
}
