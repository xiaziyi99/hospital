package hospital.prescription.controller;
import hospital.common.http.HttpClientHelper;
import hospital.common.response.Response;
import hospital.masterdata.entity.Surcharge;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
@Api
@RestController
@Slf4j
@RequestMapping("/api")
public class PrescriptionController {
    @Value("${server.medicine.url}")
    private String serverMedicineUrl;
    @Value("${server.masterdata.url}")
    private String serverMasterdataUrl;
    @Resource
    private HttpClientHelper httpClientHelper;

    //药品查询接口
    @ApiOperation(value = "调用药品模块api,分页查询药品列表",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码，查询第几页数据,必填",name = "pageNum", required = true),
            @ApiImplicitParam(value = "每页显示几条,必填",name = "pageSize", required = true)
    })
    @GetMapping("getMedicines")
    public Response getMedicines(Integer pageNum, Integer pageSize) {
        return httpClientHelper.getForResponse(serverMedicineUrl + "/api/medicines?pageNum="+pageNum+"&pageSize="+pageSize);
    }
    @ApiOperation(value = "调用药品模块api,分页查询药品列表",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码，查询第几页数据,必填",name = "pageNum", required = true),
            @ApiImplicitParam(value = "每页显示几条,必填",name = "pageSize", required = true),
            @ApiImplicitParam(value = "药品分类ID",name = "typeId"),
            @ApiImplicitParam(value = "药品名称，模糊匹配",name = "name")
    })
    @GetMapping(value = "getMedicines/findBy")
    public Response getMedicines(Integer pageNum, Integer pageSize, Integer typeId, String name) throws Exception {
        if(pageNum == null) pageNum = 1;
        if(pageSize == null) pageSize = 5;
        StringBuffer buffer = new StringBuffer("?").append("pageNum=").append(pageNum).append("&pageSize=").append(pageSize);
        if(typeId!=null) {
            buffer.append("&typeId=").append(typeId);
        }
        if(!StringUtils.isEmpty(name)) {
            buffer.append("&name=").append(URLEncoder.encode(name, "UTF-8"));
        }
        log.debug("params:{}", buffer);
        return httpClientHelper.getForResponse(serverMedicineUrl + "/api/medicines/findBy"+ buffer);
    }

    //员工查询接口
    @ApiOperation(value = "调用员工模块api,分页查询员工列表",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码，查询第几页数据,必填",name = "pageNum", required = true),
            @ApiImplicitParam(value = "每页显示几条,必填",name = "pageSize", required = true)
    })
    @GetMapping("getDoctor")
    public Response getDoctor(Integer pageNum, Integer pageSize) {
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/doctor?pageNum="+pageNum+"&pageSize="+pageSize);
    }
    @ApiOperation(value = "调用员工模块api,分页查询员工列表",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码，查询第几页数据,必填",name = "pageNum", required = true),
            @ApiImplicitParam(value = "每页显示几条,必填",name = "pageSize", required = true),
            @ApiImplicitParam(value = "员工所属科室",name = "departmentName"),
            @ApiImplicitParam(value = "员工名称，模糊匹配",name = "doctorName")
    })
    @GetMapping(value = "getDoctor/findBy")
    public Response getDoctor(Integer pageNum, Integer pageSize, String departmentName, String doctorName) throws Exception {
        if(pageNum == null) pageNum = 1;
        if(pageSize == null) pageSize = 5;
        StringBuffer buffer = new StringBuffer("?").append("pageNum=").append(pageNum).append("&pageSize=").append(pageSize);
        if(departmentName!=null) {
            buffer.append("&departmentName=").append(departmentName);
        }
        if(!StringUtils.isEmpty(doctorName)) {
            buffer.append("&doctorName=").append(URLEncoder.encode(doctorName, "UTF-8"));
        }
        log.debug("params:{}", buffer);
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/doctor/findBy"+ buffer);
    }

    //处方模板和详情查询接口
    @ApiOperation(value = "调用处方模板模块api,分页查询处方模板列表",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码，查询第几页数据,必填",name = "pageNum", required = true),
            @ApiImplicitParam(value = "每页显示几条,必填",name = "pageSize", required = true)
    })
    @GetMapping("getPrescriptionModel")
    public Response getPrescriptionModel(Integer pageNum, Integer pageSize) {
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/prescriptionModel?pageNum="+pageNum+"&pageSize="+pageSize);
    }
    @ApiOperation(value = "调用处方模板模块api,分页查询处方模板列表",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码，查询第几页数据,必填",name = "pageNum", required = true),
            @ApiImplicitParam(value = "每页显示几条,必填",name = "pageSize", required = true),
            @ApiImplicitParam(value = "处方类别",name = "prescriptionType"),
            @ApiImplicitParam(value = "模板权限",name = "modelPower"),
            @ApiImplicitParam(value = "处方模板名称，模糊匹配",name = "modelName")
    })
    @GetMapping(value = "getPrescriptionModel/findBy")
    public Response getPrescriptionModel(Integer pageNum, Integer pageSize, String modelName, String modelPower, String prescriptionType) throws Exception {
        if(pageNum == null) pageNum = 1;
        if(pageSize == null) pageSize = 5;
        StringBuffer buffer = new StringBuffer("?").append("pageNum=").append(pageNum).append("&pageSize=").append(pageSize);
        if(prescriptionType!=null) {
            buffer.append("&prescriptionType=").append(prescriptionType);
        }
        if(modelPower!=null) {
            buffer.append("&modelPower=").append(modelPower);
        }
        if(!StringUtils.isEmpty(modelName)) {
            buffer.append("&modelName=").append(URLEncoder.encode(modelName, "UTF-8"));
        }
        log.debug("params:{}", buffer);
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/prescriptionModel/findBy"+ buffer);
    }

    //疾病名称查询接口
    @ApiOperation(value = "调用疾病模块api,分页查询疾病列表",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码，查询第几页数据,必填",name = "pageNum", required = true),
            @ApiImplicitParam(value = "每页显示几条,必填",name = "pageSize", required = true)
    })
    @GetMapping("getSickness")
    public Response getSick(Integer pageNum, Integer pageSize) {
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/sickness?pageNum="+pageNum+"&pageSize="+pageSize);
    }
    @ApiOperation(value = "调用疾病模块api,分页查询疾病列表",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码，查询第几页数据,必填",name = "pageNum", required = true),
            @ApiImplicitParam(value = "每页显示几条,必填",name = "pageSize", required = true),
            @ApiImplicitParam(value = "疾病名称，模糊匹配",name = "sicknessName")
    })
    @GetMapping(value = "getSickness/findBy")
    public Response getSickness(Integer pageNum, Integer pageSize, String sicknessName) throws Exception {
        if(pageNum == null) pageNum = 1;
        if(pageSize == null) pageSize = 5;
        StringBuffer buffer = new StringBuffer("?").append("pageNum=").append(pageNum).append("&pageSize=").append(pageSize);
        if(!StringUtils.isEmpty(sicknessName)) {
            buffer.append("&sicknessName=").append(URLEncoder.encode(sicknessName, "UTF-8"));
        }
        log.debug("params:{}", buffer);
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/sickness/findBy"+ buffer);
    }

    //医嘱查询接口
    @ApiOperation(value = "调用医嘱模块api,分页查询医嘱列表",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码，查询第几页数据,必填",name = "pageNum", required = true),
            @ApiImplicitParam(value = "每页显示几条,必填",name = "pageSize", required = true)
    })
    @GetMapping("getDoctorAdvice")
    public Response getDoctorAdvice(Integer pageNum, Integer pageSize) {
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/doctorAdvice?pageNum="+pageNum+"&pageSize="+pageSize);
    }
    @ApiOperation(value = "调用医嘱模块api,分页查询医嘱列表",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码，查询第几页数据,必填",name = "pageNum", required = true),
            @ApiImplicitParam(value = "每页显示几条,必填",name = "pageSize", required = true),
            @ApiImplicitParam(value = "医嘱名称，模糊匹配",name = "adviceInfo"),
    })
    @GetMapping(value = "getDoctorAdvice/findBy")
    public Response getDoctorAdvice(Integer pageNum, Integer pageSize, String adviceInfo) throws Exception {
        if(pageNum == null) pageNum = 1;
        if(pageSize == null) pageSize = 5;
        StringBuffer buffer = new StringBuffer("?").append("pageNum=").append(pageNum).append("&pageSize=").append(pageSize);
        if(!StringUtils.isEmpty(adviceInfo)) {
            buffer.append("&adviceInfo=").append(URLEncoder.encode(adviceInfo, "UTF-8"));
        }
        log.debug("params:{}", buffer);
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/doctorAdvice/findBy"+ buffer);
    }

    //附加费用查询接口
    @ApiOperation(value = "调用附加费用模块api,分页查询附加费用列表",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码，查询第几页数据,必填",name = "pageNum", required = true),
            @ApiImplicitParam(value = "每页显示几条,必填",name = "pageSize", required = true)
    })
    @GetMapping("getSurcharge")
    public Response getSurcharge(Integer pageNum, Integer pageSize) {
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/doctorAdvice?pageNum="+pageNum+"&pageSize="+pageSize);
    }
    @ApiOperation(value = "调用附加费用模块api,分页查询附加费用列表",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码，查询第几页数据,必填",name = "pageNum", required = true),
            @ApiImplicitParam(value = "每页显示几条,必填",name = "pageSize", required = true),
            @ApiImplicitParam(value = "处方类别",name = "surchargeType"),
            @ApiImplicitParam(value = "附加费用名称，模糊匹配",name = "surchargeName"),
    })
    @GetMapping(value = "getSurcharge/findBy")
    public Response getSurcharge(Integer pageNum, Integer pageSize, String surchargeType, String surchargeName) throws Exception {
        if(pageNum == null) pageNum = 1;
        if(pageSize == null) pageSize = 5;
        StringBuffer buffer = new StringBuffer("?").append("pageNum=").append(pageNum).append("&pageSize=").append(pageSize);
        if(surchargeType!=null) {
            buffer.append("&surchargeType=").append(surchargeType);
        }
        if(!StringUtils.isEmpty(surchargeName)) {
            buffer.append("&surchargeName=").append(URLEncoder.encode(surchargeName, "UTF-8"));
        }
        log.debug("params:{}", buffer);
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/surcharge/findBy"+ buffer);
    }

    //检查项目查询接口
    @ApiOperation(value = "调用检查项目模块api,分页查询检查项目列表",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码，查询第几页数据,必填",name = "pageNum", required = true),
            @ApiImplicitParam(value = "每页显示几条,必填",name = "pageSize", required = true)
    })
    @GetMapping("getItems")
    public Response getItems(Integer pageNum, Integer pageSize) {
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/items?pageNum="+pageNum+"&pageSize="+pageSize);
    }
    @ApiOperation(value = "调用检查项目模块api,分页查询检查项目列表",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码，查询第几页数据,必填",name = "pageNum", required = true),
            @ApiImplicitParam(value = "每页显示几条,必填",name = "pageSize", required = true),
            @ApiImplicitParam(value = "项目状态",name = "itemsStatus"),
            @ApiImplicitParam(value = "项目名称，模糊匹配",name = "itemsName"),
            @ApiImplicitParam(value = "项目编号，模糊匹配",name = "itemsNo")
    })
    @GetMapping(value = "getItems/findBy")
    public Response getItems(Integer pageNum, Integer pageSize, String itemsNo, String itemsName, String itemsStatus) throws Exception {
        if(pageNum == null) pageNum = 1;
        if(pageSize == null) pageSize = 5;
        StringBuffer buffer = new StringBuffer("?").append("pageNum=").append(pageNum).append("&pageSize=").append(pageSize);
        if(itemsStatus!=null) {
            buffer.append("&itemsStatus=").append(itemsStatus);
        }
        if(itemsNo!=null) {
            buffer.append("&itemsNo=").append(itemsNo);
        }
        if(!StringUtils.isEmpty(itemsName)) {
            buffer.append("&itemsName=").append(URLEncoder.encode(itemsName, "UTF-8"));
        }
        log.debug("params:{}", buffer);
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/items/findBy"+ buffer);
    }

    //患者查询接口
    @ApiOperation(value = "调用患者模块api,分页查询患者列表",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码，查询第几页数据,必填",name = "pageNum", required = true),
            @ApiImplicitParam(value = "每页显示几条,必填",name = "pageSize", required = true)
    })
    @GetMapping("getPatient")
    public Response getPatient(Integer pageNum, Integer pageSize) {
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/patient?pageNum="+pageNum+"&pageSize="+pageSize);
    }
    @ApiOperation(value = "调用患者模块api,分页查询患者列表",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码，查询第几页数据,必填",name = "pageNum", required = true),
            @ApiImplicitParam(value = "每页显示几条,必填",name = "pageSize", required = true),
            @ApiImplicitParam(value = "员工所属科室",name = "departmentName"),
            @ApiImplicitParam(value = "患者名称，模糊匹配",name = "patientName")
    })
    @GetMapping(value = "getPatient/findBy")
    public Response getPatient(Integer pageNum, Integer pageSize, String membershipLevel, String createDate, String patientName, String phoneNumber) throws Exception {
        if(pageNum == null) pageNum = 1;
        if(pageSize == null) pageSize = 5;
        StringBuffer buffer = new StringBuffer("?").append("pageNum=").append(pageNum).append("&pageSize=").append(pageSize);
        if(membershipLevel!=null) {
            buffer.append("&membershipLevel=").append(membershipLevel);
        }
        if(createDate!=null) {
            buffer.append("&departmentName=").append(createDate);
        }
        if(!StringUtils.isEmpty(patientName)) {
            buffer.append("&patientName=").append(URLEncoder.encode(patientName, "UTF-8"));
        }
        if(phoneNumber!=null) {
            buffer.append("&phoneNumber=").append(phoneNumber);
        }
        log.debug("params:{}", buffer);
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/patient/findBy"+ buffer);
    }




    //处方医嘱保存接口
    @ApiOperation(value = "处方医嘱保存接口api,添加处方医嘱",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "处方ID",name = "prescriptionId", required = true),
            @ApiImplicitParam(value = "医嘱ID",name = "adviceId", required = true)
    })
    @PostMapping(value = "relation/addDoctorAdvice")
    public Response addPrescriptionDoctorAdvice(Integer prescriptionId, Integer[] adviceId) throws Exception {
        StringBuffer buffer = new StringBuffer("?");
        if(prescriptionId!=null) {
            buffer.append("&prescriptionId=").append(prescriptionId);
        }
        if(adviceId!=null) {
            buffer.append("&adviceId=").append(adviceId);
        }
        log.debug("params:{}", buffer);
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/relation/addDoctorAdvice"+ buffer);
    }

    //处方疾病保存接口
    @ApiOperation(value = "处方疾病保存接口api,添加处方疾病",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "处方ID",name = "prescriptionId", required = true),
            @ApiImplicitParam(value = "疾病ID",name = "sicknessId", required = true)
    })
    @PostMapping(value = "relation/addSickness")
    public Response addPrescriptionDoctorSickness(Integer prescriptionId, Integer[] sicknessId) throws Exception {
        StringBuffer buffer = new StringBuffer("?");
        if(prescriptionId!=null) {
            buffer.append("&prescriptionId=").append(prescriptionId);
        }
        if(sicknessId!=null) {
            buffer.append("&sicknessId=").append(sicknessId);
        }
        log.debug("params:{}", buffer);
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/relation/addSickness"+ buffer);
    }

    //处方附加费用保存接口
    @ApiOperation(value = "处方附加费用接口api,添加处方附加费用",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "处方ID",name = "prescriptionId", required = true),
            @ApiImplicitParam(value = "附加费用ID",name = "surchargeId", required = true)
    })
    @PostMapping(value = "relation/addSurcharge")
    public Response addPrescriptionSurcharge(Integer prescriptionId, Integer[] surchargeId) throws Exception {
        StringBuffer buffer = new StringBuffer("?");
        if(prescriptionId!=null) {
            buffer.append("&prescriptionId=").append(prescriptionId);
        }
        if(surchargeId!=null) {
            buffer.append("&surchargeId=").append(surchargeId);
        }
        log.debug("params:{}", buffer);
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/relation/addSurcharge"+ buffer);
    }

    //处方检查项目保存接口
    @ApiOperation(value = "处方检查项目保存接口api,添加处方检查项目",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "处方ID",name = "prescriptionId", required = true),
            @ApiImplicitParam(value = "检查项目ID",name = "itemId", required = true)
    })
    @PostMapping(value = "relation/addItem")
    public Response addPrescriptionItem(Integer prescriptionId, Integer[] itemId) throws Exception {
        StringBuffer buffer = new StringBuffer("?");
        if(prescriptionId!=null) {
            buffer.append("&prescriptionId=").append(prescriptionId);
        }
        if(itemId!=null) {
            buffer.append("&itemId=").append(itemId);
        }
        log.debug("params:{}", buffer);
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/relation/addItem"+ buffer);
    }

