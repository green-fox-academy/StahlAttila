package com.groot.groot.Controllers;

import com.groot.groot.Domain.Groot;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

    @GetMapping("/groot")
    public ResponseEntity<Groot> getMessage(@RequestParam (required = false) String message) {

        if(message != null) {
            return ResponseEntity.ok()
                    .body(new Groot(message));
        }

        return ResponseEntity.badRequest()
                .body(new Groot(null));
    }
}
