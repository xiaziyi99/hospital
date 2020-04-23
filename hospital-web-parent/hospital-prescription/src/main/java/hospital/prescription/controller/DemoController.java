package hospital.prescription.controller;
import hospital.prescription.report.CreateReport;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hospital.common.http.HttpClientHelper;
import hospital.common.response.Response;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * api调用demo
 * @author Administrator
 *
 */
@Api
@RestController
public class DemoController {
	@Value("${server.medicine.url}")
	private String serverMedicineUrl;
	@Value("${server.masterdata.url}")
	private String serverMasterdataUrl;

	@Autowired private HttpClientHelper httpClientHelper;

	@GetMapping("report")
	public void report(HttpServletResponse response) {
		CreateReport report = new CreateReport();
		List<String> headList = Arrays.asList("序号","单号","药品名称","数量","采购成本");
		List<List<String>> dataList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			dataList.add(Arrays.asList("" + i,"1000" + i,"药品" + i,"" +i, "2.55"));
		}
		report.createWorkBook(null, "a", headList, dataList, response, "报表测试.xls");
	}
	@GetMapping("api/masterdata/users")
	public Response getMasterdataUsers() {
		return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/masterdata/users");
	}

	@GetMapping("api/medicine/users")
	public Response getUsers() {
		return httpClientHelper.getForResponse(serverMedicineUrl + "/api/medicine/users");
	}
}
