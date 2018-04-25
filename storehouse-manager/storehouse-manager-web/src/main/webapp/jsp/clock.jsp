
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/clock.css" media="screen" type="text/css" />
 </head>
<body> 
        <div class="t4">
            <i class="hour hour3">3</i>
            <i class="hour hour6">6</i>
            <i class="hour hour9">9</i>
            <i class="hour hour12">12</i>

            <div id="miao"></div>
            <div id="fen"></div>
            <div id="shi"></div>
            <div id="point"></div>
        </div>

<script type="text/javascript">
    var miao = document.getElementById("miao");
    var fen = document.getElementById("fen");
    var shi = document.getElementById("shi");

    var clock = setInterval(function () {
        var nowDate = new Date();//æ¯æ¬¡è¯»åå½åæ¶é´
        var hour = nowDate.getHours();
        var minute = nowDate.getMinutes();
        var second = nowDate.getSeconds();

        var circleHour = hour % 12 * 30;
        shi.style.transform = "rotate(" + circleHour + "deg)";//è¯»åå°çæ¶é´ä¸º24å°æ¶å¶ï¼è½¬æ¢ä¸º12å°æ¶
        fen.style.transform = "rotate(" + minute * 6 + "deg)";
        miao.style.transform = "rotate(" + second * 6 + "deg)";
    }, 1000);
</script>

</body>
</html>























