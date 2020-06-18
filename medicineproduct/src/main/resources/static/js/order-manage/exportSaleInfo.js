layui.use(['jquery','form','table','upload'],function () {
    var $=layui.jquery
        ,form=layui.form
        ,upload = layui.upload
        ,table=layui.table;


    table.render({
        elem: '#exportInfo'
        ,id:"reload"
        ,cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        ,cols: [[
            {field:'str1', title: 'str1',edit:true},
            {field:'str2', title: 'str2',edit:true},
            {field:'str3', title: 'str3',edit:true},
            {field:'str4', title: 'str4',edit:true},
            {field:'str5', title: 'str5',edit:true},
            {field:'str6', title: 'str6',edit:true},
            {field:'str7', title: 'str7',edit:true},
            {field:'str8', title: 'str8',edit:true},
            {field:'str9', title: 'str9',edit:true}
        ]]
        ,data:[{
            "str1":"",
            "str2":"",
            "str3":"",
            "str4":"",
            "str5":"",
            "str6":"",
            "str7":"",
            "str8":"",
            "str9":""
        }],
        done:function (res,curr,count) {
            data = res.data;
        }

    });
    var data;
    upload.render({ //允许上传的文件后缀
        elem: '#templateFile'
        ,url: '/base/upload' //改成您自己的上传接口
        ,accept: 'file' //普通文件
        ,exts: 'xlsx|xls' //只允许上传压缩文件
        ,before: function(obj) {

        }
        ,data: {

        },done: function(res){
            if (res.code===0){
                layer.msg('上传成功!');
                data=res.data;
                table.reload('reload', {
                    data: data
                });
            }else{
                layer.msg(res.msg);
            }
        }
    });

});