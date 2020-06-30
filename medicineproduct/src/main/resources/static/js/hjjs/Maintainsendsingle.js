layui.use(['laydate', 'jquery', 'table'], function () {
    var laydate = layui.laydate,
        $ = layui.jquery,
        table = layui.table;
    table.render({
        elem: '#test'
        , url: '/hj/getdistributeleaflets'
        , cols: [[
            {type: 'checkbox'}
            , {field: 'did', title: '派单序号'}
            , {field: 'sname', title: '员工', templet: '<span>{{d.staff.sname}}</span>'}
            , {field: 'customerName', title: '客户', templet: '<span>{{d.customer.customerName}}</span>'}
            , {field: 'endDate', title: '截止完成日期'}
        ]]
        , page: true
        , limit: 3
        , id: 'testReload'
    });
    $("#sosuo").on('click', function () {
        table.reload('testReload', {
            where: { // 设定异步数据接口的额外参数，任意设
                name: $("#name").val(),

                // …
            },
            page: {
                curr: 0
                // 重新从第 1 页开始
            }
        });
    })
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        //console.log(obj)
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        } else if (obj.event === 'edit') {
            layer.prompt({
                formType: 2
                , value: data.email
            }, function (value, index) {
                obj.update({
                    email: value
                });
                layer.close(index);
            });
        }
    });
    //跳新增页面
    $("#dianji").click(function () {
        layer.open({
            type: 2,
            content: 'addMaintainsendsingle.html', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            title: "新增保养派单",
            area: ['700', '600px']
        });
    });
    $("#xiugai").click(function(){
        var checkStatus = table.checkStatus("testReload");
        var data = checkStatus.data;
        var ids=0;
        if (data.length==1) {
            $(data).each(function (i, o) {//o即为表格中一行的数据
                ids=o.did;
            });
            layer.open({
                type: 2,
                content: '/hj/update?id='+ids, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                title: "修改保养派单",
                area: ['700', '600px']
            });
        }else if(data.length>=2){
            layer.alert("只可以选择一条值修改");
        }else{
            layer.alert("请选择一条值修改");
        }
    })
    $("#shancu").click(function(){
        sss();
    })
    function sss(){
        var checkStatus = table.checkStatus("testReload");
        var data = checkStatus.data;
        var ids = new Array();
            if (data.length>0) {
                $(data).each(function (i, o) {//o即为表格中一行的数据
                    ids.push(o.did);
                });
                layer.confirm('真的删除行么', function (index) {
                    $.ajax({
                        url : "/hj/shancu",
                        type : "post",
                        data : {
                            ids : ids
                        },
                        traditional : true,
                        dataType : "text",
                        success : function(e) {
                            if (e == "yes") {
                                layer.alert("删除成功");

                                layer.close(index);
                                table.reload('testReload');
                            }else{
                                layer.alert("删除失败");
                            }
                        }
                    })
                });
            }else{
                layer.alert("请选择值");
            }

    }
});