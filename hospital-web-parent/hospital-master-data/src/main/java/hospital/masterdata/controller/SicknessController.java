package hospital.masterdata.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hospital.common.response.Response;
import hospital.common.response.ResponseEnum;
import hospital.common.entity.Sickness;
import hospital.masterdata.service.SicknessService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@Api
@RestController
@RequestMapping("/api/sickness")
public class SicknessController {
    @Autowired
    private SicknessService sicknessService;
    @GetMapping("")
    public Response findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Sickness> list = sicknessService.findAll();
        PageInfo<Sickness> pageInfo = new PageInfo<>(list);
        return new Response(ResponseEnum.SUCCESS).setResponseBody(pageInfo);
    }
    @RequestMapping(value = "/findBy",method = {RequestMethod.GET,RequestMethod.POST})
    public Response findBy(Integer pageNum, Integer pageSize,String sicknessName) {
        PageHelper.startPage(pageNum,pageSize);
        List<Sickness> list = sicknessService.findAllBy(sicknessName);
        PageInfo<Sickness> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo.getList().size());
        return new Response(ResponseEnum.SUCCESS).setResponseBody(pageInfo);
    }
}