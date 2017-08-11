package app.services;

import app.dto.wrappers.AddWorkshopsWrapper;

public interface WorkshopService {

    void saveWorkshops(AddWorkshopsWrapper workshopsWrapper);

}
