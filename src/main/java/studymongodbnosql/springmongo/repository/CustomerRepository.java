package studymongodbnosql.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import studymongodbnosql.springmongo.domain.Customer;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    public List<Customer> findByFirstName(String firstName);
}