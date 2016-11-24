<%@page import="model.TimeDAO,control.RoundRobinTournament,java.util.Arrays"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%
 		TimeDAO timeDAO = new TimeDAO();
 		RoundRobinTournament rrt = new RoundRobinTournament();
 %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Escala de Jogos</title>
		<c:import url = "padroes/head.html"/>
		<script>
		$(document).ready(function(){
			$('.bxslider').bxSlider({
				 captions: true
				});
		});
			
		</script>
	</head>
	
	<body>
		<section align="center">
			<br>
				<h2>Escala de Jogos</h2>
			<br>

		<ul class="bxslider">
			
		<% int i =0;
		   String[][] s = rrt.tournament(timeDAO.nomesTimes());
		   
		
	       for(int x = 0 ; x < s.length;x++){
	    	   	i=(s[x].length/2);
	       		
	       %>
			<li >
				<div >
						<h3>Rodada <%=x+1%></h3>
				</div>
				<div  class ="container" >
								
					<table  class="table table-striped">
						<th>Time casa</th>
						<th>Time contra</th>
						<%for(int j=0;j<s[x].length/2;j++){ %>
							<tr><td><%=s[x][j]%></td><td><%=s[x][i]%></td></tr>
						
						<%i++;} %>
					</table>
			
			
			</div></li>
		<%} %>
		
		</ul>



	</section>
		
	</body>
</html>
