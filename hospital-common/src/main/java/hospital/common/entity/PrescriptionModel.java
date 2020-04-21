package hospital.common.entity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
/**
 * 处方模板表
 */
@Data
@Builder
@ToString
public class PrescriptionModel {
    private Integer id;
    private String modelNo;
    private String modelName;
    private String prescriptionType;
    private String diagnosis;
    private String modelPower;
    private Date createDate;
    private String createBy;
}