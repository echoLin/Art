package cn.edu.xmu.entity;

public final class INFO {
	public static Integer Success = 0;
	public static Integer Error = 1;
	public static Integer NotLogin = 2;
	public static Integer JumpTo = 2;
	public static String LoginCMS = "/Art/cms/login";
	public static String LoginMALL = "/Art/mall/login";
	public static String ApplyArtist = "/Art/mall/jsp/artist/apply";//艺术家的申请地址
	public static String Applying="/mall/jsp/artist/applying";//艺术家正在审核的页面
	public static String ActionSuccess = "ok";
	public static String ActionError = "fail";
	public static String LoginError = "用户名或密码错误";
	public static String ParamError = "参数错误";
	public static String SaveError = "保存失败";
	public static String SaveSuccess = "保存成功";
	public static String DeleteError = "删除失败";
	public static String DeleteSuccess = "删除成功";
	public static String NotDraft = "该资讯不是草稿,所以不能删除";
	public static String NotYoursDraft = "这不是你写的资讯,所以不能删除";
	public static String CannotSubmitArticle = "资讯待审核或已审核，不能重复提交";
	public static String NotYourArticle = "这不是你写的资讯";
	public static String SubmitSuccess = "提交成功";
	public static String SubmitError = "提交失败";
	public static String CannotDoIt = "不能执行改操作";
	public static String Committed = "已经提交申请";
}
