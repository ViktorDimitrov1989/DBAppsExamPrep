package app.services;

import app.dto.wrappers.AddWorkshopsWrapper;

import java.util.List;

public interface WorkshopService {

    void saveWorkshops(AddWorkshopsWrapper workshopsWrapper);

}
