package com.sky;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //开启注解方式的事务管理
@EnableScheduling
@Slf4j
public class SkyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkyApplication.class, args);
        log.info("server started");

        System.out.println("*                  ___====-_  _-====___\n" +
                " *            _--^^^#####//      \\\\#####^^^--_\n" +
                " *         _-^##########// (    ) \\\\##########^-_\n" +
                " *        -############//  |\\^^/|  \\\\############-\n" +
                " *      _/############//   (@::@)   \\\\############\\_\n" +
                " *     /#############((     \\\\//     ))#############\\\n" +
                " *    -###############\\\\    (oo)    //###############-\n" +
                " *   -#################\\\\  / VV \\  //#################-\n" +
                " *  -###################\\\\/      \\//###################-\n" +
                " * _#/|##########/\\######(   /\\   )######/\\##########|\\#_\n" +
                " * |/ |#/\\#/\\#/\\/  \\#/\\##\\  |  |  /##/\\#/  \\/\\#/\\#/\\#| \\|\n" +
                " * `  |/  V  V  `   V  \\#\\| |  | |/#/  V   '  V  V  \\|  '\n" +
                " *    `   `  `      `   / | |  | | \\   '      '  '   '\n" +
                " *                     (  | |  | |  )\n" +
                " *                    __\\ | |  | | /__\n" +
                " *                   (vvv(VVV)(VVV)vvv)");

        System.out.println("(♥◠‿◠)ﾉﾞ  系统模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " ——---————/´ ¯/)\n" +
                " —— ———--/—-/\n" +
                " — ————-/—-/\n" +
                " ———--/´¯/'--'/´¯`•_\n" +
                " ———-/'/--/—-/—--/¨¯\\\n" +
                " ——--('(———- ¯~/'--')\n" +
                " — ——\\————-'—--/\n" +
                " ———-'\\'————_-•´\n" +
                " — ———\\———--(\n" +
                " —— ——-\\———-");
    }

}
