import java.sql.*;
public class Prep { // 创建类Perp
	static Connection con; // 声明Connection对象
	static PreparedStatement sql; // 声明预处理对象
	static ResultSet res; // 声明结果集对象
	public Connection getConnection() { // 与数据库连接方法
		try {
//			Class.forName("net.sourceforge.jtds.jdbc.Driver");
//			con = DriverManager.getConnection(
//					"jdbc:jtds:sqlserver://localhost:1433/" + "db_jdbc",
//					"sa", "");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test?useSSL=false"
					,"root","qwerty");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con; // 返回Connection对象
	}
	
	public static void main(String[] args) { // 主方法
		Prep c = new Prep(); // 创建本类对象
		con = c.getConnection(); // 获取与数据库的连接
		try {
//			// 实例化预处理对象
//			sql = con.prepareStatement("select * from tb_stu"
//					+ " where id = ?");
//			sql.setInt(1, 19); // 设置参数
//			res = sql.executeQuery(); // 执行预处理语句
//			// 如果当前记录不是结果集中最后一行，则进入循环体
//			while (res.next()) {
//				String id = res.getString(1); // 获取结果集中第一列的值
//				String name = res.getString("name"); // 获取name列的列值
//				String sex = res.getString("sex"); // 获取sex列的列值
//				// 获取birthday列的列值
//				String birthday = res.getString("birthday");
//				System.out.print("编号：" + id); // 输出信息
//				System.out.print(" 姓名：" + name);
//				System.out.print(" 性别:" + sex);
//				System.out.println(" 生日：" + birthday);
			sql = con.prepareStatement("select *  from orders ");
//			sql.setInt(parameterIndex, x);
//			sql.setInt(1,10003);
			res = sql.executeQuery();
			while( res.next() ){
//				String id = res.getString("cust_id");
//				String name = res.getString(2);
//				String address = res.getString(3);
//				String city = res.getString("cust_city");
//				String email = res.getString("cust_email");
//				System.out.println("编号：" + id);
//				System.out.print(" 姓名：" + name);
//				System.out.print(" 地址：" + address);
//				System.out.println(" 城市：" + city);
//				System.out.println(email);
				String num = res.getString("order_num");
				String date = res.getString("order_date");
				String id = res.getString("cust_id");
				System.out.print("   order_num:" + num);
				System.out.print("    order_date:" + date);
				System.out.print("     cust_id:" + id);
				System.out.println();
			} 
			System.out.println();
			System.out.println();
		
			sql = con.prepareStatement("insert into orders "
					+ "values(?,?,?)");
			sql.setInt(1, (int)Math.random()*100); // 预处理添加数据
			sql.setString(2, "2015-12-10");
			sql.setString(3, "10006");
//			sql.setString(4, "guangzhou");
//			sql.setString(5, "china");
//			sql.setString(6, "cust_zip");
//			sql.setString(7, "country");
//			sql.setString(8, "contact");
//			sql.setString(9, null);
			sql.executeUpdate();
//			sql = con.prepareStatement("update tb_stu set birthday "
//					+ "= ? where id = (select min(id) from tb_stu)");
//			sql.setString(1, "2012-12-02"); // 更新数据
//			sql.executeUpdate();
//			Statement stmt = con.createStatement();
//			stmt.executeUpdate("delete from tb_stu where id = "
//					+ "(select min(id)from tb_stu)");
//			// 查询修改数据后的tb_stu表中数据
			sql = con.prepareStatement("select * from orders");
			res = sql.executeQuery(); // 执行SQL语句
			System.out.println("执行增加、修改、删除后的数据:");
			while( res.next() ){
				String num = res.getString("order_num");
				String date = res.getString("order_date");
				String id = res.getString("cust_id");
				System.out.print("   order_num:" + num);
				System.out.print("    order_date:" + date);
				System.out.print("     cust_id:" + id);
				System.out.println();
//				String id = res.getString("cust_id");
//				String name = res.getString(2);
//				String address = res.getString(3);
//				String city = res.getString("cust_city");
//				String email = res.getString("cust_email");
//				System.out.println("编号：" + id);
//				System.out.print(" 姓名：" + name);
//				System.out.print(" 地址：" + address);
//				System.out.println(" 城市：" + city);
//				System.out.println(email);
			} 
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
