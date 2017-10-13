package com.maiyuan.test.webapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maiyuan.test.RabitMQ.HelloSender;
import com.maiyuan.test.entity.ReceiveReport;
import com.maiyuan.test.entity.SendReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/7/19.
 */
@Controller
@RequestMapping(value = "/recharge")
public class MyuanController {
    private static Logger logger = LoggerFactory.getLogger(MyuanController.class);

    @Autowired
    private HelloSender helloSender;

    @RequestMapping()
    @ResponseBody
    public String receive(HttpServletRequest request) {
        System.out.println("接受订单时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        ReceiveReport receiveReport = new ReceiveReport();
        receiveReport.setMobile(request.getParameter("username"));
        receiveReport.setAccount(request.getParameter("username"));
        receiveReport.setAction(request.getParameter("action"));
        receiveReport.setPackagez(request.getParameter("package"));
        receiveReport.setSign(request.getParameter("sign"));
        receiveReport.setV(request.getParameter("v"));
        receiveReport.setOutTradeNo(request.getParameter("outTradeNo"));
        String TaskID = getRandom(8);
        Map map = new HashMap();
        System.out.println("接受充值请求:" + receiveReport.toString());
        map.put("TaskID", receiveReport.getOutTradeNo());
        map.put("Code", 0);
        map.put("Message", "充值成功");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try {
            json = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            System.out.println("充值返回数据异常");
            e.printStackTrace();
        }
        //推送功能
        List<SendReport> list = new ArrayList<SendReport>();
        SendReport sendReport = new SendReport();
        sendReport.setTaskID(TaskID);
        sendReport.setMobile(receiveReport.getMobile());
        sendReport.setOutTradeNo(receiveReport.getOutTradeNo());
        sendReport.setReportCode("充值成功");
        sendReport.setReportTime(new Date().toString());
        sendReport.setStatus("4");
        list.add(sendReport);
        String msg="";
        try {
            msg= objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
       helloSender.send(msg);
       //request.setAttribute("li",list);
        System.out.println("返回请求");
        return json;
    }

    @RequestMapping(value = "/merge")
    @ResponseBody
    public String up(HttpServletRequest request) {
        //callback/my   "{\"status\":\"100001\",\"message\":\"操作执行成功\",\"serial\":\""+random+"\"}"
        logger.info("接受充值请求号码{}",request.getParameter("mobile"));
        String random=getRandom(28);
        System.out.println(request.getHeader("accept"));
        helloSender.send("{\"status\":\"20000\",\"message\":\"成功\",\"serial\":\""+random+"\"}");
        return "{\"status\":\"10000\",\"message\":\"操作执行成功\",\"serial\":\""+random+"\"}";
    }


    @RequestMapping("/callback/mye")
    @ResponseBody
    public String downCallback(HttpServletRequest request){
        return "ok";
    }

    @RequestMapping("/callback/stream")
    public String getStream(HttpServletRequest request,HttpServletResponse res){
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        String str=request.getHeader("user-agent");
        System.out.println(str.toLowerCase().contains("msie"));
        try {
            File file= new File("C:\\Users\\Administrator.admin-PC\\Desktop\\测试.txt");
            res.setHeader("content-length",String.valueOf(file.length()));
            res.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(file.getName(),"utf-8"));
            FileCopyUtils.copy(new FileInputStream(file),res.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "callback/upload",method = RequestMethod.GET)
    public String toOutStream(){
        return "index";
    }

    @RequestMapping(value = "callback/upload",method = RequestMethod.POST)
    @ResponseBody
    public String outStream(@RequestParam(value = "file")MultipartFile file,HttpServletRequest request){
        String suffix= request.getParameter("imagetype");
        SimpleDateFormat df=new SimpleDateFormat("MMdd");
        String date=df.format(new Date());
        StringBuffer sb=new StringBuffer();
        String newSuffix= sb.append(getRandom(6)).append("_").append(date).append(suffix).toString();
        try {
            file.transferTo(new File("D:\\upload\\"+newSuffix));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }

    private static String getRandom(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
