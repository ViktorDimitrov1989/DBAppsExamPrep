package app.services;

import app.dto.add.AddPhotographerDto;
import app.dto.view.LandscapePhotographerView;
import app.dto.view.OrderedPhotographerView;
import app.dto.view.SameCamPhotographerXmlView;
import app.dto.wrappers.SameCameraPhotographersWrapper;
import app.models.Photographer;

import java.util.List;

public interface PhotographerService {

    void savePhotographer(Photographer photographer, Iterable<Long> lensIds);

    List<OrderedPhotographerView> findAllOrderePhotographers();

    List<LandscapePhotographerView> findAllLandscapePhotographers();

    List<SameCamPhotographerXmlView> sameCamMakePhotographers();

}
