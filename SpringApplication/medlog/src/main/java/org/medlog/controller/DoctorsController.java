package org.medlog.controller;

import org.medlog.dao.DoctorsDAO;
import org.medlog.infra.FileSaver;
import org.medlog.models.Doctors;
import org.medlog.models.HealthInsurance;
import org.medlog.validation.DoctorValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorsController {

    @Autowired
    private DoctorsDAO doctorsDAO;

    @Autowired
    private FileSaver fileSaver;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new DoctorValidation());
    }

    /**
     * @param doctors
     * @param result             Result is the ´result´ for the doctors validation, it MUST be after doctors param - is this the best way of doing it spring?
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(MultipartFile photo, @Valid Doctors doctors, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return form(doctors);
        }

        String path = fileSaver.write("doctors-photo", photo);
        doctors.setPhotoPath(path);

        doctorsDAO.save(doctors);

        redirectAttributes.addFlashAttribute("success", "Doctor added successfully!");
        return new ModelAndView("redirect: doctors");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list() {
        List<Doctors> doctorsList = doctorsDAO.list();
        ModelAndView modelAndView = new ModelAndView("doctors/list");
        modelAndView.addObject("doctors", doctorsList);
        return modelAndView;
    }

    @RequestMapping("form")
    public ModelAndView form(Doctors doctors) {
        ModelAndView modelAndView = new ModelAndView("doctors/form");
        modelAndView.addObject("healthInsurances", HealthInsurance.values());
        System.out.println("values: " + HealthInsurance.values().toString());
        return modelAndView;
    }

    @RequestMapping("details/{id}")
    public ModelAndView details(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("doctors/details");
        Doctors doctor = doctorsDAO.find(id);
        modelAndView.addObject("doctor", doctor);
        return modelAndView;
    }


}
