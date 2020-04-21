package hospital.masterdata.entity;
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
public class Prescription {
    private Integer id;
    private Integer doctorId;
    private Integer patientId;
    private Integer sicknessId;
    private Integer receptionType;
    private Date createDate;
}