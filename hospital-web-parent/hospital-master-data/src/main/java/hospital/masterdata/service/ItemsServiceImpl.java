package hospital.masterdata.service;
import hospital.common.entity.Items;
import hospital.masterdata.mapper.ItemsMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
@Service
public class ItemsServiceImpl implements ItemsService {
    @Resource
    private ItemsMapper itemsMapper;
    @Override
    public List<Items> findAll() {
        return itemsMapper.findAll();
    }
    @Override
    public List<Items> findAllBy(String itemsNo, String itemsName, String itemsStatus) {
        return itemsMapper.findAllBy(itemsNo,itemsName,itemsStatus);
    }
}