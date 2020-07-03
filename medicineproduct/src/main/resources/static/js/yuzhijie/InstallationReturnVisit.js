layui.use(['laydate', 'jquery', 'table'], function () {
    var laydate = layui.laydate,
        $ = layui.jquery,
        table = layui.table;
    table.render({
        elem: '#test'
        , url: '/yzjse/getreturnVisit/'
        , limit: 5
        , cols: [[
            {type: 'checkbox'},
            {field: 'rid', title: '序号'}
            , {
                field: 'cid', title: '回访客户名称', templet: function (d) {
                    return d.customer.customerName;
                }
            }
            , {field: 'describes', title: '描述'}
            , {
                field: 'returnVisitPersonnel', title: '安装人', templet: function (d) {
                    return d.staff.sname;
                }
            }
            , {field: 'returnVisitDate', title: '记录时间'}
        ]]
        , page: true
        , id: 'idTest'
    });

    //提交事件
    $('#dianji').click(function () {
        table.reload('idTest', {
            where: { //设定异步数据接口的额外参数，任意设
                customerName: $('#customerName').val(),
                sname: $('#sname').val()
            }
            , page: {
                curr: 1 //重新从第 1 页开始
            }
        });

    });
    //跳新增页面
    $('#insetDis').click(function () {
        //新增
        layer.open({
            type: 2,
            content: 'yEnterReturnVisitRecord.html',
            area: ['700px', '600px'],
            title: '录入回访记录',
            end: function () {
                table.reload('idTest');
            }
        })
    });
    $('#ModifyInstallation').click(function () {
        //修改
        var checkStatus = table.checkStatus('idTest');
        var data = checkStatus.data;
        var rid=0;
        if (data.length > 1) {
            layer.alert("只能选择一条");
        } else if (data.length > 0) {
            $(data).each(function (i, o) {//o即为表格中一行的数据
                rid=o.rid;
            });
            layer.open({
                type: 2,
                content: '/yzjse/getid',
                area: ['700px', '600px'],
                title: '修改安装回访',
                success: function (layero, index) {
                    var iframe = window['layui-layer-iframe' + index];
                    iframe.getid(rid);
                },
                end: function () {
                    table.reload('idTest');
                }
            })

        } else {
            layer.alert("请先选择，在修改");
        }
    });
    //批量删除
    $("#deleInstallationDispatchs").on("click", function () {
        var checkStatus = table.checkStatus('idTest');
        var data = checkStatus.data;
        var ids = [];
        if (data.length > 0) {
            $(data).each(function (i, o) {//o即为表格中一行的数据
                ids.push(o.rid);
            });
            layer.confirm('确定要删除吗', function (index) {
                $.ajax({
                    url: '/yzjse/delereturnVisit',
                    type: "post",
                    data: JSON.stringify(ids),
                    dataType: "text",
                    contentType: 'application/json;charset=utf-8',
                    success: function (e) {
                        if (e == 'ok') {
                            layer.alert("删除成功");
                            layer.close(index);
                            //删除对应行（tr）的DOM结构，并更新缓存
                            table.reload('idTest', {
                                where: { //设定异步数据接口的额外参数，任意设

                                }
                                , page: {
                                    curr: 1 //重新从第 1 页开始
                                }
                            });
                            //向服务端发送删除指令
                        } else {
                            layer.alert("删除失败");
                        }
                    }
                })
            })
        } else {
            layer.alert("请先选中，在点击删除")
        }
    });
});