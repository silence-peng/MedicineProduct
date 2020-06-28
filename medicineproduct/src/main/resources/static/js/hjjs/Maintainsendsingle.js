layui.use(['laydate', 'jquery','table'], function() {
    var laydate = layui.laydate,
        $ = layui.jquery,
        table=layui.table;
	  table.render({
	    elem: '#test'
	    ,url:'/hj/getdistributeleaflets'
	    ,cols: [[
	      {field:'did',title: '派单序号'}
	      ,{field:'sname',title: '员工',templet:'<a>{{d.staff.sname}}</a>'}
	      ,{field:'customerName',title: '客户',templet:'<a>{{d.customer.customerName}}</a>'}
	      ,{field:'endDate',title: '截止完成日期'}
	    ]]
	    ,page: true
		  ,limit:3
		  ,id : 'testReload'
	  });
	$("#sosuo").on('click',function() {
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
	  table.on('tool(test)', function(obj){
	      var data = obj.data;
	      //console.log(obj)
	      if(obj.event === 'del'){
	        layer.confirm('真的删除行么', function(index){
	          obj.del();
	          layer.close(index);
	        });
	      } else if(obj.event === 'edit'){
	        layer.prompt({
	          formType: 2
	          ,value: data.email
	        }, function(value, index){
	          obj.update({
	            email: value
	          });
	          layer.close(index);
	        });
	      }
		  });
	  //跳新增页面
	  $("#dianji").click(function(){
	      layer.open({
	          type: 2,
	          content: 'addMaintainsendsingle.html', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	          area: ['700', '600px']
	      });
	  });
	  $("#dianji1").click(function(){
	      layer.open({
	          type: 2,
	          content: 'updateMaintainsendsingle.html', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	          area: ['700', '600px']
	      });
	  });
	});