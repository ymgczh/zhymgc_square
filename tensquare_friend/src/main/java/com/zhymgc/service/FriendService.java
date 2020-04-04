package com.zhymgc.service;

import com.zhymgc.client.UserClient;
import com.zhymgc.dao.FriendDao;
import com.zhymgc.dao.NoFriendDao;
import com.zhymgc.pojo.Friend;
import com.zhymgc.pojo.NoFriend;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

/**
 * 类 {@code } INFO
 *
 * @author 张昊 zhanghao_nmgjc@bosssoft.com.cn
 * @version v2.0
 * @since 2020-4-4 22:39
 * <p>
 * copyright: 内蒙古金财信息技术有限公司 (c)
 * </p>
 */
public class FriendService {
    @Autowired
    private FriendDao friendDao;
    @Autowired
    private UserClient userClient;

    @Transactional
    public int addFriend(String userid, String friendid) { //判断如果用户已经添加了这个好友，则不进行任何操作,返回0 if(friendDao.selectCount(userid, friendid)>0){ return 0; }//向喜欢表中添加记录
        Friend friend = new Friend();
        friend.setUserid(userid);
        friend.setFriendid(friendid);
        friend.setIslike("0");
        friendDao.save(friend); //判断对方是否喜欢你，如果喜欢，将islike设置为1
        if (friendDao.selectCount(friendid, userid) > 0) {
            friendDao.updateLike(userid, friendid, "1");
            friendDao.updateLike(friendid, userid, "1");
        }
        userClient.incFollowcount(userid, 1);//增加自己的关注数
        userClient.incFanscount(friendid, 1);//增加对方的粉丝数
        return 1;
    }

    @Autowired
    private NoFriendDao noFriendDao;

    /*** 向不喜欢列表中添加记录 * @param userid * @param friendid */
    public void addNoFriend(String userid, String friendid) {
        NoFriend noFriend = new NoFriend();
        noFriend.setUserid(userid);
        noFriend.setFriendid(friendid);
        noFriendDao.save(noFriend);
    }

    /*** 删除好友 * @param userid * @param friendid */
    @Transactional
    public void deleteFriend(String userid, String friendid) {
        friendDao.deleteFriend(userid, friendid);
        friendDao.updateLike(friendid, userid, "0");
        addNoFriend(userid, friendid);//向不喜欢表中添加记录 }
        userClient.incFollowcount(userid,-1);//减少自己的关注数
        userClient.incFanscount(friendid,-1);//减少对方的粉丝数
    }
}