/*    //处方药品保存接口
    @ApiOperation(value = "处方药品保存接口api,添加处方药品",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "处方ID",name = "prescriptionId", required = true),
            @ApiImplicitParam(value = "药品ID",name = "drugs = Id", required = true)
    })
    @PostMapping(value = "relation/addDrugs")
    public Response addPrescriptionDrugs(Integer prescriptionId, PrescriptionDrugs prescriptionDrugs) throws Exception {
        StringBuffer buffer = new StringBuffer("?");
        if(prescriptionId!=null) {
            buffer.append("&prescriptionId=").append(prescriptionId);
        }
        if(sicknessId!=null) {
            buffer.append("&sicknessId=").append(sicknessId);
        }
        log.debug("params:{}", buffer);
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/relation/addDrugs"+ buffer);
    }
    //处方保存接口
    @ApiOperation(value = "处方疾病保存接口api,添加处方疾病",response = Response.class)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "处方ID",name = "prescriptionId", required = true),
            @ApiImplicitParam(value = "医嘱ID",name = "adviceId", required = true)
    })
    @PostMapping(value = "relation/addPrescription")
    public Response addPrescription(Integer prescriptionId, Prescription prescription) throws Exception {
        StringBuffer buffer = new StringBuffer("?");
        if(prescriptionId!=null) {
            buffer.append("&prescriptionId=").append(prescriptionId);
        }
        if(sicknessId!=null) {
            buffer.append("&sicknessId=").append(sicknessId);
        }
        log.debug("params:{}", buffer);
        return httpClientHelper.getForResponse(serverMasterdataUrl + "/api/relation/addPrescription"+ buffer);
    }*/

    //测试post接口失败
//    @GetMapping(value = "getMedicines/findByPost")
//    public Response findByPost(Integer pageNum, Integer pageSize, Integer typeId, String name) throws Exception {
//        if(pageNum == null) pageNum = 1;
//        if(pageSize == null) pageSize = 5;
//        Map<String, Object> params = new HashMap<>();
//        params.put("pageNum", pageNum);
//        params.put("pageSize", pageSize);
//        params.put("typeId", typeId);
//        params.put("name", name);
//        log.debug("params:{}", params);
//        return httpClientHelper.postForResponse(serverMedicineUrl + "/api/medicines/findBy", params);
//    }
}
