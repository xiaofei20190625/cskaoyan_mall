package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.service.*;
import com.cskaoyan.mall.vo.PageVO;
import com.cskaoyan.mall.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
     * @param desc order=desc
     * @param username 会员名字
     * @param mobile 手机号
     * @return 返回json
     */
    @RequestMapping("user/list")
    public ResponseVO<PageVO> userList(int page, int limit, String sort, String desc,String username,String mobile){
        PageVO<UserVip> userVipPage = null;
        if (username==null&&mobile==null){
            userVipPage = userVipService.findUserVipPage(page, limit);
        }else if (username!=""&&mobile==null){
            userVipPage = userVipService.findUserVipPageByUsername(page, limit, username);
        }else if (username!=""&&mobile!=""){
            userVipPage = userVipService.findUserVipPageByUsernameAndMobile(page, limit, username, mobile);
        }else if (mobile!=""&&mobile!=null){
            userVipPage = userVipService.findUserVipPageByMobile(page, limit, mobile);
        }
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
        }
        return ResponseVO;
    }

    /**
     * 收货地址
     * @param page 页码
     * @param limit 条数
     * @param sort add_time
     * @param desc order
     * @param userId 用户ID
     * @param name 收货人名称
     * @return json
     */
    @RequestMapping("address/list")
    public ResponseVO<PageVO> addressList(int page, int limit, String sort, String desc,String userId,String name){
        PageVO<Address> addressPage = null;
        if (name==null&&userId==null){
            addressPage = addressService.findAddressPage(page, limit);
        }else if (name!=""&&userId==null){
            addressPage = addressService.findAddressPageByName(page, limit, name);
        }else if (name!=""&&userId!=""&&userId==null){
            addressPage = addressService.findAddressPageByNameAndUserId(page, limit, userId, name);
        }else if (userId!=""&&userId!=null){
            addressPage = addressService.findAddressPageByUserId(page, limit, userId);
        }
        ResponseVO<PageVO> pageVOResponseVO = responseVO(addressPage);
        return pageVOResponseVO;
    }

    /**
     * 会员收藏
     * @param page 页码
     * @param limit 条数
     * @param sort add_time
     * @param desc order
     * @param userId 用户ID
     * @param valueId 商品ID
     * @return json
     */
    @RequestMapping("collect/list")
    public ResponseVO<PageVO> collectList(int page, int limit, String sort, String desc,String userId,String valueId){
        PageVO<Collect> collectPageVO = null;
        if (userId==null&&valueId==null){
            collectPageVO = collectService.findCollectPage(page, limit);
        }else if (userId!=""&&(valueId==""||valueId==null)){
            collectPageVO = collectService.findCollectByUserId(page, limit, userId);
        }else if (userId!=""&&valueId!=""&&valueId==null){
            collectPageVO = collectService.findCollectPageByValueIdAndUserId(page, limit, userId, valueId);
        }else if (valueId!=""&&valueId!=null){
            collectPageVO = collectService.findCollectPageByValueId(page, limit, valueId);
        }
        ResponseVO<PageVO> pageVOResponseVO = responseVO(collectPageVO);
        return pageVOResponseVO;
    }

    /**
     *
     * @param page 页码
     * @param limit 条数
     * @param sort  add_time
     * @param desc 描述order
     * @param userId 会员ID
     * @param goodsId 商品ID
     * @return footprint json
     */
    @RequestMapping("footprint/list")
    public ResponseVO<PageVO> footprintList(int page, int limit, String sort, String desc, String userId, String goodsId){
        PageVO<Footprint> footprintPageVO = null;
        if (userId==null&&goodsId==null){
            footprintPageVO = footprintService.findFootprintPage(page, limit);
        }else if (userId!=""&&(goodsId==""||goodsId==null)){
            footprintPageVO = footprintService.findFootprintByUserId(page, limit, userId);
        }else if (userId!=""&&goodsId!=""&&goodsId!=null){
            footprintPageVO = footprintService.findFootprintPageByGoodsIdAndUserId(page, limit, userId, goodsId);
        }else if (goodsId!=""&&goodsId!=null){
            footprintPageVO = footprintService.findFootprintPageByGoodsId(page, limit, goodsId);
        }
        ResponseVO<PageVO> pageVOResponseVO = responseVO(footprintPageVO);
        return pageVOResponseVO;
    }

    /**
     *
     * @param page
     * @param limit
     * @param sort
     * @param desc
     * @param userId
     * @param keyword
     * @return
     */
    @RequestMapping("history/list")
    public ResponseVO<PageVO> historyList(int page, int limit, String sort, String desc, String userId, String keyword){
        PageVO<SearchHistory> searchHistoryPageVO = null;
        if (userId==null&&keyword==null){
            searchHistoryPageVO = searchHistoryService.findSearchHistoryPage(page, limit);
        }else if (userId!=""&&(keyword==""||keyword==null)){
            searchHistoryPageVO = searchHistoryService.findSearchHistoryByUserId(page, limit, userId);
        }else if (userId!=""&&keyword!=""&&keyword!=null){
            searchHistoryPageVO = searchHistoryService.findSearchHistoryPageByKeywordAndUserId(page, limit, userId, keyword);
        }else if (keyword!=""&&keyword!=null){
            searchHistoryPageVO = searchHistoryService.findSearchHistoryPageByKeyword(page, limit, keyword);
        }
        ResponseVO<PageVO> pageVOResponseVO = responseVO(searchHistoryPageVO);
        return pageVOResponseVO;
    }

    /**
     * 意见反馈
     * @param page 页码
     * @param limit 条数
     * @param sort add_time
     * @param desc order
     * @param username 用户名
     * @param id 反馈ID
     * @return feedback json
     */
    @RequestMapping("feedback/list")
    public ResponseVO<PageVO> feedbackList(int page, int limit, String sort, String desc, String username, Integer id){
        PageVO<Feedback> feedbackPageVO = null;
        if (username==null&&id==null){
            feedbackPageVO = feedbackService.findFeedbackPage(page, limit);
        }else if (username!=""&&(id==0||id==null)){
            feedbackPageVO = feedbackService.findFeedbackByUsername(page, limit, username);
        }else if (username!=""&&id!=0&&id!=null){
            feedbackPageVO = feedbackService.findFeedbackPageByUsernameAndId(page, limit, username, id);
        }else if (id!=0&&id!=null){
            feedbackPageVO = feedbackService.findFeedbackPageById(page, limit, id);
        }
        ResponseVO<PageVO> pageVOResponseVO = responseVO(feedbackPageVO);
        return pageVOResponseVO;
    }

}
