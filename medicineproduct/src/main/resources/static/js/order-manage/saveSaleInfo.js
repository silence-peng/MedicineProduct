layui.use(['jquery','form','table','element'],function () {
    var $=layui.jquery
        ,form=layui.form
        ,table=layui.table
        ,element=layui.element;
    var demo1 = xmSelect.render({
        el: '#product',
        language: 'zn',
        data: [
            {name: '张三', value: 1},
            {name: '李四', value: 2},
            {name: '王五', value: 3},
        ]
    });    var data=[];
    table.render({
        elem: '#productInfo'
        ,id:"reload"
        ,cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        ,cols: [[
            {type:'checkbox'},
            {type:'numbers', title: '序号'},
            {field:'productType', title: '产品类型'},
            {field:'productCode', title: '产品编码'},
            {field:'productName', title: '产品名称'},
            {field:'warehouseName', title: '仓库'},
            {field:'stockNum', title: '库存'},
            {field:'presalePrice', title: '预售价格'},
            {field:'totalSalesPrice', title: '销售价格',edit:true}
        ]]
        ,data:data,
        done:function (res,curr,count) {
            data = res.data;
        }
    });

    $(".add").click(function () {

        var typeId=$("#type").val();
        var productType=$("#type").parent().find("dd[lay-value="+typeId+"]").html();
        var wid=$("#warehouse").val();
        var warehouseName=$("#warehouse").parent().find("dd[lay-value="+wid+"]").html();
        var stockNum=$("#stockNum").val();
        var presalePrice=$("#presalePrice").val();
        var totalSalesPrice=$("#totalSalesPrice").val();
        var selectArr = demo1.getValue();
        $.each(selectArr,function (o,j) {
            var obj={typeId:typeId,productType:productType,warehouseName:warehouseName,wid:wid,stockNum:stockNum,presalePrice:presalePrice,totalSalesPrice:totalSalesPrice,productCode:j.value,productName:j.name};
            data.push(obj);
        });
        if (data[0].typeId===""){
            data.splice(0,1)
        }
        table.reload('reload', {
            data: data
        });
        form.getForm().reset();
    })
});