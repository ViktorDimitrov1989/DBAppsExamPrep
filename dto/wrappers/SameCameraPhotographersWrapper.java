package app.dto.wrappers;

import app.dto.view.SameCamPhotographerXmlView;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "photographers")
public class SameCameraPhotographersWrapper {

    @XmlElement(name = "photographer")
    private List<SameCamPhotographerXmlView> photographers;

    public SameCameraPhotographersWrapper() {
    }

    public List<SameCamPhotographerXmlView> getPhotographers() {
        return photographers;
    }

    public void setPhotographers(List<SameCamPhotographerXmlView> photographers) {
        this.photographers = photographers;
    }
}
