<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<div class='layer'></div>
<article class="box post post-excerpt" id="pop">
	<section class="box recent-posts">
		<table>
			<thead>
				<tr>
					<th colspan="2">
						<h3>이슈 보기</h3>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>중요도</th>
					<td>
						<select id="priority" class="2click">
							<option disabled value="VERYHIGH">VERY HIGH</option>
							<option disabled value="HIGH">HIGH</option>
							<option disabled value="MEDIUM">MEDIUM</option>
							<option disabled value="LOW">LOW</option>
							<option disabled value="VERYLOW">VERY LOW</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>이슈 제목</th>
					<td><input type="text" id="title" class="2click" readonly></td>
				</tr>
				<tr>
					<th>이슈 내용</th>
					<td><input type="text" id="text" class="2click" readonly></td>
				</tr>
				<tr>
					<th>책임자</th>
					<td>
						<select id="charger" class="2click">
						</select>
					</td>
				</tr>
				<tr>
					<th>이슈기한</th>
					<td><input type="date" class="2click" id="startline" readonly>
						~ <input type="date" class="2click" id="deadline" readonly></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<button id="detail_back">돌아가기</button>
						<button id="issue_del">삭제</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</section>
</article>