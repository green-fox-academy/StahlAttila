package com.restexercise.restexercise.Controllers;

import com.restexercise.restexercise.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/doubling")
    @ResponseBody
    public ResponseEntity<Doubling> doubling(@RequestParam (required = false) Integer input) {
        if(input == null){
            return ResponseEntity.ok()
                    .body(new Doubling());
        }

        return ResponseEntity.ok()
                .body(new Doubling(input, input*2));
    }

    @GetMapping("/greeter")
    @ResponseBody
    public ResponseEntity<Greeter> greet(@RequestParam (required = false) String name, @RequestParam (required = false) String title) {
        if(name == null && title == null){
            return ResponseEntity.badRequest()
                    .body(new Greeter(null, null));
        }else if(title == null){
            return ResponseEntity.badRequest()
                    .body(new Greeter(name, null));
        }

        return ResponseEntity.ok()
                .body(new Greeter(name, title));
    }

    @GetMapping("appenda/{appendable}")
    @ResponseBody
    public ResponseEntity<AppendA> appendA(@PathVariable String appendable) {
        return ResponseEntity.ok()
                .body(new AppendA(appendable));
    }


    @PostMapping("/dountil/{action}")
    public ResponseEntity<DoUntil> doUntil(@PathVariable String action, @RequestBody (required = false) Until until) {
        if(until.getUntil() == null){
            return ResponseEntity.badRequest()
                    .body(new DoUntil(null, action));
        }

        return ResponseEntity.ok()
                .body(new DoUntil(until.getUntil(), action));

    }

    @PostMapping("/arrays")
    @ResponseBody
    public ResponseEntity<ArrayHandler> arrays(@RequestBody ArrayFromBody array) {

        if(array.getWhat() == null || array.getNumbers() == null) {
            return ResponseEntity.badRequest()
                    .body(new ArrayHandler(array.getWhat(), array.getNumbers()));
        }

        return ResponseEntity.ok()
                .body(new ArrayHandler(array.getWhat(), array.getNumbers()));
    }


}
