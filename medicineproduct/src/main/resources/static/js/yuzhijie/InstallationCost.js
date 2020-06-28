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
		,{field:'cost_id', title: '序号',sort:true}
      ,{field:'sid ',  title: '安装人'}
      ,{field:'cid', title: '安装地址'}
      ,{field:'cost', title: '费用',sort: true}
	  ,{field:'entered_date', title: '录入时间',sort: true}
	  ,{field:'entered_by ', title: '录入人'}
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
					content:'NewInstallation.html',
						area: ['700px','600px'],
						title:'安装费用录入',
						end:function(){
							table.reload('idTest');
						}
				})
	});
	$('#ModifyInstallation').click(function () {
		//修改
			layer.open({
					type:2,
					content:'ModifyInstallationCost.html',
						area: ['700px','600px'],
						title:'修改安装费用',
						end:function(){
							table.reload('idTest');
						}
				})
	});
	hh(table);
	
	})