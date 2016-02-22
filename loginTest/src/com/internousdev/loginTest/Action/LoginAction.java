/**
 *
 */
package com.internousdev.loginTest.Action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.loginTest.DAO.LoginDAO;
import com.internousdev.loginTest.DTO.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author WATARU KUME
 * @version 1.0
 * @since 1.0
 *
 */

public class LoginAction extends ActionSupport implements SessionAware{

	/**
	 *
	 */
	private static final long serialVersionUID = 4177149522688148288L;

	private String Id;

	private String Password;

	private Map<String,Object> session;



	/**
	 *ログイン処理を行うメソッド
	 *@return String 結果はログインできればSUCCESS、できなければERRORを返します。
	 */
	public String execute(){
		LoginDAO dao = new LoginDAO();
		if(!dao.select(Id, Password)){
			return ERROR;
		}
		LoginDTO dto = new LoginDTO();
		dto = dao.getDto();
		session.put("Id", dto.getId());
		session.put("Password", dto.getPassword());


		return SUCCESS;
	}


	/**
	 * ID取得メソッド
	 * @return ID
	 */
	public String getId() {
		return Id;
	}

	/**
	 * Id格納メソッド
	 * @param Id
	 */
	public void setId(String Id) {
		this.Id = Id;
	}

	/**
	 * パスワード取得メソッド
	 * @return password
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

	/**
	 * セッション取得メソッド
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * セッション格納メソッド
	 * @param session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
