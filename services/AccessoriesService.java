package app.services;

import app.dto.add.AddAccessoryXmlDto;
import app.dto.wrappers.AddAccessoryWrapper;
import app.models.Accessory;

import java.util.List;

public interface AccessoriesService {

    void saveAccessories(List<AddAccessoryXmlDto> accesories);

}
