layui.use(['laydate', 'jquery','table'], function() {
    var laydate = layui.laydate,
        $ = layui.jquery,
        table=layui.table;
	  table.render({
	    elem: '#test'
	    ,url:'/demo/table/user/'
	    ,cols: [[
	      {field:'id',title: '序号'}
	      ,{field:'username',title: '回访客户名称'}
	      ,{field:'sex',title: '回访方式'}
	      ,{field:'classify',title: '描述'}
		   ,{field:'classify',title: '记录人员'}
		    ,{field:'classify',title: '记录时间'}
	     ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
	    ]]
	    ,page: true
	  });
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
	          content: 'addMaintenancevisit.html', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	          area: ['700px', '600px']
	      });
	  });
	});