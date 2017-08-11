package app.dto.wrappers;


import app.dto.add.AddParticipantXmlDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "participants")
public class AddParticipantsXmlWrapper {

    @XmlElement(name = "participant")
    private List<AddParticipantXmlDto> participants;

    public AddParticipantsXmlWrapper() {
    }

    public List<AddParticipantXmlDto> getParticipants() {
        return participants;
    }

    public void setParticipants(List<AddParticipantXmlDto> participants) {
        this.participants = participants;
    }
}
