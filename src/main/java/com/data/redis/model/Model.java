package com.data.redis.model;
import com.biz.primus.base.redis.annotation.Ro;
import com.biz.primus.base.redis.annotation.RoSortedSet;
import com.biz.primus.base.redis.bean.BaseRedisObject;
import lombok.Data;
/**
 * @Auther: ljh
 * @Date: 2018/9/4 14:45
 * @Description:
 */
@Data
@Ro(key = "MemberRo")
@RoSortedSet(key = "list", score = "createTimestamp")
public class Model extends BaseRedisObject<Long> {

    private String name;
    private int age;
    private String mark;
}
