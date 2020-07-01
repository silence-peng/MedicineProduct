function hh(table){
	//分页
  table.render({
    elem: '#test'
    ,url:'fenyetwo'
    ,limit:2
    ,method:'post'
    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    ,cols: [[
		{type:'checkbox'}
    	,{field:'mid', title: '序号',sort:true}
      ,{field:'sid',  title: '维修人员名称'}
      ,{field:'region ', title: '维修地址'}
      ,{field:'pre_photos', title: '维修前图片',sort: true}
	  ,{field:'suf_photos', title: '维修后图片'}
	  ,{field:'repair_date', title: '维修日期',sort: true}
    ]]
  ,page: true
  });
}
layui.use(['table','form','layer','jquery'],function(){
	var table = layui.table;
	var layer=layui.layer;
	var form=layui.form;
	$('#insetDis').click(function () {
		//新增
			layer.open({
					type:2,
					content:'MaintenanceRecordEvaluation.html',
						area: ['700px','600px'],
						title:'评估维护记录',
						end:function(){
							table.reload('idTest');
						}
				})
	});
	$('#ModifyInstallation').click(function () {
		//修改
			layer.open({
					type:2,
					content:'ModifyRepairRecord.html',
						area: ['700px','600px'],
						title:'修改维护记录',
						end:function(){
							table.reload('idTest');
						}
				})
	});
	hh(table);
	
	})