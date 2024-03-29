package com.qxsoft.controller;

import com.alibaba.fastjson.JSON;
import com.qxsoft.model.TbaddressEntity;
import com.qxsoft.model.TbusersEntity;
import com.qxsoft.repository.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by jz128 on 2016/3/15.
 */
@Controller
public class UserController {

    @Resource(name = "userServiceImpl")
    private UserService userService;

    //访问首页(前往登陆页面)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    //登陆成功跳转至主页面
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    //前往注册页面
    @RequestMapping(value = "/toregist", method = RequestMethod.GET)
    public String toReigist() {
        return "regist";
    }

    //用户登陆
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    int userLogin(String tbusers, HttpSession session) {
        TbusersEntity user = JSON.parseObject(tbusers, TbusersEntity.class);
        user = userService.userLogIn(user);
        int num = -1;
        if (user != null) {
            num = user.getIrolelevel();
            session.setAttribute("user", user);
        }
        return num;
    }

    //注册用户前确认用户名是否可用
    @RequestMapping(value = "/repeatName", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    String userRepeatName(String susername) {
        if (userService.getUserNameRepeat(susername)) {
            return "{\"result\":\"此用户名可用\"}";
        } else {
            return "{\"result\":\"此用户名重复,不可注册\"}";
        }
    }

    //注册用户
    @RequestMapping(value = "/regist", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    String userRegist(String tbusers, String tbaddress) {
        TbusersEntity tbusersEntity = JSON.parseObject(tbusers, TbusersEntity.class);
        TbaddressEntity tbaddressEntity = JSON.parseObject(tbaddress, TbaddressEntity.class);
        if (userService.userRegist(tbusersEntity, tbaddressEntity)) {
            return "{\"result\":\"用户注册成功\"}";
        } else {
            return "{\"result\":\"用户注册失败\"}";
        }
    }

    //上传文件
    @RequestMapping(value = "/fileUpLoad", method = RequestMethod.POST)
    //upFile1对应页面的name属性  
    /**
     * 这里这里用的是MultipartFile[] myfiles参数,所以前台就要用<input type="file" name="myfiles"/>
     * 上传文件完毕后返回给前台,0表示上传成功(后跟上传后的文件路径),1表示失败(后跟失败描述)
     */
    public @ResponseBody String addUser(@RequestParam("uname") String uname, @RequestParam MultipartFile[] upFile1, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //可以在上传文件的同时接收其它参数
        System.out.println("收到用户[" + uname + "]的文件上传请求");
        //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中
        //这里实现文件上传操作用的是commons.io.FileUtils类,它会自动判断/upload是否存在,不存在会自动创建
        String realPath = request.getSession(true).getServletContext().getRealPath("/")+"\\upload";
        //设置响应给前台内容的数据格式
        response.setContentType("text/plain; charset=UTF-8");
        //设置响应给前台内容的PrintWriter对象
        /*PrintWriter out = response.getWriter();*/
        //上传文件的原名(即上传前的文件名字)
        String originalFilename = null;
        //如果只是上传一个文件,则只需要MultipartFile类型接收文件即可,而且无需显式指定@RequestParam注解
        //如果想上传多个文件,那么这里就要用MultipartFile[]类型来接收文件,并且要指定@RequestParam注解
        //上传多个文件时,前台表单中的所有<input type="file"/>的name都应该是myfiles,否则参数里的myfiles无法获取到所有上传的文件
        for (MultipartFile upFile : upFile1) {
            if (upFile.isEmpty()) {
                //out.print("1`请选择文件后上传");
                /*out.flush();*/
                return "{\"result1\":\"1\"}";
            } else {
                originalFilename = upFile.getOriginalFilename();
                System.out.println("文件原名: " + originalFilename);
                System.out.println("文件名称: " + upFile.getName());
                System.out.println("文件长度: " + upFile.getSize());
                System.out.println("文件类型: " + upFile.getContentType());
                System.out.println("========================================");
                try {
                    //1.通过apache自带的FileUtils工具类进行复制
                    //这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
                    //此处也可以使用Spring提供的MultipartFile.transferTo(File dest)方法实现文件的上传
                    FileUtils.copyInputStreamToFile(upFile.getInputStream(), new File(realPath, originalFilename));
                    //2.通过springMVC提供的API
                    /*upFile.transferTo(new File(realPath+upFile.getOriginalFilename()));*/
                    //3.最原始的输入输出流复制文件
                } catch (IOException e) {
                    System.out.println("文件[" + originalFilename + "]上传失败,堆栈轨迹如下");
                    e.printStackTrace();
                    //out.print("1`文件上传失败，请重试！！");
                    /*out.flush();*/
                    return "{\"result1\":\"1\"}";
                }
            }
        }
        //此时在Windows下输出的是[D:\Develop\apache-tomcat-6.0.36\webapps\AjaxFileUpload\\upload\愤怒的小鸟.jpg]
        //System.out.println(realPath + "\\" + originalFilename);
        //此时在Windows下输出的是[/AjaxFileUpload/upload/愤怒的小鸟.jpg]
        //System.out.println(request.getContextPath() + "/upload/" + originalFilename);
        //不推荐返回[realPath + "\\" + originalFilename]的值
        //因为在Windows下<img src="file:///D:/aa.jpg">能被firefox显示,而<img src="D:/aa.jpg">firefox是不认的
        //out.print("0`" + request.getContextPath() + "/upload/" + originalFilename);
        /*out.flush();*/
        return "{\"result1\":\"0\"}";
    }

}
