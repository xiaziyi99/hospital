package hospital.medicine.service;
import hospital.medicine.entity.Medicine;

import java.util.List;
public interface MedicineService {
    List<Medicine> findAll();
    List<Medicine> findAllBy(Integer typeId, String name);
}
