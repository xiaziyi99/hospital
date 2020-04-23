package hospital.prescription.dto;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data@ToString
public class DemoDto {
	private Patient patient;
	private List<Medicine> sedicines;
	private List<ExamineItem> examineItems;
}
