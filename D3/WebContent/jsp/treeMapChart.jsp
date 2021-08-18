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
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://d3js.org/d3.v3.min.js"></script>
<script src="https://cdn.jsdelivr.net/gh/bumbeishvili/d3-tip-for-v6@4/d3-tip.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/bumbeishvili/d3-tip-for-v6@4/d3-tip.min.css">
<script src='https://cdn.plot.ly/plotly-2.3.1.min.js'></script> <!-- 트리맵 -->
<script type="text/javascript">
$(document).ready(function() {

	var labels = ["Eve", "Cain", "Seth", "Enos", "Noam", "Abel", "Awan", "Enoch", "Azura"]
	var parents = ["", "Eve", "Eve", "Seth", "Seth", "Eve", "Eve", "Awan", "Eve"]
	var data = [{
	      type: "treemap",
	      labels: labels,
	      parents: parents,
	      values:  [10, 14, 12, 10, 2, 6, 6, 1, 4],
	      textinfo: "label+value+percent parent+percent entry",
	      domain: {"x": [0, 0.48]},
	      outsidetextfont: {"size": 20, "color": "#377eb8"},
	      marker: {"line": {"width": 2}},
	      pathbar: {"visible": false}
	    },{
	      type: "treemap",
	      branchvalues: "total",
	      labels: labels,
	      parents: parents,
	      domain: {x: [0.52, 1]},
	      values: [65, 14, 12, 10, 2, 6, 6, 1, 4],
	      textinfo: "label+value+percent parent+percent entry",
	      outsidetextfont: {"size": 20, "color": "#377eb8"},
	      marker: {"line": {"width": 2}},
	      pathbar: {"visible": false}
	    }];
	var layout = {
	  annotations: [{
	    showarrow: false,
	    text: "branchvalues: <b>remainder</b>",
	    x: 0.25,
	    xanchor: "center",
	    y: 1.1,
	    yanchor: "bottom"
	    }, {
	    showarrow: false,
	    text: "branchvalues: <b>total</b>",
	    x: 0.75,
	    xanchor: "center",
	    y: 1.1,
	    yanchor: "bottom"
	    }]}

	Plotly.newPlot('myDiv', data, layout)

});
</script>
</head>
<body>

	<div id='myDiv'></div>
	
</body>
</html>