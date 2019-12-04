package pl.coderslab.charity.donation;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.category.CategoryDto;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.institution.InstitutionDto;
import pl.coderslab.charity.institution.InstitutionEntity;
import pl.coderslab.charity.institution.InstitutionRepository;

import java.util.List;

@Controller
public class DonationController {

    private final DonationRepository donationRepository;
    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final ModelMapper modelMapper;

    public DonationController(DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionRepository institutionRepository, ModelMapper modelMapper) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addDonation(Model model) {
        model.addAttribute("donation", new DonationDto());
        return "form";
    }

    @PostMapping("/add")
    public String processFormAdd() {

        return "redirect:/";
    }


    @ModelAttribute("categories")
    public List<InstitutionEntity> fetchAllCategories() {
        return modelMapper.map(categoryRepository.findAll(), new TypeToken<List<CategoryDto>>() {
        }.getType());
    }

    @ModelAttribute("institutions")
    public List<InstitutionEntity> fetchAllInstitutions() {
        return modelMapper.map(institutionRepository.findAll(), new TypeToken<List<InstitutionDto>>() {
        }.getType());
    }

}
