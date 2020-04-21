package hospital.masterdata.service;
import hospital.common.entity.Items;
import java.util.List;
public interface ItemsService {
    List<Items> findAll();
    List<Items> findAllBy(String itemsNo, String itemsName, String itemsStatus);
}