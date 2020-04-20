package hospital.masterdata.entity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
/**
 * 员工基本信息表
 */
@Data
@Builder
@ToString
public class Doctor {
    private Integer id;
    private String doctorNo;
    private String doctorName;
    private String gender;
    private Integer age;
    private String phoneNumber;
    private String clinicName;
    private String departmentName;
    private String role;
    private Date createDate;
    private String createBy;
    private Integer status;
}