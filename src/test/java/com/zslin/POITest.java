package com.zslin;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 钟述林 393156105@qq.com on 2016/10/28 16:00.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("zsl")
public class POITest {

    @Test
    public void testExportWord() throws Exception {
        String destFile = "D:/temp/123.doc";
        String fileContent = "Export world 要导出的内容";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(fileContent.getBytes("UTF-8"));
        POIFSFileSystem fileSystem = new POIFSFileSystem();
        DirectoryEntry directory = fileSystem.getRoot();
        directory.createDocument("WordDocument", byteArrayInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(destFile);
        fileSystem.writeFilesystem(fileOutputStream);
        byteArrayInputStream.close();
        fileOutputStream.close();
    }

    @Test
    public void testExport2() throws Exception {
        String templatePath = "D:/temp/template.doc";
        Map<String, String> contentMap = new HashMap<>();
        contentMap.put("title", "中文标题");
        contentMap.put("content", "this is Content! \n 继续...");
        contentMap.put("author", "I'm Author");
        HWPFDocument document = build(templatePath, contentMap);
        if(document != null){
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                document.write(byteArrayOutputStream);
                OutputStream outputStream = new FileOutputStream("D:/temp/aa.doc");
                outputStream.write(byteArrayOutputStream.toByteArray());
                outputStream.close();
            } catch (IOException e) {

            }
        }
    }

    private HWPFDocument build(String templatePath, Map<String, String> contentMap) throws Exception {
        FileInputStream tempFileInputStream = new FileInputStream(new File(templatePath));
        HWPFDocument document = new HWPFDocument(tempFileInputStream);
        // 读取文本内容
        Range bodyRange = document.getRange();
        // 替换内容
        for (Map.Entry<String, String> entry : contentMap.entrySet()) {
            bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue());
        }
        return document;
    }
}
