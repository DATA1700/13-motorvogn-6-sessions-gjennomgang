package oslomet.webprog.ukeoppgaver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import oslomet.webprog.ukeoppgaver.model.Car;
import oslomet.webprog.ukeoppgaver.model.Registration;
import oslomet.webprog.ukeoppgaver.repository.VehicleRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleRepository repo;

    @PostMapping("/api/add")
    public void add(Registration registration){
        repo.addRegistrations(registration);
    }

    @PostMapping("api/changeOneRegistration")
    public void changeOneRegistration(Registration registration) {
        repo.changeOneRegistration(registration);
    }

    @GetMapping("/api/registrations")
    public List<Registration> getAllRegistrations(HttpServletResponse response) throws IOException {
        if (repo.getRegistrations() == null) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB Controller, getAllRegistrations()");
        }
        return repo.getRegistrations();
    }

    @GetMapping("/api/cars")
    public List<Car> getAllCars(){
        return repo.getCars();
    }

    @GetMapping("/api/getOneRegistration")
    public Registration getOneRegistration(String id, HttpServletResponse response) throws IOException {
        if (repo.getOneRegistration(id) == null) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB Controller, getOneRegistration()");
        }
        return repo.getOneRegistration(id);
    }

    @GetMapping("/api/deleteSingleRegistration")
    public void deleteSingleRegistration(String id) {
        repo.deleteSingleRegistration(id);
    }

    @DeleteMapping("/api")
    public void deleteAll(){
        repo.deleteVehicles();
    }
}
