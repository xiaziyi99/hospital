package hospital.common.entity;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
/**
 * 附加费用表
 */
@Data
@Builder
@ToString
public class Surcharge {
    private Integer id;
    private String surchargeName;
    private String surchargeType;
    private Float money;
    private Float costPrice;
    private Date createDate;
    private String createBy;
    private int discount;
    private int surchargeStatus;
}