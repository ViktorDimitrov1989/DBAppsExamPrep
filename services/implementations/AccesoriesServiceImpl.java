package app.services.implementations;

import app.dto.add.AddAccessoryXmlDto;
import app.models.Accessory;
import app.models.Photographer;
import app.repositories.AccessoriesRepository;
import app.repositories.PhotographerRepository;
import app.services.AccessoriesService;
import app.utils.DtoMappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class AccesoriesServiceImpl implements AccessoriesService{

    private AccessoriesRepository accessoriesRepository;
    private PhotographerRepository photographerRepository;

    @Autowired
    public AccesoriesServiceImpl(AccessoriesRepository accessoriesRepository,
                                 PhotographerRepository photographerRepository) {
        this.accessoriesRepository = accessoriesRepository;
        this.photographerRepository = photographerRepository;
    }

    @Override
    public void saveAccessories(List<AddAccessoryXmlDto> accesories) {
        List<Photographer> photographers = this.photographerRepository.findAll();
        Random rnd = new Random();
        for (AddAccessoryXmlDto accessoryDto : accesories) {
            int randomIndex = rnd.nextInt(photographers.size());
            Accessory accessory = DtoMappingUtil.convert(accessoryDto, Accessory.class);
            accessory.setOwner(photographers.get(randomIndex));
            this.accessoriesRepository.saveAndFlush(accessory);
            System.out.println("Successfully imported " + accessory);
        }
    }
}
