package com.yupi.yuapiinterface.controller;

import com.yupi.yuapiclientsdk.model.User;
import com.yupi.yuapiclientsdk.utils.SignUtils;
import com.yupi.yuapicommon.service.InnerUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 名称 API
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @DubboReference
    private InnerUserService innerUserService;

    @GetMapping("/get")
    public String getNameByGet(String name, HttpServletRequest request) {
        System.out.println(request.getHeader("yupi"));
        return "GET 你的名字是" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @GetMapping("/getOne")
    public String getOne(){
        List<String> res = new ArrayList<>();
        res.add("我爱你");
        res.add("我喜欢你");
        res.add("我很喜欢你");
        res.add("我非常爱你");
        res.add("我不爱你了");
        Random random = new Random();
        int randomNumber = random.nextInt(5);
        String sentence = res.get(randomNumber);
        return sentence;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
        String source = request.getHeader("source");
        if (!source.equals("thorns")){
            throw new RuntimeException("无权限");
        }
        String accessKey = request.getHeader("accessKey");
//        数据库中查是否已分配给用户
        com.yupi.yuapicommon.model.entity.User invokeUser = innerUserService.getInvokeUser(accessKey);


        String result = invokeUser.getUserName();
        List<String> res = new ArrayList<>();
        res.add("生活不止眼前的苟且，还有诗和远方的田野");
        res.add("你的眼里有片海，却不曾为我而蓝");
        res.add("要么庸俗，要么孤独");
        res.add("要么出众，要么出局");
        res.add("以后我们去爱尔兰，听说那里不允许离婚");
        Random random = new Random();
        int randomNumber = random.nextInt(5);
        String sentence = res.get(randomNumber);
        return result+":"+"\n"+sentence;
    }
}
