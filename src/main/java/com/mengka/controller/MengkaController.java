package com.mengka.controller;

import com.alibaba.fastjson.JSONObject;
import com.mengka.dao.StudentDAO;
import com.mengka.dao.WorkmateDAO;
import com.mengka.model.StudentDO;
import com.mengka.model.WorkmateDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    @Resource
    private WorkmateDAO workmateDAO;

    @RequestMapping(value = "/selectById.do", method = { RequestMethod.GET, RequestMethod.POST })
    public String selectById(ModelMap map, HttpServletRequest request,
                        @RequestParam(required = false) String groupName) {

        WorkmateDO workmateDO = new WorkmateDO();
        workmateDO.setName("zhangsan");
        workmateDO.setAddress("hangzhou");
        workmateDAO.insert(workmateDO);

        WorkmateDO workmateDO1 = workmateDAO.selectByIe(1212L);

        StudentDO studentDO = studentDAO.selectById(111L);
        log.info("studentDO = "+studentDO.getName());
        return "mengka/topic";
    }



}
