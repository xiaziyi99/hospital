package hospital.masterdata.service;
import hospital.masterdata.entity.Prescription;
import hospital.masterdata.entity.PrescriptionDrugs;
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
    @Override
    public int addPrescriptionSickness(Integer prescriptionId, Integer[] sicknessId) {
        return relationMapper.addPrescriptionSickness(prescriptionId,sicknessId);
    }
    @Override
    public int addPrescriptionSurcharge(Integer prescriptionId, Integer[] surchargeId) {
        return relationMapper.addPrescriptionSurcharge(prescriptionId,surchargeId);
    }
    @Override
    public int addPrescriptionItem(Integer prescriptionId, Integer[] itemsId) {
        return relationMapper.addPrescriptionItem(prescriptionId,itemsId);
    }
    @Override
    public int addPrescriptionDrugs(PrescriptionDrugs prescriptionDrugs) {
        return relationMapper.addPrescriptionDrugs(prescriptionDrugs);
    }
    @Override
    public int addPrescription(Prescription prescription) {
        return relationMapper.addPrescription(prescription);
    }
}
