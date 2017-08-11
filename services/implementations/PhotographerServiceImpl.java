package app.services.implementations;

import app.dto.view.LandscapePhotographerView;
import app.dto.view.OrderedPhotographerView;
import app.dto.view.SameCamPhotographerXmlView;
import app.dto.wrappers.SameCameraPhotographersWrapper;
import app.models.Lens;
import app.models.Photographer;
import app.models.abstractions.Camera;
import app.repositories.CameraRepository;
import app.repositories.LensRepository;
import app.repositories.PhotographerRepository;
import app.services.PhotographerService;
import app.utils.DtoMappingUtil;
import app.utils.XmlSerializer;
import app.utils.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@Transactional
public class PhotographerServiceImpl implements PhotographerService {

    private PhotographerRepository photographerRepository;
    private LensRepository lensRepository;
    private CameraRepository cameraRepository;


    @Autowired
    public PhotographerServiceImpl(PhotographerRepository photographerRepository,
                                   LensRepository lensRepository,
                                   CameraRepository cameraRepository) {
        this.photographerRepository = photographerRepository;
        this.lensRepository = lensRepository;
        this.cameraRepository = cameraRepository;
    }

    @Override
    public void savePhotographer(Photographer photographer, Iterable<Long> lensIds){
        addCameras(photographer);

        if(ValidationUtil.isValid(photographer)){
            List<Lens> lenses = this.lensRepository.findByIdIn(lensIds);
            List<Lens> resLenses = new ArrayList<>();

            for (Lens lense : lenses) {

                if(isCompatible(lense, photographer.getPrimaryCamera())
                        || isCompatible(lense, photographer.getSecondaryCamera())){
                    lense.setOwner(photographer);
                    resLenses.add(lense);
                }
            }
            photographer.setLenses(resLenses);
            this.photographerRepository.saveAndFlush(photographer);
            System.out.println("Successfully imported " + photographer);

        }else{
            System.out.println("Error. Invalid data provided");
        }

    }

    @Override
    public List<OrderedPhotographerView> findAllOrderePhotographers() {
        List<Photographer> photographers = this.photographerRepository.findAllByOrderByFirstNameAscLastNameDesc();
        List<OrderedPhotographerView> orderedPhotographers = DtoMappingUtil.convert(photographers, OrderedPhotographerView.class);

        return orderedPhotographers;
    }

    @Override
    public List<LandscapePhotographerView> findAllLandscapePhotographers() {
        List<Photographer> photographers = this.photographerRepository.findAllLandscapePhotographers();
        List<LandscapePhotographerView> landscapePhotographers
                = DtoMappingUtil.convert(photographers, LandscapePhotographerView.class);

        landscapePhotographers = landscapePhotographers.stream().filter(p -> {
            for (Lens lens : p.getLenses()) {
                if(lens.getFocalLength() <= 30){
                    return false;
                }
            }
            return true;
        }).collect(Collectors.toList());

        for (LandscapePhotographerView landscapePhotographer : landscapePhotographers) {
            landscapePhotographer.setCamProd(landscapePhotographer.getPrimaryCamera().getMake());
            landscapePhotographer.setLensesCount(landscapePhotographer.getLenses().size());
        }

        return landscapePhotographers;
    }

    @Override
    public List<SameCamPhotographerXmlView> sameCamMakePhotographers() {
        List<Photographer> photographers = this.photographerRepository.sameCamMakePhotographers();
        List<SameCamPhotographerXmlView> photographersViews =
                DtoMappingUtil.convert(photographers, SameCamPhotographerXmlView.class);

        return photographersViews;

    }


    private boolean isCompatible(Lens lense, Camera primaryCamera) {
        return lense.getCompatibleWith() != null
                && lense.getCompatibleWith().equals(primaryCamera.getMake());
    }

    private void addCameras(Photographer photographer) {
        Long camerasCount = this.cameraRepository.count();
        long id = ThreadLocalRandom.current().nextLong(1, camerasCount);
        if(photographer.getPrimaryCamera() == null){
            Camera primary = this.cameraRepository.findOne(id);
            photographer.setPrimaryCamera(primary);
        }

        id = ThreadLocalRandom.current().nextLong(1, camerasCount);
        if(photographer.getSecondaryCamera() == null){
            Camera secondary = this.cameraRepository.findOne(id);
            photographer.setSecondaryCamera(secondary);
        }
    }

}
