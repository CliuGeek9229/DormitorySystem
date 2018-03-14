package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.db.DBManager;
import com.domain.Announce;
import com.domain.Oldthing;
import com.domain.User;

public class Service {
	public User login(String username, String password) {

		// 获取Sql查询语句
		String logSql = "select * from tb_stuinfo where stuID ='" + username
				+ "' and stuPW ='" + password +"'";

		// 获取DB对象
		User user = new User();
		DBManager sql = DBManager.createInstance();
		sql.getConnection();

		// 操作DB对象
		try {
			ResultSet rs = sql.executeQuery(logSql);
			//User user = new User();
			if (rs.next()) {
				user.setStuID(rs.getString("stuID"));
				user.setStuPW(rs.getString("stuPW"));
				user.setRealname(rs.getString("stuname"));
				user.setSex(rs.getString("stusex"));
				user.setSchool(rs.getString("stuschool"));
				user.setMajor(rs.getString("stumajor"));
				user.setApartment(rs.getInt("stuapartment"));
				user.setDormitory(rs.getInt("studormitory"));
				
				System.out.println("查询结果："+user.getStuID()+"-----"+user.getStuPW()+"------"+user.getSex()+"-------"+user.getRealname()+"-----"
						+user.getSchool()+"--------"+user.getMajor()+"-----"+user.getApartment()+"------"+user.getDormitory());
				sql.closeDB();
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return null;
	}
	
	public Boolean register(String stuID,String password,String username, String sex,String school,String major,String apartment,String dormitory) {

		// 获取Sql查询语句
		String regSql = "insert into tb_stuinfo (stuID,stuPW,stuname,stusex,stuschool,stumajor,stuapartment,studormitory) values('"
				+ stuID + "','" + password + "','" + username + "','" + sex + "','" + school + "','" + major + "','" + apartment + "','" + dormitory + "') ";
		
		
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.getConnection();
		
		int ret = sql.executeUpdate(regSql);
//		System.out.println("test"+ ret);
		if (ret != 0) {
			sql.closeDB();
			return true;
		}
		sql.closeDB();

		return false;
	}
	public Boolean Feedbak(String stuID,String username,String school,String apartment,String dormitory,String detail) {

		// 获取Sql查询语句
		String regSql = "insert into tb_feedback (id,stuID,stuname,stuschool,stuapartment,studormitory,fbdetail) values(null" + ",'"
				+ stuID + "','" + username + "','" + school + "','" + apartment + "','" + dormitory + "','" + detail + "')";
		
		
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.getConnection();
		
		int ret = sql.executeUpdate(regSql);
//		System.out.println("test"+ ret);
		if (ret != 0) {
			sql.closeDB();
			return true;
		}
		sql.closeDB();

		return false;
	}
	public Boolean Callfix(String stuID,String username,String school,String apartment,String dormitory,String detail) {

		// 获取Sql查询语句
		String regSql = "insert into tb_callfix (id,stuID,realname,school,apartment,dormitory,detail) values(null" + ",'"
				+ stuID + "','" + username + "','" + school + "','" + apartment + "','" + dormitory + "','" + detail + "')";
		
		
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.getConnection();
		
		int ret = sql.executeUpdate(regSql);
//		System.out.println("test"+ ret);
		if (ret != 0) {
			sql.closeDB();
			return true;
		}
		sql.closeDB();

		return false;
	}
	
	public Boolean ExchangeApply(String stuID,String username,String school,String apartment,String dormitory,String targetApart,String targetRoom, String detail) {

		// 获取Sql查询语句
		String regSql = "insert into tb_applyexchange (id,stuID,realname,school,apartment,dormitory,targetApart,targetRoom,reason) values(null" + ",'"
				+ stuID + "','" + username + "','" + school + "','" + apartment + "','" + dormitory + "','" + targetApart +"','"+targetRoom+"','"+detail+ "')";
		
		
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.getConnection();
		
		int ret = sql.executeUpdate(regSql);
//		System.out.println("test"+ ret);
		if (ret != 0) {
			sql.closeDB();
			return true;
		}
		sql.closeDB();

		return false;
	}
	
	public Boolean CallLost(String stuID,String username,String detail) {

		// 获取Sql查询语句
		String regSql = "insert into tb_lostinfo (id,stuID,realname,detail) values(null" + ",'"
				+ stuID + "','" + username + "','" +detail+ "')";
		
		
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.getConnection();
		
		int ret = sql.executeUpdate(regSql);
//		System.out.println("test"+ ret);
		if (ret != 0) {
			sql.closeDB();
			return true;
		}
		sql.closeDB();

		return false;
	}
	public Boolean Signlate(String stuID,String username,String school,String apartment,String dormitory) {

		// 获取Sql查询语句
		String regSql = "insert into tb_backlate (id,stuID,stuname,stuschool,stuapartent,studentdormity) values(null" + ",'"
				+ stuID + "','" + username + "','" +school+"','"+apartment+"','"+dormitory+ "')";
		
		
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.getConnection();
		
		int ret = sql.executeUpdate(regSql);
//		System.out.println("test"+ ret);
		if (ret != 0) {
			sql.closeDB();
			return true;
		}
		sql.closeDB();

		return false;
	}
	
	public Boolean CallStay(String stuID,String username,String apartment,String dormitory,String detail) {

		// 获取Sql查询语句
		String regSql = "insert into tb_callstay (id,stuID,realname,apartment,dormitory,detail) values(null" + ",'"
				+ stuID + "','" + username + "','"+apartment+"','"+dormitory+"','" +detail+ "')";
		
		
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.getConnection();
		
		int ret = sql.executeUpdate(regSql);
//		System.out.println("test"+ ret);
		if (ret != 0) {
			sql.closeDB();
			return true;
		}
		sql.closeDB();

		return false;
	}
	
	public Boolean CallModify(String stuID,String username,String stuPW,String sex,String school,int apartment,int dormitory,String major) {

		// 获取Sql查询语句
		// 参考   UPDATE Person SET Address = 'Zhongshan 23', City = 'Nanjing' WHERE LastName = 'Wilson'
		
		String sql1 = "Update tb_stuinfo set stuPW = '"+stuPW+"', stuname = '"+ username +"' , stusex = '"+sex+"',stumajor = '"+major+"'  where stuId = '"+stuID+"'";
		
		
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.getConnection();
		
		int ret = sql.executeUpdate(sql1);
//		System.out.println("test"+ ret);
		if (ret != 0) {
			sql.closeDB();
			return true;
		}
		sql.closeDB();

		return false;
	}
	
	public String getAnnounce() {

		// 获取Sql查询语句
		String logSql = "select * from tb_announce";
		Announce ann  = new Announce();

		String RS = "";
		DBManager sql = DBManager.createInstance();
		sql.getConnection();

		
		try {
			ResultSet rs = sql.executeQuery(logSql);
			//User user = new User();
			
			while (rs.next()) {
				RS = RS+rs.getString("id")+"    ";
				RS = RS+rs.getString("details")+"  ";
				RS = RS+rs.getString("time")+"\n";
			}
			return RS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return null;
	}
	
	public String getMyLostInfo(String stuID) {

		// 获取Sql查询语句
		String logSql = "select * from tb_lostinfo where stuID = " + "'"+stuID+"'";
		//Announce ann  = new Announce();

		String RS = "";
		int i = 1;
		DBManager sql = DBManager.createInstance();
		sql.getConnection();

		
		try {
			ResultSet rs = sql.executeQuery(logSql);
			//User user = new User();
			
			while (rs.next()) {
				RS = RS+i+"  ";
				RS = RS+rs.getString("stuID")+"  ";
				RS = RS+rs.getString("realname")+"  ";
				RS = RS+rs.getString("detail")+"\n";
				i++;
			}
			return RS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return null;
	}
	
	public String getMyfixInfo(String stuID) {

		// 获取Sql查询语句
		String logSql = "select * from tb_callfix where stuID = " + "'"+stuID+"'";
		//Announce ann  = new Announce();

		String RS = "";
		int i = 1;
		DBManager sql = DBManager.createInstance();
		sql.getConnection();

		
		try {
			ResultSet rs = sql.executeQuery(logSql);
			//User user = new User();
			
			while (rs.next()) {
				RS = RS+i+"  ";
				RS = RS+rs.getString("stuID")+"  ";
				RS = RS+rs.getString("realname")+"  ";
				RS = RS+rs.getString("detail")+"\n";
				i++;
			}
			return RS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return null;
	}
	
	public String getMyapplyInfo(String stuID) {

		// 获取Sql查询语句
		String logSql = "select * from tb_callstay where stuID = " + "'"+stuID+"'";
		//Announce ann  = new Announce();

		String RS = "";
		int i = 1;
		DBManager sql = DBManager.createInstance();
		sql.getConnection();

		
		try {
			ResultSet rs = sql.executeQuery(logSql);
			//User user = new User();
			
			while (rs.next()) {
				RS = RS+i+"  ";
				RS = RS+rs.getString("stuID")+"  ";
				RS = RS+rs.getString("realname")+"  ";
				RS = RS+rs.getString("detail")+"\n";
				i++;
			}
			return RS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return null;
	}
	public String getMyexchange(String stuID) {

		// 获取Sql查询语句
		String logSql = "select * from tb_applyexchange where stuID = " + "'"+stuID+"'";
		//Announce ann  = new Announce();

		String RS = "";
		int i = 1;
		DBManager sql = DBManager.createInstance();
		sql.getConnection();

		
		try {
			ResultSet rs = sql.executeQuery(logSql);
			//User user = new User();
			
			while (rs.next()) {
				RS = RS+i+"  ";
				RS = RS+rs.getString("stuID")+"  ";
				RS = RS+rs.getString("realname")+"  ";
				RS = RS+rs.getString("targetApart")+"  ";
				RS = RS+rs.getString("targetRoom")+"  ";
				RS = RS+rs.getString("reason")+"\n";
				i++;
			}
			return RS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return null;
	}
	
	public String getLostInfo() {

		// 获取Sql查询语句
		String logSql = "select * from tb_lostinfo";
		//Announce ann  = new Announce();

		String RS = "";
		DBManager sql = DBManager.createInstance();
		sql.getConnection();

		
		try {
			ResultSet rs = sql.executeQuery(logSql);
			//User user = new User();
			
			while (rs.next()) {
				RS = RS+rs.getString("id")+"    ";
				RS = RS+rs.getString("stuID")+"  ";
				RS = RS+rs.getString("realname")+"  ";
				RS = RS+rs.getString("detail")+"\n";
			}
			return RS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return null;
	}
	
	public String getOld() {

		// 获取Sql查询语句
		String logSql = "select * from tb_oldthing";
		//Oldthing RS = new Oldthing();

		String RS = "";
		DBManager sql = DBManager.createInstance();
		sql.getConnection();

		
		try {
			ResultSet rs = sql.executeQuery(logSql);
			//User user = new User();
			
			while (rs.next()) {
				RS = RS+rs.getString("id")+"    ";
				RS = RS+rs.getString("oldinfo")+"       ";
				RS = RS+rs.getString("date")+"\n"+"\n";
			}
			return RS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return null;
	}
	public String getRoom() {

		// 获取Sql查询语句
		String logSql = "select * from tb_room";
		//Oldthing RS = new Oldthing();

		String RS = "";
		DBManager sql = DBManager.createInstance();
		sql.getConnection();

		
		try {
			ResultSet rs = sql.executeQuery(logSql);
			//User user = new User();
			
			while (rs.next()) {
				RS = RS+rs.getString("id")+"    ";
				RS = RS+rs.getString("apartment")+"       ";
				RS = RS+rs.getString("roomnum")+"\n";
			}
			return RS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return null;
	}
	
}
