package app.services;

import app.dto.add.AddLensDto;
import app.models.Lens;

import java.util.List;

public interface LensService {

    void saveLens(AddLensDto lensDto);

    List<Lens> findByIdIn(Iterable<Long> id);

}
