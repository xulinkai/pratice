package com.xulk.mashibing.springSourceCode;

import lombok.Data;

/**
 * @description:
 * @author:
 * @create: 2020-03-02 16:38
 **/

@Data
public class UserController {

    @MyAutowired
    private UserService userService;
}
