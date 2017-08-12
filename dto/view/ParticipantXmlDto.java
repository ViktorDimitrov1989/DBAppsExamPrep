package app.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantXmlDto {
    @XmlTransient
    private String firstName;
    @XmlTransient
    private String lastName;

    public ParticipantXmlDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlValue
    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public void setFullName(String fullName){
        String[] tokens = fullName.split("\\s+");

        this.firstName = tokens[0];
        this.lastName = tokens[1];
    }



}
