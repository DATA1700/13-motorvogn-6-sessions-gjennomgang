package oslomet.webprog.ukeoppgaver.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import oslomet.webprog.ukeoppgaver.model.Car;
import oslomet.webprog.ukeoppgaver.model.Registration;

import java.util.List;

@Repository
public class VehicleRepository {

    @Autowired
    private JdbcTemplate db;

    public void addRegistrations(Registration registration){
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
        try {
            return db.query("select * from Registrations", new BeanPropertyRowMapper<>(Registration.class));
        } catch (Exception e) {
            System.out.println("Noe gikk glat i repo sin getRegistration");
            return null;
        }
    }

    public List<Car> getCars() {
        try {
            return db.query("select * from Cars", new BeanPropertyRowMapper<>(Car.class));
        } catch (Exception e) {
            System.out.println("Noe gikk glat i repo sin getCars");
            return null;
        }
    }

    public void deleteVehicles(){
        try {
            db.update("delete from Registrations");
        } catch (Exception e) {
            System.out.println("Noe gikk glat i repo sin getCars");
        }
    }

}
