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
      ,{field:'sid',  title: '安装人员名称'}
      ,{field:'region', title: '安装地址'}
      ,{field:'pre_photos', title: '安装前图片',sort: true}
	  ,{field:'suf_photos', title: '安装后图片'}
	  ,{field:'repair_date', title: '安装日期',sort: true}
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
					content:'insertDiss.html',
						area: ['700px','600px'],
						title:'安装记录评估',
						end:function(){
							table.reload('idTest');
						}
				})
	});
	$('#ModifyInstallation').click(function () {
		//修改
			layer.open({
					type:2,
					content:'ModificationRecord.html',
						area: ['700px','600px'],
						title:'修改安装派单',
						end:function(){
							table.reload('idTest');
						}
				})
	});
	hh(table);
	
	})