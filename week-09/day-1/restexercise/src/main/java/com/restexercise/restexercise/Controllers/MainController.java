package com.restexercise.restexercise.Controllers;

import com.restexercise.restexercise.Domain.*;
import com.restexercise.restexercise.Service.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
public class MainController {

    LogServiceImpl logService;

    @Autowired
    public MainController(LogServiceImpl logService) {
        this.logService = logService;
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/doubling")
    @ResponseBody
    public ResponseEntity<Doubling> doubling(@RequestParam(required = false) Integer input) {
        if (input == null) {
            return ResponseEntity.ok()
                    .body(new Doubling());
        }

        logService.saveLog(new Log("/doubling", "input=" + input));
        return ResponseEntity.ok()
                .body(new Doubling(input, input * 2));
    }

    @GetMapping("/greeter")
    @ResponseBody
    public ResponseEntity<Greeter> greet(@RequestParam(required = false) String name, @RequestParam(required = false) String title) {
        if (name == null && title == null) {
            return ResponseEntity.badRequest()
                    .body(new Greeter(null, null));
        } else if (title == null) {
            return ResponseEntity.badRequest()
                    .body(new Greeter(name, null));
        }
        logService.saveLog(new Log("/greeter", "name=" + name + " title=" + title));
        return ResponseEntity.ok()
                .body(new Greeter(name, title));
    }

    @GetMapping("appenda/{appendable}")
    @ResponseBody
    public ResponseEntity<AppendA> appendA(@PathVariable String appendable) {
        logService.saveLog(new Log("/appenda", "appended=" + appendable));
        return ResponseEntity.ok()
                .body(new AppendA(appendable));
    }


    @PostMapping("/dountil/{action}")
    public ResponseEntity<DoUntil> doUntil(@PathVariable String action, @RequestBody(required = false) Until until) {
        if (until.getUntil() == null) {
            return ResponseEntity.badRequest()
                    .body(new DoUntil(null, action));
        }
        logService.saveLog(new Log("/dountil/" + action, "until=" + until.getUntil()));
        return ResponseEntity.ok()
                .body(new DoUntil(until.getUntil(), action));

    }

    @PostMapping("/arrays")
    @ResponseBody
    public ResponseEntity<ArrayHandler> arrays(@RequestBody ArrayFromBody array) {

        if (array.getWhat() == null || array.getNumbers() == null) {
            return ResponseEntity.badRequest()
                    .body(new ArrayHandler(null, null));
        } else if (array.getWhat().equals("double")) {
            return ResponseEntity.ok()
                    .body(new ArrayHandlerDouble(array.getWhat(), array.getNumbers()));
        }
        logService.saveLog(new Log("/arrays", "array=" + array.getWhat() + "," + Arrays.toString(array.getNumbers())));
        return ResponseEntity.ok()
                .body(new ArrayHandler(array.getWhat(), array.getNumbers()));
    }

    @GetMapping("/log")
    @ResponseBody
    public Entry log() {
        return new Entry(logService.findAll());
    }

    @PostMapping("/sith")
    @ResponseBody
    public SithText sithText(@RequestBody(required = false) Text text) {
        if(text == null){
            return new SithText("");
        }
        return new SithText(text.getText());
    }

    /*@PostMapping("/translate")
    @ResponseBody
    public Camelizer translate(@ResponseBody Camelizer camelizer) {

    }*/


}
