package app.dto.add;

import app.dto.wrappers.AddParticipantsXmlWrapper;
import app.models.Photographer;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "workshop")
public class AddWorkshopXmlDto {
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "start-date")
    private Date startDate;
    @XmlAttribute(name = "end-date")
    private Date endDate;
    @XmlAttribute(name = "location")
    private String location;
    @XmlAttribute(name = "price")
    private double pricePerParticipant;
    @XmlElement(name = "trainer")
    private String trainerName;
    @XmlElement(name = "participants")
    private AddParticipantsXmlWrapper participantsWrapper;
    @XmlTransient
    private Photographer trainer;
    @XmlTransient
    private List<Photographer> participants;

    public AddWorkshopXmlDto() {
        this.participants = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPricePerParticipant() {
        return pricePerParticipant;
    }

    public void setPricePerParticipant(double pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public AddParticipantsXmlWrapper getParticipants() {
        return participantsWrapper;
    }

    public void setParticipants(AddParticipantsXmlWrapper participantsWrapper) {
        this.participantsWrapper = participantsWrapper;
    }

    public Photographer getTrainer() {
        return trainer;
    }

    public void setTrainer(Photographer trainer) {
        this.trainer = trainer;
    }

    public void setParticipants(List<Photographer> participants) {
        this.participants = participants;
    }
}
