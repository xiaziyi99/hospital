package hospital.medicine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 药品分类实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineType {
    private Integer id;
    private String name;
}
