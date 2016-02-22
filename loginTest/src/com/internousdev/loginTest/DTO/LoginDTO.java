
package com.internousdev.loginTest.DTO;

/**
 * ログインでユーザー情報を格納する為のDTOクラス
 * @author KATUSAKA KOTAKI
 * @since 1.0
 * @version 1.0
 */

public class LoginDTO {
	/**
	 * ユーザーID
	 */
	private int Id;


	/**
	 * パスワード
	 */
	private String Password;

	/**
	 * ユーザーID取得メソッド
	 * @return user_id
	 */
	public int getId() {
		return Id;
	}
	/**
	 * ユーザーID格納メソッド
	 * @param Id
	 */
	public void setId(int Id) {
		this.Id = Id;
	}

	/**
	 * パスワード取得メソッド
	 * @return Password
	 */
	public String getPassword() {
		return Password;
	}


	/**
	 * パスワード格納メソッド
	 * @param password
	 */
	public void setPassword(String Password) {
		this.Password = Password;
	}
}