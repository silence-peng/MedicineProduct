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
    // 弹出框小了 时间 弹出立马消失的 问题
    layui.laydate.render({
        elem: '#enteredDate',
        type: 'date',
        trigger: 'click' ,

    });
//查询员工id
    $.post("/yzjs/getstaff", function (result) {
        $(result).each(function () {
            $("#sid").append("<option value='" + this.sid + "'>" + this.sname + "</option>");
        });
        form.render('select'); //刷新select选择框渲染
    });
    //查询员工id
    $.post("/yzjs/getstaff", function (result) {
        $(result).each(function () {
            $("#enteredBy").append("<option value='" + this.sid + "'>" + this.sname + "</option>");
        });
        form.render('select'); //刷新select选择框渲染
    });
    //新增ajax
    form.on('submit(tij)', function (data) {
        $.ajax({
            url: '/yzjs/insert',
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
        })
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
})