package pl.coderslab.charity.donation;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.category.CategoryDto;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.institution.InstitutionDto;
import pl.coderslab.charity.institution.InstitutionEntity;
import pl.coderslab.charity.institution.InstitutionRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("donation")
@RequestMapping("/donation")
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
        return "formStep1";
    }

    @GetMapping("/addStep2")
    public String addDonationStep2(@ModelAttribute DonationDto donationDto, Model model, HttpSession session) {
        DonationDto donationSession = (DonationDto) session.getAttribute("donation");
        donationSession.setCategories(donationDto.getCategories());
        model.addAttribute("donation", donationSession);
        return "formStep2";
    }

    @PostMapping("/add")
    public String processFormAdd() {

        return "form-confirmation";
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
