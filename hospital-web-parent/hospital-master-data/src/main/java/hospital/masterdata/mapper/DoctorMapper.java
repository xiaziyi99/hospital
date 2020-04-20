package hospital.masterdata.mapper;
import hospital.masterdata.entity.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface DoctorMapper {
    List<Doctor> findAll();
    List<Doctor> findAllBy(@Param("departmentName") String departmentName, @Param("doctorName") String doctorName);
}