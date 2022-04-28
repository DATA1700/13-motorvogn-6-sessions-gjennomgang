package oslomet.webprog.ukeoppgaver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import oslomet.webprog.ukeoppgaver.model.Bruker;
import oslomet.webprog.ukeoppgaver.model.Car;
import oslomet.webprog.ukeoppgaver.model.Registration;
import oslomet.webprog.ukeoppgaver.repository.VehicleRepository;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleRepository repo;

    @Autowired
    HttpSession session;

    @PostMapping("/api/add")
    public void add(Registration registration, HttpServletResponse response) throws IOException {
        if (session.getAttribute("bruker") != null) {
            repo.addRegistrations(registration);
        } else {
            System.out.println("Du må være logget inn for å registrere en bil");
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Du må være logget inn for å registrere en bil");
        }


    }

    @PostMapping("api/changeOneRegistration")
    public void changeOneRegistration(Registration registration, HttpServletResponse response) throws IOException {
        if (session.getAttribute("bruker") != null) {
            repo.changeOneRegistration(registration);
        } else {
            System.out.println("Du må være logget inn for å endre en bil");
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Du må være logget inn for å endre en bil");
        }
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
        if (session.getAttribute("bruker") != null) {
            if (repo.getOneRegistration(id) == null) {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB Controller, getOneRegistration()");
            }
            return repo.getOneRegistration(id);
        } else {
            System.out.println("Du må være logget inn for å hente en bil");
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Du må være logget inn for å hente en bil");
            return null;
        }
    }

    @GetMapping("/api/deleteSingleRegistration")
    public void deleteSingleRegistration(String id, HttpServletResponse response) throws IOException {
        if (session.getAttribute("bruker") != null) {
            repo.deleteSingleRegistration(id);
        } else {
            System.out.println("Du må være logget inn for å slette en bil");
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Du må være logget inn for å slette en bil");
        }

    }

    @DeleteMapping("/api")
    public void deleteAll(HttpServletResponse response) throws IOException {
        if (session.getAttribute("bruker") != null) {
            repo.deleteVehicles();
        } else {
            System.out.println("Du må være logget inn for å slette alle biler");
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Du må være logget inn for å slette alle biler");
        }
    }

    @PostMapping("/api/login")
    public void login(Bruker registration, HttpServletResponse response) throws IOException {

        try {
            Bruker utBruker = repo.login(registration);

            if (utBruker != null) {
                session.setAttribute("bruker", utBruker);
            } else {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil brukernavn eller passord");
            }
        } catch (Exception e) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB!");
        }




    }

    @GetMapping("/api/logout")
    public void logout() {
        session.invalidate();
    }

    @PostMapping("/api/registrer")
    public void register(Bruker bruker, HttpServletResponse response) throws IOException {

        Bruker logedInBruker = (Bruker) session.getAttribute("bruker");
        if (logedInBruker != null && logedInBruker.getAdmin() == 1) {
            boolean ok = repo.register(bruker);
            if (!ok) {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB Controller, register()");
            }
        } else {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Ikke logget inn, eller manglende rettighet, kan ikke registrere bruker");
        }

    }
}
