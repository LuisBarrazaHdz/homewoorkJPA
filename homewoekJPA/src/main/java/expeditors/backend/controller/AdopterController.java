package expeditors.backend.controller;

import expeditors.backend.adoption.Adopter;
import expeditors.backend.adoption.FilterDTO;
import expeditors.backend.service.AdopterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/adopter")
public class AdopterController {
    private AdopterService adopterService;

    public AdopterController(AdopterService adopterService) {
        this.adopterService = adopterService;
    }

    @GetMapping(path = "/holamundo")
    public ResponseEntity<?> getHolaMundo() {
        return ResponseEntity.ok("Hola mundo!!");
    }

    @GetMapping("getAdopterById/{idAdopter:\\d+}")
    public ResponseEntity<?> getAdopterById(@PathVariable("idAdopter") int idAdopter) {
        Adopter adopter =  adopterService.getAdopterById(idAdopter);
        if(adopter == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No found adopter id: " + idAdopter);
        }
        return ResponseEntity.ok(adopter);
    }

    @GetMapping(path = "/getAllAdopters")
    public ResponseEntity<?> getAllAdopters() {
        List<Adopter> adopters =  adopterService.getAllAdopters();
        return ResponseEntity.ok(adopters);
    }

    @DeleteMapping("{idAdopter:\\d+}")
    public ResponseEntity<?> deleteAdopter(@PathVariable("idAdopter") int idAdopter) {
        boolean result = adopterService.deleteAdopter(idAdopter);
        if(!result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No exist Adopter: " + idAdopter);
        }

        return ResponseEntity.ok("Adopter successfully removed");
    }

    @PutMapping
    public ResponseEntity<?> updateAdopter(@RequestBody Adopter adopter) {
        boolean result = adopterService.updateAdopter(adopter);
        if(!result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No exist adopter id: " + adopter.getIdAdopter());
        }

        return ResponseEntity.ok("Adopter successfully updated");
    }

}
