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

    public List<CustomerResponseDto> findAllCustomer() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerResponseDto> result = new ArrayList<>();
        customerList.stream().forEach(c -> {
            result.add(c.toDto());
        });

        return result;
    }

    public CustomerResponseDto updateCustomer(CustomerRequestDto customerRequestDto, String id) {
        Customer customer = customerRequestDto.toEntity();
        customer.setId(id);
        Customer savedCustomer = customerRepository.save(customer);

        return savedCustomer.toDto();
    }

    public boolean deleteCustomer(String id) {
        try {
            customerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
