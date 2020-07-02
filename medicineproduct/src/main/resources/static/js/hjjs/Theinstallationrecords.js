layui.use(['laydate', 'jquery','table'], function() {
    var laydate = layui.laydate,
        $ = layui.jquery,
        table=layui.table;
    table.render({
        elem: '#test'
        ,url:'/hj/getRecords'
        ,cols: [[
            {type: 'checkbox'}
            ,{field:'mid',title: '序号'}
            ,{field:'sname',title: '安装人员名称', templet: '<span>{{d.staff.sname}}</span>'}
            ,{field:'productName',title: '产品', templet: '<span>{{d.product.productName}}</span>'}
            ,{field:'customerName',title: '客户', templet: '<span>{{d.customer.customerName}}</span>'}
            ,{field:'prePhotos',title: '安装前的图片',templet:'<div><img src="/images/{{d.prePhotos}}" class="layui-table-link"></div>'}
            ,{field:'sufPhotos',title: '安装后的图片',templet:'<div><img src="/images/{{d.sufPhotos}}" class="layui-table-link"></div>'}
            ,{field:'repairDate',title: '安装日期'}
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
    //评估
    $("#pingu").click(function(){
        var checkStatus = table.checkStatus("testReload");
        var data = checkStatus.data;
        var ids=0;
        if (data.length==1) {
            $(data).each(function (i, o) {//o即为表格中一行的数据
                ids=o.mid;
            });
            layer.open({
                type: 2,
                content: '/hj/addTheinstallationrecordss?id='+ids, //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
                title: "安装评估",
                area: ['700px', '600px']
            });
        }else if(data.length>=2){
            layer.alert("只可以选择一条值评估");
        }else{
            layer.alert("请选择一条值评估");
        }
    })
    //删除记录
    $("#shancu").click(function(){
        sss();
    })
    function sss(){
        var checkStatus = table.checkStatus("testReload");
        var data = checkStatus.data;
        var ids = new Array();
        if (data.length>0) {
            $(data).each(function (i, o) {//o即为表格中一行的数据
                ids.push(o.mid);
            });
            layer.confirm('真的删除行么', function (index) {
                $.ajax({
                    url : "/hj/shancubaoyangjilu",//删除保养记录
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