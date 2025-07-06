package com.neuedu.yyzx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.yyzx.pojo.User;
import com.neuedu.yyzx.utils.ResultVo;

public interface UserService extends IService<User> {
    public ResultVo<User> login(String username, String password)throws Exception;
}
