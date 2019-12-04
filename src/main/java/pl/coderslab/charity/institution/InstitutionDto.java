package pl.coderslab.charity.institution;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class InstitutionDto {

    private Long id;

    private String name;

    private String description;
}
