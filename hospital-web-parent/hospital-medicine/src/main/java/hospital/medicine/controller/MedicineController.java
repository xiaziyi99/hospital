package hospital.medicine.controller;
import hospital.common.response.Response;
import hospital.common.response.ResponseEnum;
import hospital.medicine.entity.Medicine;
import hospital.medicine.service.MedicineService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@Api
@RestController
@RequestMapping("/api/medicines")
public class MedicineController {
    @Autowired private MedicineService medicineService;
    @GetMapping("")
    public Response findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Medicine> list = medicineService.findAll();
        PageInfo<Medicine> pageInfo = new PageInfo<>(list);
        return new Response(ResponseEnum.SUCCESS).setResponseBody(pageInfo);
    }
    @RequestMapping(value = "/findBy",method = {RequestMethod.GET,RequestMethod.POST})
    public Response findBy(Integer pageNum, Integer pageSize, Integer typeId, String name) {
        PageHelper.startPage(pageNum,pageSize);
        List<Medicine> list = medicineService.findAllBy(typeId, name);
        PageInfo<Medicine> pageInfo = new PageInfo<>(list);
        return new Response(ResponseEnum.SUCCESS).setResponseBody(pageInfo);
    }
}
