package oslomet.webprog.ukeoppgaver.repository;

import org.springframework.stereotype.Repository;
import oslomet.webprog.ukeoppgaver.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {

    private final List<Vehicle> list = new ArrayList<>();

    public void addVehicle(Vehicle vehicle){
        list.add(vehicle);
    }

    public List<Vehicle> getVehicles(){
        return list;
    }

    public void deleteVehicles(){
        list.clear();
    }

}
