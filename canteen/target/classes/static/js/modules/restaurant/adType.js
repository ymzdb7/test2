
var content;
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPath=curWwwPath.substring(0,pos);
$(document).ready(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'restaurant/adType/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', width: 30, key: true},
			{ label: '种类', name: 'typeName', width: 50 }
		
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});


var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			typeName: null
		},
		showList: true,
		title:null,
		adType :{}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.adType = {};
	},
		update: function () {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			
            $.get(baseURL + "restaurant/adType/info/"+id, function(r){
                vm.showList = false;
                vm.title = "修改";
                vm.adType = r.adType;
              });
		},	
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
		/*	confirm('确定要删除选中的记录？', function(){*/
			var boo=confirm('确定要删除选中的记录？');
        	if(boo==true){
				$.ajax({
					type: "POST",
				    url: baseURL + "restaurant/adType/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功');
                              vm.reload();
							
						}else{
							alert(r.msg);
						}
					}
				});
	
        	}
		},
		
	
		saveOrUpdate: function () {
            if(vm.validator()){
                return ;
            }
          
			var url = vm.adType.id == null ? "restaurant/adType/save" : "restaurant/adType/update";
			var form = new FormData(document.getElementById("adTypeForm"));
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    data:form,
			    contentType: false,
			    processData:false,
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功');
							vm.reload();
						
					}else{
						alert(r.msg);
					}
				}
			});
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'typeName': vm.q.typeName},
                page:page
            }).trigger("reloadGrid");
		},
		validator: function () {
		  if(isBlank(vm.adType.typeName)){
	                alert("菜品类型不能为空");
	                return true;
	       }
        }
	}
});

