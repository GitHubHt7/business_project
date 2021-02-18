package com.sincerity.util;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
import com.deepoove.poi.util.PoitlIOUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * ClassName: Word 工具类
 * Create by Ht7_Sincerity on 2021-02-17
 */

public class WordUtil {

    /**
     * 根据模板输出 Word
     * @param template
     * @throws IOException
     */
    public static void write(XWPFTemplate template) throws IOException{
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (null != servletRequestAttributes) {
            HttpServletResponse response = servletRequestAttributes.getResponse();
            if (null != response) {
                response.setContentType("application/octet-stream");
                response.setHeader("Content-disposition", "attachment;filename=\"" + "out_template.docx" + "\"");
                OutputStream out = response.getOutputStream();
                BufferedOutputStream bos = new BufferedOutputStream(out);
                template.write(bos);
                bos.flush();
                out.flush();
                PoitlIOUtils.closeQuietlyMulti(template, bos, out);
            }
        }
    }
}
