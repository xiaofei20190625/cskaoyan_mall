package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.*;
import com.cskaoyan.mall.admin.service.*;
import com.cskaoyan.mall.admin.vo.PageVO;
import com.cskaoyan.mall.admin.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class UserManageController {
    @Autowired
    UserVipService userVipService;
    @Autowired
    AddressService addressService;
    @Autowired
    CollectService collectService;
    @Autowired
    FootprintService footprintService;
    @Autowired
    SearchHistoryService searchHistoryService;
    @Autowired
    FeedbackService feedbackService;

    /**
     * 会员管理
     * @param page 页码
     * @param limit 条数
     * @param sort add_time
     * @param order order=desc
     * @param username 会员名字
     * @param mobile 手机号
     * @return 返回json
     */
    @RequestMapping("user/list")
    public ResponseVO<PageVO> userList(int page, int limit, String sort, String order,String username,String mobile){
        PageVO<UserVip> userVipPage = null;
        userVipPage = userVipService.findUserVipPageByUsernameAndMobile(page, limit, username, mobile,sort,order);
        ResponseVO<PageVO> pageVOResponseVO = responseVO(userVipPage);
        return pageVOResponseVO;
    }

    private ResponseVO<PageVO> responseVO(PageVO pageVO) {
        ResponseVO<PageVO> ResponseVO =new ResponseVO<>();
        if (pageVO!=null&&pageVO.getTotal()!=0){
            ResponseVO.setData(pageVO);
            ResponseVO.setErrmsg("成功");
            ResponseVO.setErrno(0);
            return ResponseVO;
        }else {
            ResponseVO.setErrmsg("失败");
            ResponseVO.setErrno(-1);
            return ResponseVO;
        }
    }

    /**
     * 收货地址
     * @param page 页码
     * @param limit 条数
     * @param sort add_time
     * @param order order
     * @param userId 用户ID
     * @param name 收货人名称
     * @return json
     */
    @RequestMapping("address/list")
    public ResponseVO<PageVO> addressList(int page, int limit, String sort, String order,String userId,String name){
        PageVO<Address> addressPage = null;
        addressPage = addressService.findAddressPageByNameAndUserId(page, limit, userId, name, sort, order);
        ResponseVO<PageVO> pageVOResponseVO = responseVO(addressPage);
        return pageVOResponseVO;
    }

    /**
     * 会员收藏
     * @param page 页码
     * @param limit 条数
     * @param sort add_time
     * @param order order
     * @param userId 用户ID
     * @param valueId 商品ID
     * @return json
     */
    @RequestMapping("collect/list")
    public ResponseVO<PageVO> collectList(int page, int limit, String sort, String order,String userId,String valueId){
        PageVO<Collect> collectPageVO = null;
        collectPageVO = collectService.findCollectPageByValueIdAndUserId(page, limit, userId, valueId,sort,order);
        ResponseVO<PageVO> pageVOResponseVO = responseVO(collectPageVO);
        return pageVOResponseVO;
    }

    /**
     *会员足迹
     * @param page 页码
     * @param limit 条数
     * @param sort  add_time
     * @param order 描述order
     * @param userId 会员ID
     * @param goodsId 商品ID
     * @return footprint json
     */
    @RequestMapping("footprint/list")
    public ResponseVO<PageVO> footprintList(int page, int limit, String sort, String order, String userId, String goodsId){
        PageVO<Footprint> footprintPageVO = null;
        footprintPageVO = footprintService.findFootprintPageByGoodsIdAndUserId(page, limit, userId, goodsId,sort,order);
        ResponseVO<PageVO> pageVOResponseVO = responseVO(footprintPageVO);
        return pageVOResponseVO;
    }

    /**
     *搜索历史
     * @param page
     * @param limit
     * @param sort 排序
     * @param order
     * @param userId
     * @param keyword
     * @return
     */
    @RequestMapping("history/list")
    public ResponseVO<PageVO> historyList(int page, int limit, String sort, String order, String userId, String keyword){
        PageVO<SearchHistory> searchHistoryPageVO = null;
        searchHistoryPageVO = searchHistoryService.findSearchHistoryPageByKeywordAndUserId(page, limit, userId, keyword,sort,order);
        ResponseVO<PageVO> pageVOResponseVO = responseVO(searchHistoryPageVO);
        return pageVOResponseVO;
    }

    /**
     * 意见反馈
     * @param page 页码
     * @param limit 条数
     * @param sort add_time
     * @param order order
     * @param username 用户名
     * @param id 反馈ID
     * @return feedback json
     */
    @RequestMapping("feedback/list")
    public ResponseVO<PageVO> feedbackList(int page, int limit, String sort, String order, String username, Integer id){
        PageVO<Feedback> feedbackPageVO = null;
        feedbackPageVO = feedbackService.findFeedbackPageByUsernameAndId(page, limit, username, id, sort, order);
        ResponseVO<PageVO> pageVOResponseVO = responseVO(feedbackPageVO);
        return pageVOResponseVO;
    }

}
