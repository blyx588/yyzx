package com.neuedu.yyzx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.yyzx.mapper.LevelItemMapper;
import com.neuedu.yyzx.mapper.NursingServiceMapper;
import com.neuedu.yyzx.pojo.LevelItem;
import com.neuedu.yyzx.pojo.NursingService;
import com.neuedu.yyzx.service.LevelItemService;
import com.neuedu.yyzx.service.NursingServiceService;
import org.springframework.stereotype.Service;


@Service
public class LevelItemServiceImpl extends ServiceImpl<LevelItemMapper, LevelItem> implements LevelItemService {
}
