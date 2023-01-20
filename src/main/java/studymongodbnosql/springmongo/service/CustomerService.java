package studymongodbnosql.springmongo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import studymongodbnosql.springmongo.domain.Customer;
import studymongodbnosql.springmongo.dto.CustomerRequestDto;
import studymongodbnosql.springmongo.dto.CustomerResponseDto;
import studymongodbnosql.springmongo.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerResponseDto saveCustomer(CustomerRequestDto customerRequestDto) {
        Customer savedCustomer = customerRepository.save(customerRequestDto.toEntity());
        return savedCustomer.toDto();
    }

    public List<CustomerResponseDto> findCustomerByFirstName(String firstName) {
        List<Customer> customerList = customerRepository.findByFirstName(firstName);
        List<CustomerResponseDto> result = new ArrayList<>();
        customerList.stream().forEach(c -> {
            result.add(c.toDto());
        });

        return result;
    }
}
