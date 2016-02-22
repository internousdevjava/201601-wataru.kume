package com.internousdev.loginTest.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.loginTest.DTO.LoginDTO;
import com.internousdev.loginTest.util.DBConnector;

/**
 * @author WATARU KUME
 * @since 1.0
 * @version 1.0
 */

/**
 * データベースとやり取りしてユーザーが登録されているか確認するクラス
 */
public class LoginDAO {
	/**
	 * データベースから取得した情報を格納するDTO
	 */
	LoginDTO dto = new LoginDTO();

	/**
	 * @param Id
	 * @param Password
	 * @return boolean mail_addressとpasswordが登録されているかで値を返します。
	 */
	public boolean select(String Id, String Password){
		Connection con = DBConnector.getConnection("loginTest");
		String sql = "SELECT * FROM user WHERE id=? AND password=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, Id);
			ps.setString(2, Password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				dto.setId(rs.getInt("Id"));
				dto.setPassword(rs.getString("Password"));
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	/**
	 * DTO取得メソッド
	 * @return DTO
	 */
	public LoginDTO getDto() {
		return dto;
	}
}