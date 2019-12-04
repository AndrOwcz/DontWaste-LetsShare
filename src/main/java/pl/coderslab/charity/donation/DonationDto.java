package pl.coderslab.charity.donation;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.category.CategoryEntity;
import pl.coderslab.charity.institution.InstitutionEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class DonationDto {

    private Long id;

    private int quantity;

    private List<CategoryEntity> categories;

    private InstitutionEntity institutionEntity;

    private String street;

    private String city;

    private String zipCode;

    private LocalDate pickUpDate;

    private LocalTime pickUpTime;

    private String pickUpComment;
}
