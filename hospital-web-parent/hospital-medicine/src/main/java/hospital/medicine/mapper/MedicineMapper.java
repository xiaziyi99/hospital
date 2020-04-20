package hospital.medicine.mapper;
import hospital.medicine.entity.Medicine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface MedicineMapper {
    List<Medicine> findAll();
    List<Medicine> findAllBy(@Param("typeId") Integer typeId, @Param("name") String name);
}