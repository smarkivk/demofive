package registrationone.demofive.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import registrationone.demofive.Entity.Employee;
import registrationone.demofive.Service.EmployeeService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public ResponseEntity<?> registerEmployee(
            @RequestParam("empNO") String empNO,
            @RequestParam("empName") String empName) {
        try {
            Employee employee = employeeService.registerEmployee(empNO, empName);
            return ResponseEntity.ok(employee);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing your request.");
        }
    }
}

