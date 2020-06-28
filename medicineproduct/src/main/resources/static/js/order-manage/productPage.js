layui.use(['jquery','form','table'],function () {
    var $=layui.jquery
        ,form=layui.form
        ,table=layui.table;
    table.render({
        elem: '#productInfo'
        ,url:'/loadProductInfo'
        ,id:"productInfo"
        ,cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        ,cols: [[
            {field:'productCode',  title: '产品编码'}
            ,{field:'productName',  title: '产品名'}
            ,{field:'warehousingDate',  title: '入库日期'}
            ,{field:'presalePrice', title: '预售价格',templet:function (res) {
                    return "$"+res.presalePrice;
                }}
            ,{field:'airOutputPower', title: '空气输出功率',templet:function (res) {
                    return res.airOutputPower+"L/Min";
                }}
            ,{field:'oxygenOutputPower', title: '氧气输出功率',templet:function (res) {
                    return res.oxygenOutputPower+"L/Min";
                }}
            ,{field:'vacuumOutputPower', title: '真空输出功率',templet:function (res) {
                    return res.vacuumOutputPower+"L/Min";
                }}
        ]],
        limits:[5,10,20],
        limit:5,
        page:true
    });
    table.on('rowDouble(productInfo)', function(obj){
        parent.addOrderInfo(obj.data);
        var index=parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    });

});