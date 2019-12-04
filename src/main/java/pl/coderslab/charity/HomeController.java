package pl.coderslab.charity;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.donation.DonationDto;
import pl.coderslab.charity.donation.DonationEntity;
import pl.coderslab.charity.donation.DonationRepository;
import pl.coderslab.charity.institution.InstitutionDto;
import pl.coderslab.charity.institution.InstitutionEntity;
import pl.coderslab.charity.institution.InstitutionRepository;

import java.util.List;


@Controller
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final CategoryRepository categoryRepository;
    private final DonationRepository donationRepository;
    private final ModelMapper modelMapper;

    public HomeController(InstitutionRepository institutionRepository, CategoryRepository categoryRepository, DonationRepository donationRepository, ModelMapper modelMapper) {
        this.institutionRepository = institutionRepository;
        this.categoryRepository = categoryRepository;
        this.donationRepository = donationRepository;
        this.modelMapper = modelMapper;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        return "index";
    }

    @ModelAttribute("institutions")
    public List<InstitutionEntity> fetchAllInstitutions() {
        return modelMapper.map(institutionRepository.findAll(), new TypeToken<List<InstitutionDto>>() {
        }.getType());
    }

    @ModelAttribute("donations")
    public List<DonationEntity> fetchAllDonations() {
        return modelMapper.map(donationRepository.findAll(), new TypeToken<List<DonationDto>>() {
        }.getType());
    }

    @ModelAttribute("donationsAmount")
    public int fetchNumberOfDonations() {
        return donationRepository.findAll().size();
    }

    @ModelAttribute("institutionsAmount")
    public int fetchNumberOfInstitutions() {
        return institutionRepository.findAll().size();
    }
}
