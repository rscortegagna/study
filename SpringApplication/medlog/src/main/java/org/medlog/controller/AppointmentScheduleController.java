package org.medlog.controller;


import org.medlog.dao.DoctorsDAO;
import org.medlog.models.Appointment;
import org.medlog.models.AppointmentSchedule;
import org.medlog.models.Doctors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@Controller
@RequestMapping("/appointment")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class AppointmentScheduleController {

    @Autowired
    private AppointmentSchedule appointmentSchedule;

    @Autowired
    private DoctorsDAO doctorsDao;

    @RequestMapping("/add")
    public ModelAndView add(Integer doctorId, BigDecimal appointmentPrice, String appointmentDate) throws ParseException {

        System.out.println(appointmentDate);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(simpleDateFormat.parse(appointmentDate));

        ModelAndView modelAndView = new ModelAndView("redirect:/doctors");
        Appointment appointment = createAppointment(doctorId, appointmentPrice, calendar);

        appointmentSchedule.add(appointment);

        return modelAndView;

    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView appointments() {
        return new ModelAndView("appointment/itens");
    }

    private Appointment createAppointment(Integer doctorId, BigDecimal appointmentPrice, Calendar calendar) {

        Doctors doctor = doctorsDao.find(doctorId);
        Appointment appointment = new Appointment(doctor, appointmentPrice, calendar);

        return appointment;
    }

}
