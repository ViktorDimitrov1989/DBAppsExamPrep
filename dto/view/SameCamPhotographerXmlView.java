package app.dto.view;

import app.dto.wrappers.LensesWrapper;
import app.models.abstractions.Camera;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "photographer")
public class SameCamPhotographerXmlView {
    @XmlTransient
    private String firstName;
    @XmlTransient
    private String lastName;
    @XmlTransient
    private Camera primaryCamera;
    @XmlAttribute(name = "name")
    private String fullName;
    @XmlAttribute(name = "primary-camera")
    private String primeCam;
    @XmlElement(name = "lenses")
    private LensesWrapper lenses;

    public SameCamPhotographerXmlView() {
    }

    public String getPrimeCam() {
        return primeCam;
    }

    public void setPrimeCam(String primeCam) {
        this.primeCam = primeCam;
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

    public Camera getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(Camera primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LensesWrapper getLenses() {
        return lenses;
    }

    public void setLenses(LensesWrapper lenses) {
        this.lenses = lenses;
    }
}
