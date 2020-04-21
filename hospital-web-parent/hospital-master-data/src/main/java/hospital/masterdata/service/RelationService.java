package hospital.masterdata.service;
import hospital.masterdata.entity.Prescription;
import hospital.masterdata.entity.PrescriptionDrugs;
public interface RelationService {
    int addPrescriptionDoctorAdvice(Integer prescriptionId, Integer[] adviceId);
    int addPrescriptionSickness(Integer prescriptionId, Integer[] sicknessId);
    int addPrescriptionSurcharge(Integer prescriptionId, Integer[] surchargeId);
    int addPrescriptionItem(Integer prescriptionId, Integer[] itemsId);
    int addPrescriptionDrugs(PrescriptionDrugs prescriptionDrugs);
    int addPrescription(Prescription prescription);
}
