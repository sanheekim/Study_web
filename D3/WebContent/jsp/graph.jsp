<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>D3 Graph Practice</title>
<script src="https://d3js.org/d3.v3.min.js"></script>
<script type="text/javascript">
/***** 하프 도넛 차트 *****/

var w1 = 300, h1 = 300;
var graphData1 = [56, 44];

// svg 태그 생성
var svg = d3.select(".graph01")
			.append("svg")
			.attr("width",w1)
			.attr("height",h1);
			
var group1 = svg.append("g")
				.attr("transform","translate("+w1/2","+h1/2+")");
				
var radius = Math.min(w1, h1) /2;

var arc1 = d3.svg.arc()
			.innerRadius(80)
			.outerRadius(radius-10);

var pie1 = d3.layout.pie()
			.startAngle(-90 * (Math.PI/180))
			.endAngle(90 * (Math.PI/180))
			// .padAngle(.02) // 값들 사이에 공백 넣기
			.value(function(d) {
				return d;
			});

var arcs1 = group1.selectAll(".arc1")
				.data(pie1(graphData1))
				.enter()
				.append("g")
				.attr("class", "arc1");

var colorData1 = d3.scale.ordinal()
					.range(["hotpink", "lightgray"]);

// 검은 하프도넛
arcs1.append("path")
	.attr("d", arc1)
	.attr("fill", function(d) {
		// 색상 추가
		return colorData1(d.data);
	});
	
// ★ 폰트 살짝 위로 올리기
arcs1.append("text")
	.attr("dy", ".35em")
	.attr("text-anchor", "middle")
	.text(function(d) {
		return "하프도넛";
	});



/***** 도넛 차트 *****/
var w2 = 300, h2 = 300;
var graphData2 = [35, 30, 10];

// svg 태그 생성
var svg = d3.select(".graph02")
			.append("svg")
			.attr("width",w2)
			.attr("height",h2);
			
// 원 그리기, g=group
// svg 태그 밑에 <g ransform="translate(150,150)"> 생성
var group2 = svg.append("g")
				.attr("transform","translate("+w2/2","+h2/2+")");
				
// arc : 호
var arc2 = d3.svg.arc()
			.innerRadius(80)
			.outerRadius(150);

// 여기서 startAngle, endAngle 넣으면 하프도넛차트 됨
var pie2 = d3.layout.pie()
			.value(function(d) {
				return d;
			});
			
// 그 밑에 <g class="arc"></g> 생성
var arcs2 = group2.selectAll(".arc")
				.data(pie2(graphData2))
				.enter()
				.append("g")
				.attr("class","arc");

// 색상 추가
var colorData2 = d3.scale.ordinal()
					.range(["green","blue","skyblue"]);

// ★ 텍스트 추가
arcs2.append("text")
	.attr("transform", function(d) {
		return "translate(" + arc2.centroid(d) + ")";
	})
	.attr("text-anchor","middle")
	.attr("text-size","10px")
	.text(function(d){
		return d.data+"건";
	})
	
// 도넛차트 중앙에 텍스트 추가
arcs2.append("text")
	.attr("dy", ".35em")
	.attr("text-anchor", "middle")
	.text(function(d){
		return "도넛차트";
	});
	
// 검은색 도넛 차트 생성
// "fill": 색상 추가
arcs2.append("path")
	.attr("d", arc)
	.attr("fill",function(d){
		return colorData2(d.data);
	});

</script>
<style>
	.arc1 text {
		font-family: arial;
		font-size: 22px;
		color: black;
		font-weight: bold;
	}
	
	.arc text {
		font-family: arial;
		font-size: 22px;
		color: black;
		font-weight: bold;
	}
</style>
</head>
<body>

	<div class='graph01'></div>
	<div class='graph02'></div>
	
</body>
</html>