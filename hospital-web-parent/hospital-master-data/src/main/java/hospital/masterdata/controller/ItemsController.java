package hospital.masterdata.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hospital.common.response.Response;
import hospital.common.response.ResponseEnum;
import hospital.masterdata.entity.Items;
import hospital.masterdata.service.ItemsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@Api
@RestController
@RequestMapping("/api/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    @GetMapping("")
    public Response findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Items> list = itemsService.findAll();
        PageInfo<Items> pageInfo = new PageInfo<>(list);
        return new Response(ResponseEnum.SUCCESS).setResponseBody(pageInfo);
    }
    @RequestMapping(value = "/findBy",method = {RequestMethod.GET,RequestMethod.POST})
    public Response findBy(Integer pageNum, Integer pageSize,String itemsNo, String itemsName, String itemsStatus) {
        PageHelper.startPage(pageNum,pageSize);
        List<Items> list = itemsService.findAllBy(itemsNo, itemsName,itemsStatus);
        PageInfo<Items> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo.getList().size());
        return new Response(ResponseEnum.SUCCESS).setResponseBody(pageInfo);
    }
}