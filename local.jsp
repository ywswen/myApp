

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.busi/TR/html4/loose.dtd">

<html>
	<head>
		<title>影像平台管理系统-业务系统</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css" href="/SinoImageCS/js/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="/SinoImageCS/js/themes/icon.css">
		<script type="text/javascript" src="/SinoImageCS/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="/SinoImageCS/js/jquery.easyui.min.1.2.2.js"></script>
		<script type="text/javascript" src="/SinoImageCS/js/md5.js"></script>
		<script type="text/javascript" src="/SinoImageCS/js/filedsvildate.js"></script>
		<script type="text/javascript" src="/SinoImageCS/js/commfunc.js"></script>
		<script type="text/javascript" src="/SinoImageCS/js/easiui_extends.js"></script>
		
		<script type="text/javascript">
			$(window).resize(function(){
				$('#busitypetable').datagrid('resize');
			});
			
			$(function(){
				loadData('/SinoImageCS/busitype/busitypeDataAllAction.action');
				initAddBusiType();
				initSearchBusiType();
				initModifyBusiType();
				
				$('#addBusiTypeClose').click(function() {
					$('#addbusitype').window('close');
				});
				
				$('#addBusiTypeSubmit').click(function() {
					var busitypeId = $('#addBusiTypeId');
					var busitypeName = $('#addBusiTypeName');
					var busisysId = $('#addBusisysId');
					var busisysName = $('#addBusisysId option:selected');
					var busisysDsc = $('#addBusisysDsc');
					
					var str = '';
					if ($.trim(busitypeId.val()) == '' || !filedVil(14, busitypeId.val()) || busitypeId.val().length != 4) {
						str += '业务类型编号由4位数字、字母的组合字符组成，不支持汉字、符号！ ';
					}
					if ($.trim(busitypeName.val()) == '' || busitypeName.val().length > 20) {
						str += '业务系统名称由1~20位数字、字母、汉字、符号的组合字符组成！ ';
					}
					if ($.trim(busisysId.val()) == ''){
						str += '请选择业务系统名称！ ';
					}
					if($.trim(str) != ''){
						$.messager.alert('系统提示', '您的本次增加操作出现错误：' + str, 'warning');
						return false;
					}
					$.get('/SinoImageCS/busitype/busitypeAddAction.action?busiType.busitypeid=' + busitypeId.val()
							+ '&busiType.busitypename=' + encodeURI(encodeURI(busitypeName.val()))
							+ '&busiType.busisysid=' + busisysId.val()
							+ '&busiType.busisysname=' + encodeURI(encodeURI(busisysName.text().substring(5)))
							+ '&busiType.isused=01'
							+ '&busiType.busitypedsc=' + encodeURI(encodeURI(busisysDsc.val()))
							+ '&rdm=' + Math.random(),
							function(data){
								if(data.result == "true"){
									$.messager.alert('系统提示', '恭喜您，' + data.resultdsc + '！', 'info', function(data){
										$('#busitypetable').datagrid('reload');
									});
									$('#addbusitype').window('close');
								}else{
									$.messager.alert('系统提示', '对不起，'+ data.resultdsc + '！', 'error');
								}
					});
					
				});
				
				$('#searchBusiTypeSubmit').click(function() {
					var busiTypeId = $('#searchBusiTypeId');
					var busiTypeName = $('#searchBusiTypeName');
					var busisysId = $('#searchBusisysId');
					
					var str = '';
					if($.trim(busiTypeId.val()) != ''){
						if (!filedVil(14, busiTypeId.val()) || busiTypeId.val().length != 4) {
							str += '业务类型编号由4位数字、字母的组合字符组成，不支持汉字、符号！ ';
						}
					}
					if (busiTypeName.val().length > 20) {
						str += '业务系统名称由1~20位数字、字母、汉字、符号的组合字符组成！ ';
					}
					if($.trim(str) != ''){
						$.messager.alert('系统提示', '您的本次查询操作出现错误：' + str, 'warning');
						return false;
					}
					
					loadData('/SinoImageCS/busitype/busitypeSearchAction.action?busiType.busitypeid=' + busiTypeId.val()
							+ '&busiType.busitypename=' + encodeURI(encodeURI(busiTypeName.val()))
							+ '&busiType.busisysid=' + busisysId.val()
							+ '&rdm=' + Math.random()
					);
					$('#searchbusitype').window('close');
				});
				
				$('#searchBusiTypeClose').click(function() {
					$('#searchbusitype').window('close');
				});
				
				$('#modifyBusiTypeClose').click(function() {
					$('#modifybusitype').window('close');
				});
				
				$('#modifyBusiTypeSubmit').click(function() {
					var busitypeId = $('#modifyBusitypeId');
					var busitypeName = $('#modifyBusitypeName')
					var busitypeDsc = $('#modifyBusitypeDsc');
					
					$.get('/SinoImageCS/busitype/busitypeModifyAction.action?busiType.busitypeid=' + busitypeId.val() 
						  + '&busiType.busitypename=' + encodeURI(encodeURI(busitypeName.val()))
						  + '&busiType.busitypedsc=' + encodeURI(encodeURI(busitypeDsc.val()))
						  + '&rdm=' + Math.random(),
						  function(data) {
							if(data.result == "true"){
								$.messager.alert('系统提示', '恭喜您，' + data.resultdsc + '！', 'info', function(data){
									 $('#busitypetable').datagrid('reload');   
								});
								$('#modifybusitype').window('close');
						  }else{
						  		$.messager.alert('系统提示', '对不起，' + data.resultdsc + '！');
						  }  
				   });
				});
				
			});
			
			function loadData(accesspath){
				$('#busitypetable').datagrid({  
					title:'业务类型管理',
					loadMsg:'数据装载中......',
					url:accesspath,
					iconCls:'icon-save',
					pagination:true,
					pageList: [10, 15, 20], 					
					pageSize: 15,
					fitCloumns: true,
					nowrap: true,
					striped: true,
					remoteSort:false,
					rownumbers:true,
					singleSelect:true,
					columns:[[
					   {title:'业务类型编号',field:'busitypeid',width:100,align:'center'},
					   {title:'业务类型名称',field:'busitypename',width:180,align:'center'},
					   {title:'业务系统编号',field:'busisysid',width:100,align:'center'},
					   {title:'业务系统名称',field:'busisysname',width:180,align:'center'},
					   {title:'业务类型描述',field:'busitypedsc',width:200,align:'center'},
					   {title:'操作类型',field:'opr',width:80,align:'center',formatter:function(val, rec){
							return "<a id='editBusitype' href='javascript:editBusitype(\"" + rec.busitypeid + 
								"\")'>修改</a> <a id='undoBusitype' href='javascript:undoBusitype(\"" + rec.busitypeid + 
								"\")'>作废</a>";
				       }}
					]],
					toolbar:[
						{text:'增加',iconCls:'icon-add',handler:function(){
							$('#addBusiTypeId').val('');
							$('#addBusiTypeName').val('');
							$('#addBusisysId option').remove();
							$('#addBusisysDsc').val('');                //初始化清空所有输入框
							
							var busisysId = $('#addBusisysId');
							busisysId.append('<option value="">请选择...</option>');
							$.get('/SinoImageCS/busisys/busisysDataAction.action?rdm=' + Math.random(),
									function(data){
										for(var i=0; i<data.rows.length; i++){
											busisysId.append('<option value="'+data.rows[i].busisysid+'">【' + data.rows[i].busisysid + '】' + data.rows[i].busisysname + '</option>');
										}		
							});
							$('#addbusitype').show();
							$('#addbusitype').window('open');
						}}, '-',  
						{text:'查询',iconCls:'icon-search',handler:function(){
							$('#searchbusiTypeId').val('');
							$('#searchbusiTypeName').val('');
							$('#searchBusisysId option').remove();         //初始化清空所有输入框
						
							var busisysId = $('#searchBusisysId');
							busisysId.append('<option value="">请选择...</option>');
							$.get('/SinoImageCS/busisys/busisysDataAction.action?rdm=' + Math.random(),
									function(data){
										for(var i=0; i<data.rows.length; i++){
											busisysId.append('<option value="'+data.rows[i].busisysid+'">【' + data.rows[i].busisysid + '】' + data.rows[i].busisysname+'</option>');
										}		
							});
							$('#searchbusitype').show();
							$('#searchbusitype').window('open');
						}}, '-'
					]
				});
				FenYe('#busitypetable');
			}
			
			function initAddBusiType(){
				$('#addbusitype').window({
					title : '业务类型增加1',
					width : 340,
					modal : true,
					shadow : true,
					closed : true,
					height : 250,
					resizable : false,
					top : 100
				});			
			}
			
			function initSearchBusiType(){
				$('#searchbusitype').window({
					title : '业务类型查询',
					width : 340,
					modal : true,
					shadow : true,
					closed : true,
					height : 200,
					resizable : false,
					top : 100
				});			
			}
			
			function initModifyBusiType(){
				$('#modifybusitype').window({
					title : '业务类型修改',
					width : 340,
					modal : true,
					shadow : true,
					closed : true,
					height : 180,
					resizable : false,
					top : 100
				});			
			}
			
			function editBusitype(bsid){
				$.get('/SinoImageCS/busitype/busitypeShowAction.action?busiType.busitypeid=' + bsid
					+ '&rdm=' + Math.random(), 
					function(data) {
						$('#modifyBusitypeId').attr('value',data.busitypeid);
						$('#modifyBusitypeName').attr('value',data.busitypename);
						$('#modifyBusitypeDsc').attr('value',data.busitypedsc);
						$('#modifybusitype').show();
						$('#modifybusitype').window('open');
					});
			}
			
			function undoBusitype(bsid){
				$.messager.confirm('系统提示，','确定要作废"业务类型"吗？不可还原！',function(r){
					if(r){
						$.get('/SinoImageCS/busitype/busitypeUndoAction.action?busiType.busitypeid=' + bsid
						    	+ '&rdm=' + Math.random(), 
						    	function(data) {
									if(data.result == "true"){
										$.messager.alert('系统提示','恭喜您，' + data.resultdsc + '！');
										$('#busitypetable').datagrid('reload');
									} else {
										$.messager.alert('系统提示','对不起，' + data.resultdsc + '！');
									  }
						});
					}
				});
			}
		</script>
	</head>
	<body>
		<table id="busitypetable" class="easyui-datagrid" style="height:511px"></table>
		
		<div id="addbusitype" class="easyui-window" title="业务系统增加" collapsible="false" minimizable="false" maximizable="false" icon="icon-save" style="width: 280px; height: 200px; padding: 5px; background: #fafafa; display:none;">
			<div class="easyui-layout" fit="true">
				<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
					<table cellpadding="3" align="center">
						<tr>
							<td align="left">业务类型编号：</td>
							<td><input id="addBusiTypeId" type="text" style="width:150px" required="true" class="easyui-validatebox" validType="myfunc[4,4]" missingMessage="请输入4位数字、字母的组合字符，不支持汉字、符号！" title="必输项"/></td>
						</tr>
						<tr>
							<td>业务类型名称：</td>
							<td><input id="addBusiTypeName" type="text" style="width:150px" required="true" class="easyui-validatebox" validType="myfunc[1,20]" missingMessage="请输入1~20位数字、字母、汉字、符号的组合字符！" title="必输项"/></td>
						</tr>
						<tr style="display:none">
							<td>状态：</td>
							<td>
								<select class="txt01" id="addIsUsed" style="width:150px;" title="必输项">
									<option value="">请选择...</option>
									<option value="00">作废</option>
									<option value="01" selected="selected">正常</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>业务系统名称：</td>
							<td>
								<select id="addBusisysId" style="width:154px;height:21px;" class="easyui-validatebox" required="true" missingMessage="请选择业务系统" title="必须选中一项">
								</select>
							</td>
						</tr>
						<tr>
							<td>业务类型描述：</td>
							<td><textarea id="addBusisysDsc" style="width:148px" title="非必输项"></textarea></td>
						</tr>
						
					</table>
				</div>
				<div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
					<a id="addBusiTypeSubmit" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">确定</a>
					<a id="addBusiTypeClose" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
				</div>
			</div>
		</div>
		
		<div id="searchbusitype" class="easyui-window" title="业务系统查询" collapsible="false" minimizable="false" maximizable="false" icon="icon-search" style="width: 280px; height: 200px; padding: 5px; background: #fafafa; display:none;">
			<div class="easyui-layout" fit="true">
				<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
					<table cellpadding="3" align="center">
						<tr>
							<td align="left">业务类型编号：</td>
							<td><input id="searchBusiTypeId" type="text" style="width:150px" title="非必输项" required="true" class="easyui-validatebox" validType="myfunc[4,4]" missingMessage="请输入4位数字、字母的组合字符，不支持汉字、符号！如您不作为输入条件，可忽略！"/></td>
						</tr>
						<tr>
							<td>业务类型名称：</td>
							<td><input id="searchBusiTypeName" type="text" style="width:150px" title="非必输项" required="true" class="easyui-validatebox" validType="myfunc[1,20]" missingMessage="请输入1~20位数字、字母、汉字、符号的组合字符！如您不作为输入条件，可忽略！"/></td>
						</tr>
						<tr>
							<td>业务系统名称：</td>
							<td>
								<select id="searchBusisysId" style="width:154px;height:21px;" title="非必输项" required="true" class="easyui-validatebox" missingMessage="请选择'业务系统'，如不作为输入条件可忽略！如您不作为输入条件，可忽略！">
								</select>
							</td>
						</tr>
					</table>
				</div>
				<div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
					<a id="searchBusiTypeSubmit" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">确定</a>
					<a id="searchBusiTypeClose" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
				</div>
			</div>
		</div>
		
		<div id="modifybusitype" class="easyui-window" title="业务系统修改" collapsible="false" minimizable="false" maximizable="false" icon="icon-reload" style="width: 280px; height: 200px; padding: 5px; background: #fafafa;  display:none;">
			<div class="easyui-layout" fit="true">
				<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
					<table cellpadding="3" align="center">
							<input id="modifyBusitypeId" type="hidden" title="此项不允许修改！"/>
						<tr>
							<td align="left">业务类型名称：</td>
							<td><input id="modifyBusitypeName" type="text" required="true" class="easyui-validatebox" validType="myfunc[1,20]" missingMessage="请输入1~20位数字、字母、汉字、符号的组合字符！" title="非必输项"/></td>
						</tr>
						<tr style="display:none">
							<td>状态：</td>
							<td>
								<select class="txt01" id="modifyIsUsed" style="width:150px;" title="非必修改项">
									<option value="00">作废</option>
									<option value="01" selected="selected">正常</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>业务类型描述：</td>
							<td><textarea id="modifyBusitypeDsc" style="width:148px" title="非必修改项"></textarea></td>
						</tr>
						
					</table>
				</div>
				<div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
					<a id="modifyBusiTypeSubmit" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">确定</a>
					<a id="modifyBusiTypeClose" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
				</div>
			</div>
		</div>
	</body>
</html>
