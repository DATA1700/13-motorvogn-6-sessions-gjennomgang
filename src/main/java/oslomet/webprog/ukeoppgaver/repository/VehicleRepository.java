package oslomet.webprog.ukeoppgaver.repository;

import org.springframework.stereotype.Repository;
import oslomet.webprog.ukeoppgaver.model.Car;
import oslomet.webprog.ukeoppgaver.model.Registration;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {

    private final List<Registration> registrations = new ArrayList<>();
    private final List<Car> cars = new ArrayList<>();

    public VehicleRepository() {
        Car car1 = new Car("Volvo","V30");
        cars.add(car1);
        Car car2 = new Car("Volvo","V70");
        cars.add(car2);
        Car car3 = new Car("Volvo","V91");
        cars.add(car3);
        Car car4 = new Car("Audi","A8");
        cars.add(car4);
        Car car5 = new Car("Audi","Q7");
        cars.add(car5);
        Car car6 = new Car("Audi","Q8");
        cars.add(car6);
        Car car7 = new Car("Toyota","Trueno");
        cars.add(car7);
        Car car8 = new Car("Toyota","Levin");
        cars.add(car8);
    }

    public void addRegistrations(Registration registration){
        registrations.add(registration);
    }

    public List<Registration> getRegistrations(){
        return registrations;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void deleteVehicles(){
        registrations.clear();
    }

}
