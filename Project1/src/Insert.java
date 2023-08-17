import java.sql.*;
public class Insert {
	public static void main(String []args)throws Exception{
		select();
	}
	public void getconnectivity() throws SQLException{
		String url = "jdbc:mysql://127.0.0.1:3306/Appolopharmacy";
		String username = "root";
		String password = "1811";
		String Query = "insert into products values(?,?,?,?,?,?)";
		
		Connection con=DriverManager.getConnection(url, username, password);
		PreparedStatement pst=con.prepareStatement(Query);
		pst.setInt(1, 18);
		pst.setString(2, "Paracetamol");
		pst.setInt(3, 12);
		pst.setInt(4, 10);
		pst.setString(5, "16-08-2023");
		pst.setString(6, "18-11-2023");
		pst.executeUpdate();
		con.close();
	}
	public static void select() throws SQLException{
		String url = "jdbc:mysql://127.0.0.1:3306/Appolopharmacy";
		String username = "root";
		String password = "1811";
		String Query = "select*from products";
		
		Connection con=DriverManager.getConnection(url, username, password);
		Statement smt = con.createStatement();
		ResultSet rs=smt.executeQuery(Query);
		while(rs.next()) {
			System.out.println("product id:"+rs.getInt(1));
			System.out.println("product name:"+rs.getString(2));
			System.out.println("product price:"+rs.getString(3));
			System.out.println("product quantity:"+rs.getString(4));
			System.out.println("product manufacturedate:"+rs.getString(5));
			System.out.println("product experydate:"+rs.getString(6));
		}
		con.close();
	}
	public static void update() throws SQLException{
		String url = "jdbc:mysql://127.0.0.1:3306/Appolopharmacy";
		String username = "root";
		String password = "1811";
		String Query = "update products set name='Dolo650'; where id = 18";
		String Query1 = "update products set quantity = 15 where id = 18";
		Connection con=DriverManager.getConnection(url,username,password);
		PreparedStatement pst=con.prepareStatement(Query1);
		int pharmacyitems = pst.executeUpdate();
		System.out.println(pharmacyitems);
		con.close();
		}
	public static void select1() throws SQLException{
		String url="jdbc:mysql://127.0.0.1:3306/Applopharmacy";
		String username="root";
		String password="1101";
		String Query="select*from products where price=12 ";
		
		Connection con=DriverManager.getConnection(url,username,password);
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery(Query);
		while(rs.next()) {
			String pharmacy=rs.getString("name");
			int items=rs.getInt("quantity");
			System.out.println("product name:"+pharmacy);
			System.out.println("product quantity:"+items);
		}
		
		con.close();
		
	}
	

}
