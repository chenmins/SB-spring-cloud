package com.spdata.oauth2.account.controller;

import com.spdata.common.base.BaseResul;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @描述:
 * @auther yangqifang
 * @data 2018/12/520:08
 **/
@Log
@FrameworkEndpoint
public class RemoveTokenEndpoint {
    @Autowired
    private DefaultTokenServices tokenServices;

    /**
     * 注销接口
     *
     * @param access_token
     * @return
     */
    @RequestMapping(value = "/oauth/token", method = RequestMethod.DELETE)
    @ResponseBody
    public BaseResul logout(@RequestParam(value = "access_token") String access_token) {
        BaseResul resul = new BaseResul();
        try {
            boolean ifRemove = tokenServices.revokeToken(access_token);
            if (!ifRemove) {
                throw new Exception("注销失败");
            }
            resul.setData(ifRemove);
            resul.setMessage("注销成功!");
        } catch (Exception e) {
            log.warning(e.getMessage());
            resul.setMessage("注销失败!");
        }
        return resul;
    }
}
