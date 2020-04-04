package com.zhymgc.controller;

        import com.zhymgc.entity.Result;
        import com.zhymgc.entity.StatusCode;
        import com.zhymgc.service.FriendService;
        import io.jsonwebtoken.Claims;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;

        import javax.servlet.http.HttpServletRequest;

/**
 * 类 {@code } INFO
 *
 * @author 张昊 zhanghao_nmgjc@bosssoft.com.cn
 * @version v2.0
 * @since 2020-4-4 22:45
 * <p>
 * copyright: 内蒙古金财信息技术有限公司 (c)
 * </p>
 */
@RestController
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private FriendService friendService;
    @Autowired
    private HttpServletRequest request;

    /*** 添加好友 * @param friendid 对方用户ID * @param type 1：喜欢 0：不喜欢 * @return */
    @RequestMapping(value = "/like/{friendid}/{type}", method = RequestMethod.PUT)
    public Result addFriend(@PathVariable String friendid, @PathVariable String type) {
        Claims claims = (Claims) request.getAttribute("user_claims");
        if (claims == null) {
            return new Result(false, StatusCode.ACCESSERROR, "无权访问");
        }//如果是喜欢
        if (type.equals("1")) {
            if (friendService.addFriend(claims.getId(), friendid) == 0) {
                return new Result(false, StatusCode.REPERROR, "已经添加此好 友");
            }
        } else {//不喜欢
            friendService.addNoFriend(claims.getId(), friendid);//向不喜欢 列表中添加记录
        }
        return new Result(true, StatusCode.OK, "操作成功");
    }

    /*** 删除好友 * @param friendid * @return */
    @RequestMapping(value = "/{friendid}", method = RequestMethod.DELETE)
    public Result remove(@PathVariable String friendid) {
        Claims claims = (Claims) request.getAttribute("user_claims");
        if (claims == null) {
            return new Result(false, StatusCode.ACCESSERROR, "无权访问");
        }
        friendService.deleteFriend(claims.getId(), friendid);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}