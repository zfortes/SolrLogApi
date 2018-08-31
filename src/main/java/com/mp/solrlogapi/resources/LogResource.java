package com.mp.solrlogapi.resources;


import com.mp.solrlogapi.entidies.Log;
import com.mp.solrlogapi.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LogResource {

    @Autowired
    private LogRepository rp;


    @GetMapping("/log")
	public ResponseEntity<?> receberLog(){

    	    Iterable<Log> logs = rp.findAll();
		try {
			return ResponseEntity.ok().body(rp.findAll());
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

    @GetMapping("/log/{metodo}")
    public ResponseEntity<?> receberLog(@PathVariable("metodo") String metodo){

        Iterable<Log> logs = rp.findLogByMetodo(metodo);
        try {
            return ResponseEntity.ok().body(logs);
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/log")
    public ResponseEntity<?> salvarLog(@Valid @RequestBody Log log, BindingResult bindingResult){

        try {
            if (bindingResult.hasErrors()) {
                List<String> errorList = new ArrayList<String>();
                bindingResult.getAllErrors().forEach(
                        error->errorList.add(error.getDefaultMessage()));
                return ResponseEntity.badRequest().body(errorList);
            }

            return ResponseEntity.ok()
                    .body(rp.save(log));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
