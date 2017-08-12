package app.dto.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class LocationXmlDto {

    @XmlAttribute
    private String name;
    @XmlElement(name = "workshop")
    private List<WorkshopXmlDto> workshopXmlDtoList;

    public LocationXmlDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WorkshopXmlDto> getWorkshopXmlDtoList() {
        return workshopXmlDtoList;
    }

    public void setWorkshopXmlDtoList(List<WorkshopXmlDto> workshopXmlDtoList) {
        this.workshopXmlDtoList = workshopXmlDtoList;
    }
}
