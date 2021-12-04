package voting;

public class Department {
	
	String name;//部门名
	String function;//部门功能
	ZhiWu buzhang;
	ZhiWu fubuzhang1;
	ZhiWu fubuzhang2;
	ZhiWu workerVoter1;
	ZhiWu workerVoter2;
		
	
	public Department(String name,String functuon) {
		// TODO 自动生成的构造函数存根
		this.name = name;
		this.function = functuon;
	}
	
//	public void setFunction(String function) {
//		this.function = function;
//	}
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//	
	public String getFunction() {
		return function;
	}
	
}
