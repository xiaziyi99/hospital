package hospital.prescription.controller;
import hospital.common.entity.Prescription;
import hospital.common.entity.PrescriptionDrugs;
import hospital.common.http.HttpClientHelper;
import hospital.common.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "就诊保存模块")
@RestController
@Slf4j
@RequestMapping("/api/add")
public class PrescriptionAddController {
    @Value("${server.medicine.url}")
    private String serverMedicineUrl;
    @Value("${server.masterdata.url}")
    private String serverMasterdataUrl;
    @Resource
    private HttpClientHelper httpClientHelper;

    private static final String CURRENT_SERVER_URL = "http://localhost:9005";

    //处方医嘱保存接口
    @ApiOperation(value = "处方医嘱保存接口api,添加处方医嘱信息",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "处方ID",name = "prescriptionId", required = true),
            @ApiImplicitParam(value = "医嘱ID",name = "adviceId[]", required = true)
    })
    @GetMapping(value = "relation/addDoctorAdvice")
    public Response addPrescriptionDoctorAdvice(Integer prescriptionId, Integer[] adviceId) throws Exception {
        Map<String, Object> params=new HashMap<>();
        if(prescriptionId!=null) {
            params.put("prescriptionId",prescriptionId);
        }
        if(adviceId!=null) {
            params.put("adviceId",adviceId);
        }
        log.debug("params:{}", params);
        return httpClientHelper.postForResponse(serverMasterdataUrl + "/api/relation/addDoctorAdvice",params,CURRENT_SERVER_URL);
    }

    //处方疾病保存接口
    @ApiOperation(value = "处方疾病保存接口api,添加处方疾病信息",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "处方ID",name = "prescriptionId", required = true),
            @ApiImplicitParam(value = "疾病ID",name = "sicknessId[]", required = true)
    })
    @GetMapping(value = "relation/addSickness")
    public Response addPrescriptionDoctorSickness(Integer prescriptionId, Integer[] sicknessId) throws Exception {
        Map<String, Object> params=new HashMap<>();
        if(prescriptionId!=null) {
            params.put("prescriptionId",prescriptionId);
        }
        if(sicknessId!=null) {
            params.put("sicknessId",sicknessId);
        }
        log.debug("params:{}", params);
        return httpClientHelper.postForResponse(serverMasterdataUrl + "/api/relation/addSickness",params);
    }

    //处方附加费用保存接口
    @ApiOperation(value = "处方附加费用接口api,添加处方附加费用信息",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "处方ID",name = "prescriptionId", required = true),
            @ApiImplicitParam(value = "附加费用ID",name = "surchargeId[]", required = true)
    })
    @GetMapping(value = "relation/addSurcharge")
    public Response addPrescriptionSurcharge(Integer prescriptionId, Integer[] surchargeId) throws Exception {
        Map<String, Object> params=new HashMap<>();
        if(prescriptionId!=null) {
            params.put("prescriptionId",prescriptionId);
        }
        if(surchargeId!=null) {
            params.put("surchargeId",surchargeId);
        }
        log.debug("params:{}", params);
        return httpClientHelper.postForResponse(serverMasterdataUrl + "/api/relation/addSurcharge",params);
    }

    //处方检查项目保存接口
    @ApiOperation(value = "处方检查项目保存接口api,添加处方检查项目信息",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "处方ID",name = "prescriptionId", required = true),
            @ApiImplicitParam(value = "检查项目ID",name = "itemId[]", required = true)
    })
    @GetMapping(value = "relation/addItem")
    public Response addPrescriptionItem(Integer prescriptionId, Integer[] itemId) throws Exception {
        Map<String, Object> params=new HashMap<>();
        if(prescriptionId!=null) {
            params.put("prescriptionId",prescriptionId);
        }
        if(itemId!=null) {
            params.put("itemId",itemId);
        }
        log.debug("params:{}", params);
        return httpClientHelper.postForResponse(serverMasterdataUrl + "/api/relation/addItem",params);
    }

    //处方药品保存接口
    @ApiOperation(value = "处方药品保存接口api,添加处方药品信息",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "处方ID",name = "prescriptionId", required = true),
            @ApiImplicitParam(value = "药品ID",name = "drugs = Id", required = true)
    })
    @GetMapping(value = "relation/addDrugs")
    public Response addPrescriptionDrugs(Integer prescriptionId, PrescriptionDrugs prescriptionDrugs) throws Exception {
        Map<String, Object> params=new HashMap<>();
        if(prescriptionId!=null) {
            params.put("prescriptionId",prescriptionId);
        }
        if(prescriptionDrugs!=null) {
            params.put("prescriptionDrugs",prescriptionDrugs);
        }
        log.debug("params:{}", params);
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/relation/addDrugs"+ params);
    }
    //处方保存接口
    @ApiOperation(value = "处方疾病保存接口api,添加处方信息",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "处方ID",name = "prescriptionId", required = true),
            @ApiImplicitParam(value = "医嘱ID",name = "adviceId", required = true)
    })
    @GetMapping(value = "relation/addPrescription")
    public Response addPrescription(Integer prescriptionId, Prescription prescription) throws Exception {
        Map<String, Object> params=new HashMap<>();
        if(prescriptionId!=null) {
            params.put("prescriptionId",prescriptionId);
        }
        if(prescription!=null) {
            params.put("prescription",prescription);
        }
        log.debug("params:{}", params);
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/relation/addPrescription"+ params);
    }
}
