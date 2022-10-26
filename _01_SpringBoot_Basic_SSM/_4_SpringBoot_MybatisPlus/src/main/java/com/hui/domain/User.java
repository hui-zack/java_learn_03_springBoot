package com.hui.domain;


import com.baomidou.mybatisplus.annotation.*;
import lombok.*;
import org.springframework.stereotype.Repository;

@Repository
@TableName("tb_user")                   /* 0-2 实体类中配置对应表 || 0-5-1 表名映射 */

@Data
public class User {
    @TableId(value = "id", type = IdType.AUTO)  /* 0-6-1 单表设置id生成策略 */
    private Integer id;

    @TableField("username")                     /* 0-5-2-1 匹配数据库列名 */
    private String username;

    @TableField(select = false)                 /* 0-5-2-2 字段不参与查询 */
    private String password;
    private String gender;
    private String addr;
    private Long money;

    @TableField(exist = false)                  /* 0-5-2-3 属性不与任何表字段匹配 */
    private Integer online;

    @TableLogic(value = "0", delval = "1")      /* 6-1 使用@TableLogin()注解标记逻辑删除字段 */
    private Integer deleted;

    @Version                                    /* 7-2 使用@Version注解标记乐观锁字段 */
    private Integer version;

}
