package hospital.masterdata.service;
import hospital.masterdata.entity.PrescriptionModel;
import hospital.masterdata.mapper.PrescriptionModelMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
@Service
public class PrescriptionModelServiceImpl implements PrescriptionModelService {
    @Resource
    private PrescriptionModelMapper prescriptionModelMapper;
    @Override
    public List<PrescriptionModel> findAll() {
        return prescriptionModelMapper.findAll();
    }
    @Override
    public List<PrescriptionModel> findAllBy(String modelName, String modelPower, String prescriptionType) {
        return prescriptionModelMapper.findAllBy(modelName,modelPower,prescriptionType);
    }
}