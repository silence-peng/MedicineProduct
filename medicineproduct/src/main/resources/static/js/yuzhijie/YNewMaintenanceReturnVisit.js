layui.use(['table', 'form', 'layer', 'upload', 'jquery', 'laydate'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var form = layui.form;
    upload = layui.upload;
    var $ = layui.jquery;
    var laydate = layui.laydate;
    //时间
    laydate.render({
        elem: '#date'
    });
    layui.laydate.render({
        elem: '#returnVisitDate',
        type: 'date',
        trigger: 'click' ,

    });
    //查询员工id
    $.post("/yzjse/getstaff", function (result) {
        $(result).each(function () {
            $("#returnVisitPersonnel").append("<option value='" + this.sid + "'>" + this.sname + "</option>");
        });
        form.render('select'); //刷新select选择框渲染
    });
    //查询客户id
    $.post("/yzjse/getCustomer", function (result) {
        $(result).each(function () {
            $("#cid").append("<option value='" + this.cid + "'>" + this.customerName + "</option>");
        });
        form.render('select'); //刷新select选择框渲染
    });
    //新增ajax
    form.on('submit(tij)', function (data) {
        $.ajax({
            url: '/yzjse/insertreturnVisit',
            type: 'post',
            data: $("#form").serialize(),
            dataType: 'text',
            success: function (e) {
                if (e == 'ok') {
                    layer.msg("新增成功！", {time: 500, icon: 6}, function () {
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index);
                    });
                }
            }
        });
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

});