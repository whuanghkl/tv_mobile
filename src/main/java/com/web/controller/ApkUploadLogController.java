package com.web.controller;

import com.entity.ApkUploadLog;
import oa.web.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/app/upload")
public class ApkUploadLogController extends BaseController<ApkUploadLog> {
    @Override
    protected void beforeAddInput(Model model,HttpServletRequest request) {

    }

    @Override
    protected void errorDeal(Model model) {

    }

    @Override
    public String getJspFolder() {
        return null;
    }

}
