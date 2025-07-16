package com.health.web.controller.monitor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.health.common.core.domain.AjaxResult;
import com.health.framework.web.domain.Server;
import io.swagger.annotations.Api;

/**
 * 服务器监控
 * 
 *  
 */
@Api(tags = "服务器监控接口")
@RestController
@RequestMapping("/monitor/server")
public class ServerController
{
    @PreAuthorize("@ss.hasPermi('monitor:server:list')")
    @GetMapping()
    public AjaxResult getInfo() throws Exception
    {
        Server server = new Server();
        server.copyTo();
        return AjaxResult.success(server);
    }
}
