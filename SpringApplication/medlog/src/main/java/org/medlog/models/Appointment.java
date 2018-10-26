package org.medlog.models;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Objects;

public class Appointment {

    private Doctors doctor;
    private BigDecimal appointmentPrice;
    private Calendar date;

    public Appointment(Doctors doctor, BigDecimal appointmentPrice, Calendar date) {
        this.doctor = doctor;
        this.appointmentPrice = appointmentPrice;
        this.date = date;
    }

    public Doctors getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctors doctor) {
        this.doctor = doctor;
    }

    public BigDecimal getAppointmentPrice() {
        return appointmentPrice;
    }

    public void setAppointmentPrice(BigDecimal appointmentPrice) { this.appointmentPrice = appointmentPrice; }

    public Calendar getDate() { return date; }

    public void setDate(Calendar date) { this.date = date; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(doctor, that.doctor) &&
                Objects.equals(appointmentPrice, that.appointmentPrice) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctor, appointmentPrice, date);
    }
}
