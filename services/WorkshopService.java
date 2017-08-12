package app.services;

import app.dto.wrappers.AddWorkshopsWrapper;
import app.models.WorkShop;

import java.util.List;
import java.util.Map;

public interface WorkshopService {

    void saveWorkshops(AddWorkshopsWrapper workshopsWrapper);

    Map<String, List<WorkShop>> findWorkshopsByLocation();


}
