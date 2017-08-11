package app.services.implementations;

import app.dto.add.AddLensDto;
import app.models.Lens;
import app.repositories.LensRepository;
import app.services.LensService;
import app.utils.DtoMappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LensServiceImpl implements LensService {

    private LensRepository lensRepository;

    @Autowired
    public LensServiceImpl(LensRepository lensRepository) {
        this.lensRepository = lensRepository;
    }

    @Override
    public void saveLens(AddLensDto lensDto) {
        this.lensRepository.saveAndFlush(DtoMappingUtil.convert(lensDto, Lens.class));
    }

    @Override
    public List<Lens> findByIdIn(Iterable<Long> id) {
        return this.lensRepository.findByIdIn(id);
    }


}
