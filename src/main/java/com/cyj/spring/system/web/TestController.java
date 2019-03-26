package com.cyj.spring.system.web;


import com.cyj.spring.common.BaseController;
import com.cyj.spring.system.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * \                             .       .
 * " +
 * " \\                           / `.   .' \"\n" +
 * "  \\                  .---.  <    > <    >  .---.\n" +
 * "   \\                 |    \\  \\ - ~ ~ - /  /    |\n" +
 * "         _____          ..-~             ~-..-~\n" +
 * "        |     |   \\~~~\\.'                    `./~~~/\n" +
 * "       ---------   \\__/                        \\__/\n" +
 * "      .'  O    \\     /               /       \\  \"\n" +
 * "     (_____,    `._.'               |         }  \\/~~~/\n" +
 * "      `----.          /       }     |        /    \\__/\n" +
 * "            `-.      |       /      |       /      `. ,~~|\n" +
 * "                ~-.__|      /_ - ~ ^|      /- _      `..-'  \n" +
 * "                     |     /        |     /     ~-.     `-. _  _  _\n" +
 * "                     |_____|        |_____|         ~ - . _ _ _ _ _>
 *
 * @author cyj
 * @description : Test 控制器
 * ---------------------------------
 * @since 2019-03-26
 */
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;
}