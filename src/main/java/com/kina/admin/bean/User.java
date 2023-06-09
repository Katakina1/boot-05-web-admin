package com.kina.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("muser")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;

    // 所有属性都应该在数据库中
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;
}
