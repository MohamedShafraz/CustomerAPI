package com.firstSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {

    private final CustomerRepository customerRepository;
    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
//    @GetMapping("/")
//    public String home(){
//        return "<center><h1>API Initiated Successfully</h1></center>";
//    }
    @GetMapping
    List<Customer> getCustomer(){
        return customerRepository.findAll();
    }

    record  NewCustomerRequest(String name,String email,Integer age) {}

    @PostMapping
    public  void addCustomer(@RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer customerId){
        customerRepository.deleteById(customerId);
    }
    @PutMapping("{customerId}")
    public  void updateCustomer(@PathVariable("customerId") Integer customerId,@RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
    }


//    //For Json  output
//    @GetMapping("/")
//    public HomeResponse home(){
//        return new HomeResponse("<center><h1>API Initiated Successfully</h1></center>");
//    }
//    //like final class but record classes have more constraints compared to regular final classes
//    record HomeResponse(String message){}
}
