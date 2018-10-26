package org.medlog.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Entity
public class Doctors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String description;
    private String photoPath;

    @DateTimeFormat
    private Calendar memberSince;

    @ElementCollection
    private List<AppointmentPrice> appointmentPriceList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public List<AppointmentPrice> getAppointmentPriceList() { return appointmentPriceList; }

    public void setAppointmentPriceList(List<AppointmentPrice> appointmentPriceList) { this.appointmentPriceList = appointmentPriceList; }

    public Calendar getMemberSince() { return memberSince; }

    public void setMemberSince(Calendar memberSince) { this.memberSince = memberSince; }

    public String getPhotoPath() { return photoPath; }

    public void setPhotoPath(String photoPath) { this.photoPath = photoPath; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctors doctors = (Doctors) o;
        return id == doctors.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Doctors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", memberSince=" + memberSince +
                ", appointmentPriceList=" + appointmentPriceList +
                '}';
    }
}
