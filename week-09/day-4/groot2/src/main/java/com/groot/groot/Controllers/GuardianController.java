package com.groot.groot.Controllers;

import com.groot.groot.Domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GuardianController {

    Cargo cargo = new Cargo();
    DraxCalorieTable draxCalorieTable = new DraxCalorieTable();

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
    public ResponseEntity<Object> fillCargo(@RequestParam (required = false) String caliber, @RequestParam (required = false) Integer amount) {


        if(caliber == null || amount == null) {
            return ResponseEntity.badRequest()
                    .body(new CargoRespond(null, null, cargo));
        }else {
            cargo.fillCargo(caliber, amount);
            CargoRespond cargoRespond = new CargoRespond(caliber, amount, cargo);
            return ResponseEntity.ok()
                    .body(cargoRespond);
        }

    }

    @GetMapping("/drax")
    public ResponseEntity<Object> getDraxCalorieTable() {
        return ResponseEntity.ok()
                .body(draxCalorieTable);
    }

    @PostMapping("/drax/add-food")
    public ResponseEntity<Food> addFood(@RequestParam String name, @RequestParam Double amount, @RequestParam Double calorie) {
        Food food = new Food(name, amount, calorie);
        draxCalorieTable.addFood(food);

        return ResponseEntity.ok()
                .body(food);
    }

    @DeleteMapping("/drax/remove-food")
    public ResponseEntity<Food> removeFood(@RequestParam Integer index) {
        Food food = draxCalorieTable.getFoodList().get(index);
        draxCalorieTable.removeFood(index);

        return ResponseEntity.ok()
                .body(food);
    }

    @PutMapping("/drax/edit-amount")
    public ResponseEntity<Food> editAmount(@RequestParam Integer index, @RequestParam Double amount) {
        draxCalorieTable.getFoodList().get(index).setAmount(amount);

        return ResponseEntity.ok()
                .body(draxCalorieTable.getFoodList().get(index));
    }
}
