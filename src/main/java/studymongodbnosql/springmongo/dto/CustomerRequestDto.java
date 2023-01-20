package studymongodbnosql.springmongo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import studymongodbnosql.springmongo.domain.Customer;

@Getter
@Setter
@AllArgsConstructor
public class CustomerRequestDto {
    private String firstName;
    private String lastName;

    public Customer toEntity() {
        return new Customer(firstName, lastName);
    }

}
