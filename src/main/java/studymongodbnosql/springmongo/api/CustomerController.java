package studymongodbnosql.springmongo.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studymongodbnosql.springmongo.domain.Customer;
import studymongodbnosql.springmongo.dto.CustomerRequestDto;
import studymongodbnosql.springmongo.dto.CustomerResponseDto;
import studymongodbnosql.springmongo.service.CustomerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        try {
            CustomerResponseDto customerResponseDto = customerService.saveCustomer(customerRequestDto);
            return new ResponseEntity<>(customerResponseDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find/{firstName}")
    public ResponseEntity<?> findCustomerByFirstName(@PathVariable String firstName) {
        try {
            List<CustomerResponseDto> customerResponseDtoList = customerService.findCustomerByFirstName(firstName);
            return new ResponseEntity<>(customerResponseDtoList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody CustomerRequestDto customerRequestDto, @PathVariable String id) {
        try {
            CustomerResponseDto customerResponseDto = customerService.updateCustomer(customerRequestDto, id);
            return new ResponseEntity<>(customerResponseDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
