package com.neuedu.yyzx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.yyzx.mapper.BedMapper;
import com.neuedu.yyzx.mapper.RoomMapper;
import com.neuedu.yyzx.pojo.Room;
import com.neuedu.yyzx.service.RoomService;
import com.neuedu.yyzx.utils.ResultVo;
import com.neuedu.yyzx.vo.CwsyBedVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
    @Autowired
    private BedMapper bedMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public ResultVo<CwsyBedVo> findCwsyBedVo(String floor) throws Exception {
        //统计床位
        CwsyBedVo cwsyBedVo=bedMapper.selectBedCount();
        QueryWrapper qwRoomList=new QueryWrapper();
        qwRoomList.eq("room_floor",floor);
        //查询所有房间
        List<Room> rooms=list(qwRoomList);
        for(Room room:rooms){
            //查询每个房间的床位信息
            QueryWrapper qwBedList=new QueryWrapper();
            qwBedList.eq("room_no",room.getRoomNo());
            room.setBedList(bedMapper.selectList(qwBedList));
        }
        cwsyBedVo.setRoomList(rooms);
        return ResultVo.ok(cwsyBedVo);
    }
}
