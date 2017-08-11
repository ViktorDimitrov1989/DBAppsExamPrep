package app.dto.wrappers;

import app.dto.add.AddParticipantXmlDto;
import app.dto.add.AddWorkshopXmlDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "workshops")
public class AddWorkshopsWrapper {

    @XmlElement(name = "workshop")
    private List<AddWorkshopXmlDto> workshops;


    public AddWorkshopsWrapper() {
    }

    public List<AddWorkshopXmlDto> getWorkshops() {
        return workshops;
    }

    public void setWorkshops(List<AddWorkshopXmlDto> workshops) {
        this.workshops = workshops;
    }

}
