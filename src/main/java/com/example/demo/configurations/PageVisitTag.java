package com.example.demo.configurations;

import com.example.demo.secvices.PageVisitService;
import freemarker.core.Environment;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateModel;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class PageVisitTag implements TemplateDirectiveModel {
    private final PageVisitService pageVisitService;

    public PageVisitTag(PageVisitService pageVisitService) {
        this.pageVisitService = pageVisitService;
    }

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws IOException {
        SimpleScalar pageNameParam = (SimpleScalar) params.get("pageName");

        if (pageNameParam != null) {
            String pageName = pageNameParam.getAsString();
            int visitCount = pageVisitService.incrementVisitCount(pageName);
            env.getOut().write("Ця сторінка відвідувалася " + visitCount + " разів.");
        }
    }
}