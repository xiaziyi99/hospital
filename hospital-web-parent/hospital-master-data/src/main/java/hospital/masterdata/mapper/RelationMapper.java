package hospital.masterdata.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RelationMapper {
    int addPrescriptionDoctorAdvice(@Param("prescriptionId")Integer prescriptionId, @Param("adviceId")Integer[] adviceId);
}
