package hospital.masterdata.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hospital.common.response.Response;
import hospital.common.response.ResponseEnum;
import hospital.masterdata.entity.Patient;
import hospital.masterdata.service.PatientService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
@Api
@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Resource
    private PatientService patientService;
    @GetMapping("")
    public Response findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Patient> list = patientService.findAll();
        PageInfo<Patient> pageInfo = new PageInfo<>(list);
        return new Response(ResponseEnum.SUCCESS).setResponseBody(pageInfo);
    }
    @RequestMapping(value = "/findBy",method = {RequestMethod.GET,RequestMethod.POST})
    public Response findBy(Integer pageNum, Integer pageSize, String membershipLevel, String createDate, String patientName, String phoneNumber) {
        PageHelper.startPage(pageNum,pageSize);
        List<Patient> list = patientService.findAllBy(membershipLevel,createDate,patientName,phoneNumber);
        PageInfo<Patient> pageInfo = new PageInfo<>(list);
        return new Response(ResponseEnum.SUCCESS).setResponseBody(pageInfo);
    }
}
