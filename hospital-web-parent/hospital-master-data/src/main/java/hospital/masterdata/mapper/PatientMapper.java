package hospital.masterdata.mapper;
import hospital.masterdata.entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface PatientMapper {
    List<Patient> findAll();
    List<Patient> findAllBy(@Param("membershipLevel") String membershipLevel, @Param("createDate") String createDate,@Param("patientName") String patientName, @Param("phoneNumber") String phoneNumber);
}