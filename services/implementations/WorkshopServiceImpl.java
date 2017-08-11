package app.services.implementations;

import app.dto.add.AddParticipantXmlDto;
import app.dto.add.AddWorkshopXmlDto;
import app.dto.wrappers.AddWorkshopsWrapper;
import app.models.Photographer;
import app.models.WorkShop;
import app.repositories.PhotographerRepository;
import app.repositories.WorkshopRepository;
import app.services.WorkshopService;
import app.utils.DtoMappingUtil;
import app.utils.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class WorkshopServiceImpl implements WorkshopService {
    private WorkshopRepository workshopRepository;
    private PhotographerRepository photographerRepository;

    @Autowired
    public WorkshopServiceImpl(WorkshopRepository workshopRepository,
                               PhotographerRepository photographerRepository) {
        this.workshopRepository = workshopRepository;
        this.photographerRepository = photographerRepository;
    }


    @Override
    public void saveWorkshops(AddWorkshopsWrapper workshopsWrapper) {
        List<AddWorkshopXmlDto> workshops = workshopsWrapper.getWorkshops();

        String debug = "";

        for (AddWorkshopXmlDto workshopDto : workshops) {

            WorkShop workShop = DtoMappingUtil.convert(workshopDto, WorkShop.class);
            String trainerFullname = workshopDto.getTrainerName();
            Photographer trainer = this.photographerRepository.findByName(trainerFullname);

            if(trainer != null){
                workShop.setTrainer(trainer);
            }

            if(ValidationUtil.isValid(workShop)){
                List<Photographer> participantsToAdd = this.addParticipants(workshopDto);

                workShop.setParticipant(participantsToAdd);

                this.workshopRepository.saveAndFlush(workShop);
                System.out.println("Successfully imported " + workShop.getName());
            }else{
                System.out.println("Error. Invalid data provided");
            }
        }
    }


    private List<Photographer> addParticipants(AddWorkshopXmlDto workshop) {
        List<Photographer> participantsToAdd = new ArrayList<>();

        if(workshop.getParticipants() == null){
            return new ArrayList<>();
        }

        for (AddParticipantXmlDto participantXmlDto : workshop.getParticipants().getParticipants()) {
            Photographer photographer = new Photographer();
            photographer = this.photographerRepository
                    .findByName(participantXmlDto.getFirstname() + " " + participantXmlDto.getLastName());
            if(photographer != null){
                participantsToAdd.add(photographer);
            }
        }

        return participantsToAdd;
    }
}
