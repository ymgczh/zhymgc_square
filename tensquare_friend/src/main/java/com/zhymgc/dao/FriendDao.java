package com.zhymgc.dao;

import com.zhymgc.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 类 {@code } INFO
 *
 * @author 张昊 zhanghao_nmgjc@bosssoft.com.cn
 * @version v2.0
 * @since 2020-4-4 22:30
 * <p>
 * copyright: 内蒙古金财信息技术有限公司 (c)
 * </p>
 */
public interface FriendDao extends JpaRepository<Friend, String> {
    /*** 根据用户ID与被关注用户ID查询记录个数 * @param userid * @param friendid * @return */
    @Query("select count(f) from Friend f where f.userid=?1 and f.friendid=?2")
    public int selectCount(String userid, String friendid);

    /*** 更新为互相喜欢 * @param userid * @param friendid */
    @Modifying
    @Query("update Friend f set f.islike=?3 where f.userid=?1 and f.friendid=?2")
    public void updateLike(String userid, String friendid, String islike);

    /*** 删除喜欢 * @param userid * @param friendid */
    @Modifying
    @Query("delete from Friend f where f.userid=?1 and f.friendid=?2")
    public void deleteFriend(String userid, String friendid);
}