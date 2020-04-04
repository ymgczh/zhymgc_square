package com.zhymgc.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 类 {@code } INFO
 *
 * @author 张昊 zhanghao_nmgjc@bosssoft.com.cn
 * @version v2.0
 * @since 2020-4-4 22:48
 * <p>
 * copyright: 内蒙古金财信息技术有限公司 (c)
 * </p>
 */
@Entity
@Table(name = "tb_nofriend")
@IdClass(NoFriend.class)
@Data
public class NoFriend implements Serializable {
    @Id
    private String userid;
    @Id
    private String friendid;
}