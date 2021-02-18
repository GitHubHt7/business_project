package com.sincerity.controller;

import cn.afterturn.easypoi.word.WordExportUtil;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
import com.sincerity.configure.CommonProperties;
import com.sincerity.entity.Company;
import com.sincerity.entity.Member;
import com.sincerity.util.WordUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/word")
public class WordController {

    @Autowired
    private CommonProperties commonProperties;

    @GetMapping("/export")
    public void export() throws IOException {
        HackLoopTableRenderPolicy policy = new HackLoopTableRenderPolicy();
        Configure configure = Configure.builder().bind("members",policy).build();
        Member member1 = new Member(20180101L,"Sincerity1",24,"这是我的个人报告1");
        Member member2 = new Member(20180102L,"Sincerity2",24,"这是我的个人报告2");
        Company company = new Company();
        company.setName("Alibaba");
        company.setPrintTime("2021-1-17");
        company.getMembers().add(member1);
        company.getMembers().add(member2);
        XWPFTemplate template = XWPFTemplate.compile(commonProperties.getWordTemplatePath(),configure).render(company);
        WordUtil.write(template);
    }
}
