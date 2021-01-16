
	package application;
	import java.sql.*;
	import dbUtil.dbConnection;

	public class LoginModel {
		Connection connection;
		public LoginModel() { //v�rifier si la base de donn�es est connect�e 
	connection = dbConnection.getConnection();
	if(connection == null) {
		System.out.println("connection not successful");
		System.exit(1);}
		}
		
		public boolean isDatabaseConnected() {
		try {
			return !connection.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		}
		
		public boolean isLogin(String user,String pass,String opt) throws Exception {
			//si la connection avec la base de donn�es a �t� �tablie don on continue avec l'authentification
			PreparedStatement pr = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM login where username = ? and password = ? and division = ?";
			
			try {
				
				pr = this.connection.prepareStatement(sql);//pr�parer la connction avec la base de donn�es
				pr.setString(1, user); //remplacer le username dans la requ�te sql par la variable user
				pr.setString(2, pass); //remplacer le password dans la requ�te sql par la variable pass
				pr.setString(3, opt);  //remplacer la division dans la requ�te sql par la variable opt
				
				rs = pr.executeQuery();//ex�cuter la requ�te sql
				
			
				if(rs.next()) {
					return true; //v�rifier si les infos existent
				}
					return false;
				
			} catch (SQLException ex) {
				return false;
				
			}
			finally {
				pr.close();
				rs.close();
			}
		}
		
	}
		



