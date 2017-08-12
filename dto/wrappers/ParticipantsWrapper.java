package app.dto.wrappers;

import app.dto.view.ParticipantXmlDto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantsWrapper {

    @XmlElement(name = "participant")
    private List<ParticipantXmlDto> participant;

    public ParticipantsWrapper() {
    }

    public List<ParticipantXmlDto> getParticipant() {
        return participant;
    }

    public void setParticipant(List<ParticipantXmlDto> participant) {
        this.participant = participant;
    }

    @XmlAttribute(name = "count")
    public int getCount(){
        return this.participant.size();
    }

}
