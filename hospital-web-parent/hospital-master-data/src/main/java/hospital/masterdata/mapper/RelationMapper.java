package hospital.masterdata.mapper;
import hospital.common.entity.Prescription;
import hospital.common.entity.PrescriptionDrugs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RelationMapper {
    int addPrescriptionDoctorAdvice(@Param("prescriptionId")Integer prescriptionId, @Param("adviceId")Integer[] adviceId);
    int addPrescriptionSickness(@Param("prescriptionId")Integer prescriptionId, @Param("sicknessId")Integer[] sicknessId);
    int addPrescriptionSurcharge(@Param("prescriptionId")Integer prescriptionId, @Param("surchargeId")Integer[] surchargeId);
    int addPrescriptionItem(@Param("prescriptionId")Integer prescriptionId, @Param("itemsId")Integer[] itemsId);
    int addPrescriptionDrugs(PrescriptionDrugs prescriptionDrugs);
    int addPrescription(Prescription prescription);
}
