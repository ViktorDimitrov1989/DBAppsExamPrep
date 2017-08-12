package app.dto.view;

import app.dto.wrappers.ParticipantsWrapper;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopXmlDto {
    @XmlAttribute(name = "name")
    private String name;
    //named like that to convert automatic
    @XmlElement(name = "participants")
    private ParticipantsWrapper participant;
    @XmlTransient
    private double pricePerParticipant;

    @XmlAttribute(name = "total-profit")
    public String getTotalProfit(){
        return String.valueOf((pricePerParticipant * (participant.getCount())) * 0.8);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParticipantsWrapper getParticipant() {
        return participant;
    }

    public void setParticipant(ParticipantsWrapper participant) {
        this.participant = participant;
    }

    public double getPricePerParticipant() {
        return pricePerParticipant;
    }

    public void setPricePerParticipant(double pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }
}
