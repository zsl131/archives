package com.zslin;

import com.zslin.web.tools.AddrCodeTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 钟述林 393156105@qq.com on 2016/10/30 10:35.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddrCodeTest {

    @Test
    public void testBuildCode() {
        String addr = "云南省昭通市绥江县";
        String res = AddrCodeTools.buildCode(addr);
        System.out.println(res);
    }
}
