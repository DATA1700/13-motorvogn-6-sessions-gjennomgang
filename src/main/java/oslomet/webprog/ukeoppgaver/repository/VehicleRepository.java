package oslomet.webprog.ukeoppgaver.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import oslomet.webprog.ukeoppgaver.model.Car;
import oslomet.webprog.ukeoppgaver.model.Registration;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {

    @Autowired
    private JdbcTemplate db;

//    private final List<Registration> registrations = new ArrayList<>();
//    private final List<Car> cars = new ArrayList<>();

//    public VehicleRepository() {
//        Car car1 = new Car("Volvo","V30");
//        cars.add(car1);
//        Car car2 = new Car("Volvo","V70");
//        cars.add(car2);
//        Car car3 = new Car("Volvo","V91");
//        cars.add(car3);
//        Car car4 = new Car("Audi","A8");
//        cars.add(car4);
//        Car car5 = new Car("Audi","Q7");
//        cars.add(car5);
//        Car car6 = new Car("Audi","Q8");
//        cars.add(car6);
//        Car car7 = new Car("Toyota","Trueno");
//        cars.add(car7);
//        Car car8 = new Car("Toyota","Levin");
//        cars.add(car8);
//    }

    public void addRegistrations(Registration registration){
//        registrations.add(registration);
        try {
            db.update("insert into Registrations(ssn, name, address, characteristics, brand, type)" +
                    "values(?, ?, ?, ?, ?, ?)",
                    registration.getSsn(), registration.getName(), registration.getAddress(),
                    registration.getCharacteristics(), registration.getBrand(), registration.getType()
            );
        } catch (Exception e) {
            System.out.println("Noe gikk glat i repo sin addRegistrations");
        }
    }

    public List<Registration> getRegistrations(){
//        return registrations;
        try {
            return db.query("select * from Registrations", new BeanPropertyRowMapper<>(Registration.class));
        } catch (Exception e) {
            System.out.println("Noe gikk glat i repo sin getRegistration");
            return null;
        }
    }

    public List<Car> getCars() {
//        return cars;
        try {
            return db.query("select * from Cars", new BeanPropertyRowMapper<>(Car.class));
        } catch (Exception e) {
            System.out.println("Noe gikk glat i repo sin getCars");
            return null;
        }
    }

    public void deleteVehicles(){
//        registrations.clear();
        try {
            db.update("delete from Registrations");
        } catch (Exception e) {
            System.out.println("Noe gikk glat i repo sin getCars");
        }
    }

}
