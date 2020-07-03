package com.ht.web.lx;

import com.github.pagehelper.PageInfo;
import com.ht.pojo.MachineRoom;
import com.ht.service.businessService.lx.MachineRoomBusinessService;
import com.ht.service.dataService.MachineRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MachineRoomController {

    @Autowired
    private MachineRoomService machineRoomService;

    @Autowired
    private MachineRoomBusinessService machineRoomBusinessService;

    /**
     * 查询，分页
     *
     * @param Filename
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("QuymachineRoomPage")
    @ResponseBody
    public Map<String, Object> QuymachineRoomPage(String Filename, Integer page, Integer limit) {
        if (page == null || page == 0) {
            page = 1;
        }

        PageInfo<MachineRoom> machineRoomPageInfo = machineRoomBusinessService.QuyMachineRoomPage(Filename, page, limit);

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", machineRoomPageInfo.getTotal());
        map.put("data", machineRoomPageInfo.getList());
        return map;
    }

    /**
     * 上传文档
     *
     * @param file
     * @param request
     * @return
     * @throws FileNotFoundException
     */
    @RequestMapping(value = "UpdateMachineRoomFlie", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> UpdateMachineRoomFlie(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws FileNotFoundException {

        //返回json
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "error");
        map.put("data", "");

        if (file.isEmpty()) {
            map.put("msg", "error-file-null");
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);

        String path = ResourceUtils.getURL("classpath:").getPath() + "static/file";
        String realPath = path.replace('/', '\\').substring(1, path.length());

        File dest = new File(realPath + "/" + fileName);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            map.put("msg", "file_yes");
            map.put("data", fileName);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

        return map;
    }

    /**
     * 新增
     *
     * @param machineRoom
     * @return
     */
    @RequestMapping("AddMachineRoom")
    @ResponseBody
    public String AddMachineRoom(MachineRoom machineRoom) {
        Integer end = machineRoomBusinessService.AddMachineRoom(machineRoom);
        if (end >= 1) {
            return "yes";
        }
        return "no";
    }

    /**
     * 跳转
     *
     * @param model
     * @param mid
     * @return
     */
    @RequestMapping("GetMachineRoom")
    public String GetMachineRoom(Model model, Integer mid) {
        model.addAttribute("mid", mid);
        return "UpdateMachineRoomReferenceSpecification";
    }

    /**
     * 修改前查询出来
     *
     * @param machineRoom
     * @return
     */
    @RequestMapping("UpeMachineRoomQuy")
    @ResponseBody
    public MachineRoom UpeMachineRoomQuy(MachineRoom machineRoom) {
        return machineRoomBusinessService.UpdateMachineRoomQuy(machineRoom);
    }

    /**
     * 修改
     *
     * @param machineRoom
     * @return
     */
    @RequestMapping("UpeMachineRoom")
    @ResponseBody
    public String UpeMachineRoom(MachineRoom machineRoom) {
        Integer end = machineRoomBusinessService.UpdateMachineRoom(machineRoom);
        if (end >= 1) {
            return "yes";
        }
        return "no";
    }

    /**
     * 删除
     *
     * @param machineRoom
     * @return
     */
    @RequestMapping("DelMachineRoom")
    @ResponseBody
    public String DelMachineRoom(MachineRoom machineRoom) {
        Integer end = machineRoomBusinessService.DelMachineRoom(machineRoom);
        if (end >= 1) {
            return "yes";
        }
        return "no";
    }

}
