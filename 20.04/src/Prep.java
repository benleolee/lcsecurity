import java.sql.*;
public class Prep { // ������Perp
	static Connection con; // ����Connection����
	static PreparedStatement sql; // ����Ԥ��������
	static ResultSet res; // �������������
	public Connection getConnection() { // �����ݿ����ӷ���
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
		return con; // ����Connection����
	}
	
	public static void main(String[] args) { // ������
		Prep c = new Prep(); // �����������
		con = c.getConnection(); // ��ȡ�����ݿ������
		try {
//			// ʵ����Ԥ��������
//			sql = con.prepareStatement("select * from tb_stu"
//					+ " where id = ?");
//			sql.setInt(1, 19); // ���ò���
//			res = sql.executeQuery(); // ִ��Ԥ�������
//			// �����ǰ��¼���ǽ���������һ�У������ѭ����
//			while (res.next()) {
//				String id = res.getString(1); // ��ȡ������е�һ�е�ֵ
//				String name = res.getString("name"); // ��ȡname�е���ֵ
//				String sex = res.getString("sex"); // ��ȡsex�е���ֵ
//				// ��ȡbirthday�е���ֵ
//				String birthday = res.getString("birthday");
//				System.out.print("��ţ�" + id); // �����Ϣ
//				System.out.print(" ������" + name);
//				System.out.print(" �Ա�:" + sex);
//				System.out.println(" ���գ�" + birthday);
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
//				System.out.println("��ţ�" + id);
//				System.out.print(" ������" + name);
//				System.out.print(" ��ַ��" + address);
//				System.out.println(" ���У�" + city);
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
			sql.setInt(1, (int)Math.random()*100); // Ԥ������������
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
//			sql.setString(1, "2012-12-02"); // ��������
//			sql.executeUpdate();
//			Statement stmt = con.createStatement();
//			stmt.executeUpdate("delete from tb_stu where id = "
//					+ "(select min(id)from tb_stu)");
//			// ��ѯ�޸����ݺ��tb_stu��������
			sql = con.prepareStatement("select * from orders");
			res = sql.executeQuery(); // ִ��SQL���
			System.out.println("ִ�����ӡ��޸ġ�ɾ���������:");
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
//				System.out.println("��ţ�" + id);
//				System.out.print(" ������" + name);
//				System.out.print(" ��ַ��" + address);
//				System.out.println(" ���У�" + city);
//				System.out.println(email);
			} 
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}