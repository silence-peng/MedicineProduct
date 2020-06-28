layui.use(['laydate', 'jquery','table'], function() {
    var laydate = layui.laydate,
        $ = layui.jquery,
        table=layui.table;
	  table.render({
	    elem: '#test'
	    ,url:'/demo/table/user/'
	    ,cols: [[
			{type:'checkbox'},
	      {field:'rid',title: '序号'}
	      ,{field:'cid',title: '回访客户名称'}
	      ,{field:'way_of_return_visit',title: '回访方式'}
	      ,{field:'describe',title: '描述'}
		   ,{field:'return_visit_personnel',title: '记录人员'}
		    ,{field:'return_visit_date',title: '记录时间'}
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
	  $('#insetDis').click(function () {
	  	//新增
	  		layer.open({
	  				type:2,
	  				content:'EnterReturnVisitRecord.html',
	  					area: ['700px','600px'],
	  					title:'录入回访记录',
	  					end:function(){
	  						table.reload('idTest');
	  					}
	  			})
	  });
	  $('#ModifyInstallation').click(function () {
	  	//修改
	  		layer.open({
	  				type:2,
	  				content:'ModifyReturnVisitRecord.html',
	  					area: ['700px','600px'],
	  					title:'修改回访记录',
	  					end:function(){
	  						table.reload('idTest');
	  					}
	  			})
	  });
	});