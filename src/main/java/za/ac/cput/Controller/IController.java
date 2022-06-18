package za.ac.cput.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IController {

    @RequestMapping(value = {"/", "/school_management"})
    public ResponseEntity<String>home(){
        return  new ResponseEntity<>("Welcome to school_management", HttpStatus.OK);
    }

}
