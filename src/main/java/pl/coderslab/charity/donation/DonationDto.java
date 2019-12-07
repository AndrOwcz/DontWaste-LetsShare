package pl.coderslab.charity.donation;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.category.CategoryDto;
import pl.coderslab.charity.category.CategoryEntity;
import pl.coderslab.charity.institution.InstitutionDto;
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

    private List<CategoryDto> categoriesDto;

    private InstitutionDto institutionDto;

    private String street;

    private String city;

    private String zipCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    private LocalTime pickUpTime;

    private String pickUpComment;

    private List<Long> categoriesIds;

    private Long institutionDtoId;
}
