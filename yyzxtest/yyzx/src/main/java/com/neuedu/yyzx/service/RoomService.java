package com.neuedu.yyzx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.yyzx.pojo.Room;
import com.neuedu.yyzx.utils.ResultVo;
import com.neuedu.yyzx.vo.CwsyBedVo;

public interface RoomService extends IService<Room> {
    public ResultVo<CwsyBedVo> findCwsyBedVo(String floor) throws Exception;
}
