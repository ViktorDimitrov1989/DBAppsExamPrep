package app.dto.wrappers;

import app.dto.add.AddAccessoryXmlDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "accessories")
public class AddAccessoryWrapper {

    @XmlElement(name = "accessory")
    private List<AddAccessoryXmlDto> accessories;

    public AddAccessoryWrapper() {
    }

    public List<AddAccessoryXmlDto> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<AddAccessoryXmlDto> accessories) {
        this.accessories = accessories;
    }
}
