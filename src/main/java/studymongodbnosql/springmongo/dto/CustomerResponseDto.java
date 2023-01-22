package studymongodbnosql.springmongo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerResponseDto {
    private String id;
    private String firstName;
    private String lastName;
}
