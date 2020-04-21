package hospital.common.entity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
/**
 * 患者信息表
 */
@Data
@Builder
@ToString
public class Patient {
    private Integer id;
    private String patientNo;
    private String patientName;
    private String gender;
    private Integer age;
    private String phoneNumber;
    private String membershipLevel;
    private Date createDate;
    private String createBy;
}