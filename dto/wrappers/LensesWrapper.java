package app.dto.wrappers;

import app.dto.view.LensXmlView;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "lenses")
public class LensesWrapper {

    @XmlElement(name = "lens")
    private List<LensXmlView> lenses;

    public LensesWrapper() {
    }

    public List<LensXmlView> getLenses() {
        return lenses;
    }

    public void setLenses(List<LensXmlView> lenses) {
        this.lenses = lenses;
    }
}
