package hospital.masterdata.service;
import hospital.masterdata.entity.Sickness;
import hospital.masterdata.mapper.SicknessMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
@Service
public class SicknessServiceImpl implements SicknessService {
    @Resource
    private SicknessMapper sicknessMapper;
    @Override
    public List<Sickness> findAll() {
        return sicknessMapper.findAll();
    }
    @Override
    public List<Sickness> findAllBy(String sicknessName) {
        return sicknessMapper.findAllBy(sicknessName);
    }
}