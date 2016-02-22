<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang = ja>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p class="form-title">ログイン</p>
	<s:form action="LoginAction">
		<div id="form">
			<h2>下記に情報を入力してください。</h2>
			<br>

			<table>
				<tr>
					<td>

						<h4>
							ID :
							<s:textfield name="Id" />
						</h4>
					</td>
				</tr>

				<tr>
					<td>
						<h4>
							パスワード :
							<s:password name="Password" />
						</h4>
					</td>
				</tr>

			</table>

			<s:submit align="center" class="button9" type="button" value="ログイン" />
	<br>
	<br>
	</div>
	</s:form>




</body>
</html>