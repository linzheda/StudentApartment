<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="margin-left:250px;margin-top:30px;">
	<form action="../admin.action?op=visitorRegister" method="post">
		<h1 style="margin-left:20px;">来访人员登记</h1>
		<table>
			<tr>
				<td><label>姓名：</label></td>
				<td><input type="text" name="vname" id="vname"></td>
			</tr>
			<tr>
				<td><label>性别：</label></td>
				<td><input type="radio" name="vsex" id="vsex" value="男"
					checked="checked"> 男 <input type="radio" name="vsex"
					id="vsex" value="女"> 女</td>
			</tr>
			<tr>
				<td><label>电话：</label></td>
				<td><input type="text" name="vtel" id="vtel"></td>
			</tr>
			<tr>
				<td><label>来访原因：</label></td>
				<td><input type="text" name="clause" id="clause"></td>
			</tr>
			<tr>
				<td><label>备注：</label></td>
				<td><input type="text" name="ps" id="ps" value="无"></td>
			</tr>
			<tr>
				<td><label>到访的寝室id:</label></td>
				<td><input type="text" name="bid" id="bid"></td>
			</tr>
			
		</table>
		<input type="submit" value="提交">
	</form>
</div>