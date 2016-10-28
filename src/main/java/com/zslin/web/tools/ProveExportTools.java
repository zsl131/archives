package com.zslin.web.tools;

import com.zslin.basic.tools.DateTools;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 导出证明工具类
 * Created by 钟述林 393156105@qq.com on 2016/10/28 17:16.
 */
public class ProveExportTools {

    /**
     * 导出证明文件
     * @param title 证明标题
     * @param content 证明内容
     * @param author 落款
     * @param outputStream 输出目录
     * @throws Exception
     */
    public static void exportProveWord(String title, String content, String author, OutputStream outputStream) {
        try {
            Map<String, String> contentMap = new HashMap<>();
            contentMap.put("title", title);
            contentMap.put("content", content);
            contentMap.put("author", author);
            contentMap.put("date", DateTools.date2Str(new Date(), "yyyy年MM月dd日"));
            FileInputStream tempFileInputStream = new FileInputStream(ResourceUtils.getFile("classpath:template.doc"));
            HWPFDocument document = new HWPFDocument(tempFileInputStream);
            // 读取文本内容
            Range bodyRange = document.getRange();
            // 替换内容
            for (Map.Entry<String, String> entry : contentMap.entrySet()) {
                bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue());
            }

            if(document != null){
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    document.write(byteArrayOutputStream);
                    outputStream.write(byteArrayOutputStream.toByteArray());
                    outputStream.close();
                } catch (IOException e) {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
