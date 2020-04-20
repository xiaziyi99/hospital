package hospital.masterdata.mapper;
import hospital.masterdata.entity.Items;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface ItemsMapper {
    List<Items> findAll();
    List<Items> findAllBy( @Param("itemsNo") String itemsNo,@Param("itemsName") String itemsName,@Param("itemsStatus")String itemsStatus);
}