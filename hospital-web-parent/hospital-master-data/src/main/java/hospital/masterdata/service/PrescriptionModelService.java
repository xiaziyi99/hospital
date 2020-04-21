package hospital.masterdata.service;
import hospital.common.entity.PrescriptionModel;
import java.util.List;
public interface PrescriptionModelService {
    List<PrescriptionModel> findAll();
    List<PrescriptionModel> findAllBy(String modelName, String modelPower, String prescriptionType);
}