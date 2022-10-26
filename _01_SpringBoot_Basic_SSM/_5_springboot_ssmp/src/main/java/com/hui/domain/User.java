package com.hui.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Repository;

@Repository
@TableName("tb_user")
@Data
@ToString
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;
    @TableField(select = false)
    private String password;
    private String gender;
    private String addr;
    private Long money;
//    @TableLogic(value = "0",delval = "1")
    @TableField(select = false)
    private Integer deleted;
    @Version
    @TableField(select = false)
    private Integer version;

}
