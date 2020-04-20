package hospital.medicine.service;
import hospital.medicine.entity.Medicine;
import hospital.medicine.mapper.MedicineMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MedicineServiceImpl implements MedicineService {
    @Resource
    private MedicineMapper medicineMapper;
    @Override
    public List<Medicine> findAll() {
        return medicineMapper.findAll();
    }
    @Override
    public List<Medicine> findAllBy(Integer typeId, String name) {
        return medicineMapper.findAllBy(typeId, name);
    }
}