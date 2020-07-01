layui.use(['table', 'form', 'layer', 'jquery'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var form = layui.form;

    //分页
    table.render({
        elem: '#test'
        , url: '/yzj/getpageINfo'
        , limit: 5
        , method: 'post'
        , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , cols: [[
            {type: 'checkbox'}
            , {field: 'did', title: '序号', sort: true}
            , {
                field: 'cid', title: '安装地址'
                , templet: function (d) {
                    return d.customer.customerAddress;
                }
            }
            , {
                field: 'sid', title: '安装人', templet: function (d) {
                    return d.staff.sname;
                }
            }
            , {field: 'createDate', title: '安装时间'}
        ]]
        , page: true
        , id: 'idTest'
    });
    $('#dianji').click(function () {
        table.reload('idTest', {
            where: { //设定异步数据接口的额外参数，任意设
                customerAddress: $('#customerAddress').val(),
                sname: $('#sname').val()
            }
            , page: {
                curr: 1 //重新从第 1 页开始
            }
        });

    });
    $('#insetDis').click(function () {
        //新增
        layer.open({
            type: 2,
            content: 'insertDis.html',
            area: ['700px', '600px'],
            title: '安装派单',
            end: function () {
                table.reload('idTest');
            }
        })
    });
    $('#ModifyInstallation').click(function () {
        //修改
        layer.open({
            type: 2,
            content: 'ModifyInstallation.html',
            area: ['700px', '600px'],
            title: '修改安装派单',
            end: function () {
                table.reload('idTest');
            }
        })
    });
    // $("#deleInstallationDispatchs").on("click",function () {
    //     var checkStatus = table.checkStatus('idTest');
    //     var data= checkStatus.data;
    //     var ids = "";
    //     if (ids.length <1) {0
    //         for ( var int = 0; int < data.length; int++) {
    //             ids+=data[int].id+",";
    //         }
    //         layer.confirm('确定要删除吗', function (index) {
    //             $.ajax({
    //                 url: 'deleInstallationDispatchs',
    //                 type: "post",
    //                 data: {ids: ids},
    //                 dataType: 'text',
    //                 success: function (e) {
    //                     if (e == "ok") {
    //                         layer.alert("删除成功");
    //                         obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
    //                         layer.close(index);
    //                         //向服务端发送删除指令
    //                     } else {
    //                         layer.alert("删除失败");
    //                     }
    //                 }
    //             })
    //         })
    //     }
    // });
});