package pl.coderslab.charity.donation;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.category.CategoryDto;
import pl.coderslab.charity.category.CategoryEntity;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.exception.CategoryNotFoundException;
import pl.coderslab.charity.exception.InstitutionNotFoundException;
import pl.coderslab.charity.institution.InstitutionDto;
import pl.coderslab.charity.institution.InstitutionEntity;
import pl.coderslab.charity.institution.InstitutionRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public String addDonationStep1(@ModelAttribute DonationDto donationDto, Model model, HttpSession session) {
        DonationDto donationSession = (DonationDto) session.getAttribute("donation");
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (int i = 0; i < donationDto.getCategoriesIds().size(); i++) {

            CategoryEntity categoryEntity = categoryRepository.findById(donationDto.getCategoriesIds().get(i)).orElseThrow(CategoryNotFoundException::new);

            CategoryDto categoryDto = modelMapper.map(categoryEntity, CategoryDto.class);

            categoryDtos.add(categoryDto);
        }
        donationSession.setCategoriesDto(categoryDtos);
        model.addAttribute("donation", donationSession);
        return "formStep2";
    }

    @GetMapping("/addStep3")
    public String addDonationStep2(@ModelAttribute DonationDto donationDto, Model model, HttpSession session) {
        DonationDto donationSession = (DonationDto) session.getAttribute("donation");
        donationSession.setQuantity(donationDto.getQuantity());
        model.addAttribute("donation", donationSession);
        return "formStep3";
    }

    @GetMapping("/addStep4")
    public String addDonationStep3(@ModelAttribute DonationDto donationDto, Model model, HttpSession session) {
        DonationDto donationSession = (DonationDto) session.getAttribute("donation");

        InstitutionEntity institutionEntity = institutionRepository.findById(donationDto.getInstitutionDtoId()).orElseThrow(InstitutionNotFoundException::new);
        InstitutionDto institutionDto = modelMapper.map(institutionEntity, InstitutionDto.class);

        donationSession.setInstitutionDto(institutionDto);
        model.addAttribute("donation", donationSession);
        return "formStep4";
    }

    @GetMapping("/addConfirm")
    public String addDonationStep4(@ModelAttribute DonationDto donationDto, Model model, HttpSession session) {
        DonationDto donationSession = (DonationDto) session.getAttribute("donation");

        donationSession.setCity(donationDto.getCity());
        donationSession.setStreet(donationDto.getStreet());
        donationSession.setZipCode(donationDto.getZipCode());
        donationSession.setPickUpDate(donationDto.getPickUpDate());
        donationSession.setPickUpTime(donationDto.getPickUpTime());

        if (donationDto.getPickUpComment().trim().equals("") || donationDto.getPickUpComment() == null) {
            donationSession.setPickUpComment("Brak uwag");
        } else {
            donationSession.setPickUpComment(donationDto.getPickUpComment());
        }

        model.addAttribute("donation", donationSession);
        return "formConfirm";
    }



    @PostMapping("/add")
    public String processFormAdd() {

        return "form-confirmation";
    }


    @ModelAttribute("categories")
    public List<CategoryEntity> fetchAllCategories() {
        return modelMapper.map(categoryRepository.findAll(), new TypeToken<List<CategoryDto>>() {
        }.getType());
    }

    @ModelAttribute("institutions")
    public List<InstitutionEntity> fetchAllInstitutions() {
        return modelMapper.map(institutionRepository.findAll(), new TypeToken<List<InstitutionDto>>() {
        }.getType());
    }

}
