package hospital.masterdata.service;
import hospital.masterdata.mapper.RelationMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class RelationServiceImpl implements RelationService {
    @Resource
    private RelationMapper relationMapper;
    @Override
    public int addPrescriptionDoctorAdvice(Integer prescriptionId, Integer[] adviceId) {
        return relationMapper.addPrescriptionDoctorAdvice(prescriptionId,adviceId);
    }
}
