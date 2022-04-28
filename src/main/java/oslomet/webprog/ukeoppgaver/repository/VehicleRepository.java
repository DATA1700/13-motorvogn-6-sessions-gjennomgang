package oslomet.webprog.ukeoppgaver.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import oslomet.webprog.ukeoppgaver.model.Bruker;
import oslomet.webprog.ukeoppgaver.model.Car;
import oslomet.webprog.ukeoppgaver.model.Registration;

import java.util.List;

@Repository
public class VehicleRepository {

    @Autowired
    private JdbcTemplate db;

    Logger logger = LoggerFactory.getLogger(VehicleRepository.class);

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

    public void changeOneRegistration(Registration registration) {
        try {
            db.update("update Registrations set ssn=?, name=?, address=?, characteristics=?, brand=?, type=? where id=?",
                    registration.getSsn(), registration.getName(), registration.getAddress(),
                    registration.getCharacteristics(), registration.getBrand(), registration.getType(), registration.getId());
        } catch (Exception e) {
            return;
        }

    }

    public List<Registration> getRegistrations(){
        try {
            return db.query("select * from Registrations", new BeanPropertyRowMapper<>(Registration.class));
        } catch (Exception e) {
            logger.error(e + "\n Noe gikk glat i repo sin getRegistration");
            return null;
        }
    }

    public Registration getOneRegistration(String id) {
        try {
            return db.query("select * from Registrations where id=?", new BeanPropertyRowMapper<>(Registration.class), id).get(0);
        } catch (Exception e) {
            logger.error(e + "\n Noe gikk glat i repo sin getOneRegistration");
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

    public void deleteSingleRegistration(String id) {
        try {
            db.update("delete from Registrations where id = ?", id);
        } catch (Exception e) {
            System.out.println("Noe gikk glat i repo sin deleteSingleRegistration");
        }
    }

    public void deleteVehicles(){
        try {
            db.update("delete from Registrations");
        } catch (Exception e) {
            System.out.println("Noe gikk glat i repo sin deleteVehicles");
        }
    }

    public Bruker login(Bruker bruker) throws Exception {
        try {
            String sql = "select brukernavn, passord, admin from User where brukernavn = ? and passord = ?";
            Bruker user = db.queryForObject(sql, new BeanPropertyRowMapper<>(Bruker.class), bruker.getBrukernavn(), bruker.getPassord());
            return user;
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Noe gikk galt i repo sin login");
            throw new Exception(e.getMessage());
        }
    }

    public boolean register (Bruker bruker) {
        try {
            db.update("insert into User(brukernavn, passord, admin) values(?, ?, ?)",
                    bruker.getBrukernavn(), bruker.getPassord(), bruker.getAdmin());
            return true;
        } catch (Exception e) {
            System.out.println("Noe gikk galt i repo sin register");
            return false;
        }
    }

}
