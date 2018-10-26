package org.medlog.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION)
public class AppointmentSchedule implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<Appointment, Integer> appointments = new LinkedHashMap<>();

    public void add(Appointment appointment) {
        appointments.put(appointment, getQuantity(appointment) + 1);
    }

    private int getQuantity(Appointment appointment) {

        if (!appointments.containsKey(appointment)) {
            appointments.put(appointment, 0);
        }

        return appointments.get(appointment);
    }

    public Collection<Appointment> getAppointments() {
        return appointments.keySet();
    }

    public int getTotal() {
        return this.appointments.values().stream()
                .reduce(0, (next, sum) -> next + sum);
    }
}
