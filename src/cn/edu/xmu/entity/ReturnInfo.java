package cn.edu.xmu.entity;

public class ReturnInfo {
	private int type;
	private String info;
	
	public ReturnInfo(){
		this.type=0;
		this.info="success";
	}
	public ReturnInfo(int type,String info){
		this.type=type;
		this.info=info;
	}

	public int gettype() {
		return type;
	}

	public void settype(int type) {
		this.type = type;
	}

	public String getinfo() {
		return info;
	}

	public void setinfo(String info) {
		this.info = info;
	}
	

}
