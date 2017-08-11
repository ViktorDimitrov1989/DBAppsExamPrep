package app.services.implementations;

import app.models.abstractions.Camera;
import app.repositories.CameraRepository;
import app.services.CameraService;
import app.utils.DtoMappingUtil;
import app.utils.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CameraServiceImpl implements CameraService {

    private CameraRepository cameraRepository;

    @Autowired
    public CameraServiceImpl(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    @Override
    public void saveCamera(Camera camera) {

        if(ValidationUtil.isValid(camera)){
            this.cameraRepository.saveAndFlush(camera);
            System.out.println("Successfully imported " + camera);
        }else{
            System.out.println("Error. Invalid data provided.");
        }


    }

}
