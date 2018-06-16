
var content;
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPath=curWwwPath.substring(0,pos);
$(document).ready(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'restaurant/cardDevice/list',
        datatype: "json",
        colModel: [			
		/*	{ label: 'id', name: 'id', width: 30, key: true},*/
			{ label: '设备号', name: 'terminalNo', width: 50 },
			{ label: '名称', name: 'name', width: 50 }
		/*	{ label: '交易金额', name: 'transMoney', width: 50 }*/
		
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
			terminalNo: null
		},
		showList: true,
		title:null,
		type :{},
		cardDevice:{}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.type = {};
			vm.cardDevice={};
	},
		
		
	
		saveOrUpdate: function () {
            if(vm.validator()){
                return ;
            }
          
			var url = vm.cardDevice.id == null ? "restaurant/cardDevice/save" : "restaurant/cardDevice/update";
			var form = new FormData(document.getElementById("typeForm"));
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
				postData:{'terminalNo': vm.q.terminalNo},
                page:page
            }).trigger("reloadGrid");
		},
		validator: function () {
		  if(isBlank(vm.cardDevice.terminalNo)){
	                alert("设备号不能为空");
	                return true;
	       }
		  if(isBlank(vm.cardDevice.name)){
              alert("设备名称不能为空");
              return true;
     }
        }
	}
});

