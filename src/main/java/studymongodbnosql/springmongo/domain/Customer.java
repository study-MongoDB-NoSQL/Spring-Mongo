package studymongodbnosql.springmongo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import studymongodbnosql.springmongo.dto.CustomerResponseDto;

@Document(collection = "customer")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerResponseDto toDto() {
        return new CustomerResponseDto(id, firstName, lastName);
    }
}
