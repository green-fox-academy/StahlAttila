package com.groot.groot.Controllers;

import com.groot.groot.Domain.Cargo;
import com.groot.groot.Domain.CargoRespond;
import com.groot.groot.Domain.Groot;
import com.groot.groot.Domain.Yondu;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

    Cargo cargo = new Cargo();

    @GetMapping("/groot")
    public ResponseEntity<Groot> getMessage(@RequestParam (required = false) String message) {

        if(message != null) {
            return ResponseEntity.ok()
                    .body(new Groot(message));
        }

        return ResponseEntity.badRequest()
                .body(new Groot(null));
    }

    @GetMapping("/yondu")
    public ResponseEntity<Yondu> getArrowSpeed(@RequestParam (required = false) Double distance, @RequestParam (required = false) Double time) {
        if(distance == null || time == null) {
            return ResponseEntity.badRequest()
                    .body(new Yondu(null, null));
        }

        return ResponseEntity.ok()
                    .body(new Yondu(distance, time));
    }

    @GetMapping("/rocket")
    public ResponseEntity<Cargo> getCargo() {
        return ResponseEntity.ok()
                .body(cargo);
    }

    @GetMapping("/rocket/fill")
    public ResponseEntity<Cargo> fillCargo(@RequestParam String caliber, @RequestParam Integer amount) {
        cargo.fillCargo(caliber, amount);
        CargoRespond cargoRespond = new CargoRespond(caliber, amount, cargo);
        return ResponseEntity.ok()
                .body(cargoRespond);
    }
}
