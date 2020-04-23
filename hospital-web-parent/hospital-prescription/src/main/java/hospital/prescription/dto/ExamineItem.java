package hospital.prescription.dto;

import lombok.Data;
import lombok.ToString;

//检查项目
@Data@ToString
public class ExamineItem {
	private String examineItemId;
	private String examineItemPrice;
}