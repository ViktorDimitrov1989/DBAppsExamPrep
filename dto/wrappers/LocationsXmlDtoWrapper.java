package app.dto.wrappers;

import app.dto.view.LocationXmlDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "locations")
public class LocationsXmlDtoWrapper {

    @XmlElement(name = "location")
    private List<LocationXmlDto> locationXmlDtos;

    public LocationsXmlDtoWrapper() {
        locationXmlDtos = new ArrayList<>();
    }

    public List<LocationXmlDto> getLocationXmlDtos() {
        return locationXmlDtos;
    }

    public void setLocationXmlDtos(List<LocationXmlDto> locationXmlDtos) {
        this.locationXmlDtos = locationXmlDtos;
    }

    public void addLocationXmlDto(LocationXmlDto location){
        this.locationXmlDtos.add(location);
    }

}
