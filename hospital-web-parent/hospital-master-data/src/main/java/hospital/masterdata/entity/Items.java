package hospital.masterdata.entity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
/**
 * 检查项目表
 */
@Data
@Builder
@ToString
public class Items {
    private Integer id;
    private String itemsNo;
    private String itemsName;
    private String itemsType;
    private String invoice;
    private Float retail;
    private Float costPrice;
    private String unit;
    private String itemsStatus;
    private Date createDate;
}