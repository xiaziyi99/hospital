package hospital.masterdata.mapper;
import hospital.common.entity.Sickness;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface SicknessMapper {
    List<Sickness> findAll();
    List<Sickness> findAllBy(@Param("sicknessName") String sicknessName);
}