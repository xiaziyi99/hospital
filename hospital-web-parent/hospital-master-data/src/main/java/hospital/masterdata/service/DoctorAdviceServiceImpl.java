package hospital.masterdata.service;
import hospital.masterdata.entity.DoctorAdvice;
import hospital.masterdata.mapper.DoctorAdviceMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
@Service
public class DoctorAdviceServiceImpl implements DoctorAdviceService {
    @Resource
    private DoctorAdviceMapper doctorAdviceMapper;
    @Override
    public List<DoctorAdvice> findAll() {
        return doctorAdviceMapper.findAll();
    }
    @Override
    public List<DoctorAdvice> findAllBy(String adviceInfo) {
        return doctorAdviceMapper.findAllBy(adviceInfo);
    }
}