package hospital.masterdata.mapper;
import hospital.common.entity.DoctorAdvice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface DoctorAdviceMapper {
    List<DoctorAdvice> findAll();
    List<DoctorAdvice> findAllBy(@Param("adviceInfo") String adviceInfo);
}