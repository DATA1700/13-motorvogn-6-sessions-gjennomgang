package oslomet.webprog.ukeoppgaver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import oslomet.webprog.ukeoppgaver.model.Vehicle;
import oslomet.webprog.ukeoppgaver.repository.VehicleRepository;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleRepository repo;

    @PostMapping("/api")
    public void add(Vehicle vehicle){
        repo.addVehicle(vehicle);
    }

    @GetMapping("/api")
    public List<Vehicle> getAll(){
        return repo.getVehicles();
    }

    @DeleteMapping("/api")
    public void deleteAll(){
        repo.deleteVehicles();
    }
}
