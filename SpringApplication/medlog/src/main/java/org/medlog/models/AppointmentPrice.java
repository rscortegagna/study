package org.medlog.models;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class AppointmentPrice {
    private BigDecimal value;
    private HealthInsurance healthInsurance;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public HealthInsurance getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(HealthInsurance healthInsurance) {
        this.healthInsurance = healthInsurance;
    }
}
