package com.data.redis.dao;

import com.biz.primus.base.redis.CrudRedisDao;
import com.data.redis.model.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Auther: ljh
 * @Date: 2018/9/4 14:44
 * @Description:
 */
@Component
@Slf4j
public class RedisDao extends CrudRedisDao<Model, Long> {

    /**
     * 保存
     */
    @Override
    public void save(Model ro) {

        super.save(ro);

    /*    if (StringUtils.isNotBlank(ro.getMobile())) {
            set(this.mobileMappingKey(ro.getMobile()), RedisUtil.toByteArray(ro.getId()));
        }
        if (StringUtils.isNotBlank(ro.getAccount())) {
            set(this.accountMappingKey(ro.getAccount()), RedisUtil.toByteArray(ro.getId()));
        }
        if (StringUtils.isNotBlank(ro.getEmail())) {
            set(this.emailMappingKey(ro.getEmail()), RedisUtil.toByteArray(ro.getId()));
        }*/
    }

}
