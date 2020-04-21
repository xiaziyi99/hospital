package hospital.common.entity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * 处方模板表
 */
@Data
@Builder
@ToString
public class PrescriptionDrugs {
    private Integer id;
    private Integer drugsId;
    private Integer prescriptionId;
    private String singleDose;
    private String usage;
    private String frequency;
    private Integer days;
}