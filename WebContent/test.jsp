<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/test.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">	
	var i =0;
	function shoe_show(name){		
		$.ajax({
			url:"MenscasualServlet",
			type:"POST",
			data:"name="+name,
			dataType:"json",
			success:function(data){	
/* 				for(i=0;i<data.length;i++){
					$("#dd"+(i+1)+">img").attr("src",data[i].path);
					$("#dd"+(i+1)+">p:eq(0)").html(data[i].name);
					$("#dd"+(i+1)+">span:eq(0)").html(data[i].price);
					$("#dd"+(i+1)+">span:eq(0)").attr("class","glyphicon glyphicon-yen");
					$("#dd"+(i+1)+">span:eq(1)").html(data[i].moods);
					$("#dd"+(i+1)+">span:eq(1)").attr("class","glyphicon glyphicon-thumbs-up");
					$("#dd"+(i+1)+">p:eq(1)").html("加入购物车");
					$("#dd"+(i+1)+">p:eq(1)").attr("class","glyphicon glyphicon-shopping-cart");
				} */			
				var name="";
		 		for(i=0;i<data.length;i++){
					name += "<div>"
					+"<img src='"+data[i].path+"'>"
					+"<p>"+data[i].name+"</p>"
					+"<span class='glyphicon glyphicon-yen'>"+data[i].price+"</span>"
					+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					+"<span class='glyphicon glyphicon-thumbs-up' onclick='ss()' name='dd'>"+data[i].moods+"</span>"
					+"<p class='glyphicon glyphicon-shopping-cart'>加入购物车</p>"
					+"</div>";
				}			
				$("#d1").html(name);
			}
		});
	}
	var dream = null;
	function a(){
		var list = document.getElementsByName("check");
		var rom = parseInt(1+Math.random()*3);
		shoe_show(list[rom].innerText);		
	}
	function b(){
		dream = setInterval("a()", 1000);
	}
	function c(){
		clearInterval(dream);
	}
	$(document).ready(function(){
		b();
		$("#d2>span").mouseover(function(){	
			$(this).addClass("span");
			$(this).css("cursor","pointer");
			var name = $(this).text();	
			shoe_show(name);
			c();
		}).mouseout(function(){
			$(this).removeClass("span");
			$(this).css("cursor","default");
		});
		$("#d1 span").mouseover(function(){	
			$(this).css({"cursor":"pointer","color":"red"});		
		}).mouseout(function(){		
			$(this).css({"cursor":"default","color":"black"});			
		});
		$("#d1 p").mouseover(function(){				
			$(this).css({"cursor":"pointer","color":"red"});	
		}).mouseout(function(){			
			$(this).css({"cursor":"default","color":"black"});
		});
		$(".moods").click(function(){
			var moods = $(this).text();
			alert(moods);
		})
	});
</script>
</head>
<body>
	<div id="d3">
 	<div id="d1"></div>
	<div id="d2">
		<span name="check">男式休闲鞋</span>
		<span name="check">男式运动鞋</span>
		<span name="check">女式休闲鞋</span>
		<span name="check">女式运动鞋</span>	
	</div>
	</div>
</body>
</html>