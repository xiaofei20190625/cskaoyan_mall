package com.cskaoyan.mall.wx.vo;

/**
 * Created by little Stone
 * Date 2019/4/19 Time 10:16
 */
public class BaseRespVO {
	Object data;
	String errmsg;
	Integer errno;



	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public Integer getErrno() {
		return errno;
	}

	public void setErrno(Integer errno) {
		this.errno = errno;
	}

	public static BaseRespVO ok(Object data){
		BaseRespVO baseRespVo = new BaseRespVO();
		baseRespVo.setData(data);
		baseRespVo.setErrmsg("成功");
		baseRespVo.setErrno(0);
		return baseRespVo;
	}

	public static BaseRespVO fail() {
		BaseRespVO baseRespVo = new BaseRespVO();
		baseRespVo.setErrno(-1);
		baseRespVo.setErrmsg("错误");
		return baseRespVo;
	}
	public static BaseRespVO fail(Integer errorNo, String errorMsg) {
		BaseRespVO baseRespVo = new BaseRespVO();
		baseRespVo.setErrno(errorNo);
		baseRespVo.setErrmsg(errorMsg);
		return baseRespVo;
	}
	public static BaseRespVO updatedDataFailed() {
		return fail(505, "更新数据失败");
	}
	public static BaseRespVO createDataFailed() {
		return fail(510, "创建数据失败");
	}

	public static BaseRespVO badArgument() {
		return fail(401, "参数不对");
	}

}
