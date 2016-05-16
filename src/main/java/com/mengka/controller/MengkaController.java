package com.mengka.controller;

import com.alibaba.fastjson.JSONObject;
import com.mengka.dao.ClassmatesDAO;
import com.mengka.dao.StudentDAO;
import com.mengka.dao.WorkmateDAO;
import com.mengka.model.ClassmatesDO;
import com.mengka.model.StudentDO;
import com.mengka.model.WorkmateDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * User: mengka
 * Date: 15-5-1-下午7:52
 */
@Controller
@RequestMapping("/mk")
public class MengkaController {

    private static final Logger log = LoggerFactory.getLogger(MengkaController.class);

    @Resource
    private StudentDAO studentDAO;

    @Resource(name="classmatesDAO")
    private ClassmatesDAO classmatesDAO;

    @RequestMapping(value = "/selectById.do", method = { RequestMethod.GET, RequestMethod.POST })
    public String selectById(ModelMap map, HttpServletRequest request,
                        @RequestParam(required = false) String name) {
        ClassmatesDO classmatesDO = new ClassmatesDO();
        classmatesDO.setId(190L);
        classmatesDO.setName("西蒙");
        classmatesDO.setAge("20");
        classmatesDO.setSex("男");
      classmatesDAO.insert(classmatesDO);

        ClassmatesDO classmatesDO1 = classmatesDAO.selectById(124L);

        StudentDO studentDO = studentDAO.selectById(111L);
        log.info("studentDO = "+studentDO.getName());
        return "mengka/topic";
    }
    @RequestMapping(value = "/selectByName.do", method = { RequestMethod.GET, RequestMethod.POST })
     public String selectByName(ModelMap map, HttpServletRequest request,HttpServletResponse response,
                              @RequestParam(required = false) String name)throws Exception{
        response.sendRedirect("http://127.0.0.1:8081/mk/selectById.do");

        List<ClassmatesDO> list = classmatesDAO.selectByName("imp");
        log.info("list size = "+list.size());
        return "mengka/topic";
    }
    @RequestMapping(value = "/selectByAge.do", method = { RequestMethod.GET, RequestMethod.POST })
    public String selectByAge(ModelMap map, HttpServletRequest request,HttpServletResponse response,String name)throws Exception{
        log.info("name = "+name);
        RequestDispatcher rd = request.getRequestDispatcher("/mk/selectById.do");
        rd.forward(request,response);

        List<ClassmatesDO> list = classmatesDAO.selectByAge("24");
        log.info("list size = "+list.size());
        return "mengka/topic";
    }



}
