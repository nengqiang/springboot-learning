$(document).ready(function () {

    $("#btn-search").click(function () {
       searchAndShow();
    });

    // 回车键模拟点击搜索按钮作用
    $("input").keydown(function () {
        // keyCode=13是回车键
        if (event.keyCode == "13") {
            $("#btn-search").trigger("click");
        }
    });

    function searchAndShow() {
        var idStart = $("#idStart").val();
        var idEnd = $("#idEnd").val();
        console.log("idStart: " + idStart + ", length: " + idStart.length);
        console.log("idEnd: " + idEnd + ", length: " + idEnd.length);

        if (idStart.length && idEnd.length) {
            var data = {"idStart" : idStart, "idEnd" : idEnd};
            $.ajax({
               type: "GET",
               url: "/getData/getBaiduHotChartData",
               data: data,
               dataType: "json",
               success: function(r) {
                   if (r.code == 0) {
                       var map = r.result[0];
                       console.log(map);
                       var i = 1;
                       for (var key in map) {
                           var myChart = echarts.init(document.getElementById("container" + i));
                           i++;
                           var title = key;
                           var data = map[key];
                           var timeAxis = data.timeAxis;
                           var increment1 = data.increment1;
                           var increment2 = data.increment2;
                           var increment3 = data.increment3;
                           var option = {
                               title: {
                                   text: title
                               },
                               tooltip: {
                                   trigger: 'axis'
                               },
                               legend: {
                                   data: ['增长率A', '增长率B', '增长率C']
                               },
                               grid: {
                                   left: '3%',
                                   right: '3%',
                                   bottom: '3%',
                                   containLabel: true
                               },
                               xAxis: {
                                   type: 'category',
                                   boundaryGap: false,
                                   data: timeAxis
                               },
                               yAxis: {
                                   type: 'value'
                               },
                               series: [
                                   {
                                       name:'增长率A',
                                       type:'line',
                                       smooth: true,
                                       data: increment1
                                   },
                                   {
                                       name:'增长率B',
                                       type:'line',
                                       smooth: true,
                                       data: increment2
                                   },
                                   {
                                       name:'增长率C',
                                       type:'line',
                                       smooth: true,
                                       data: increment3
                                   }
                               ]
                           };
                           myChart.setOption(option);
                           window.addEventListener("resize", function() {
                               myChart.resize();
                           });
                       }
                   } else {
                       alert(r.msg);
                   }
               },
               error: function() {
                   alert("获取数据失败");
               }
            });
        } else {
            alert("无该id范围内的数据！");
        }

    }

});