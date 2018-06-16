
var content;
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPath=curWwwPath.substring(0,pos);
$(document).ready(function () {
	time();
    $("#jqGrid").jqGrid({
        url: baseURL + 'restaurant/adDishesCounts/list',
        datatype: "json",
        colModel: [			
			{ label: '菜名', name: 'advanceDishes', width: 30, key: true},
			{ label: '数量', name: 'counts', width: 50 }
		
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
			orderTime: null
		},
		showList: true,
		title:null,
	},
	methods: {
		query: function () {
			vm.q.orderTime=$('#orderTime').val();
			vm.reload();
		},
	
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'orderTime': vm.q.orderTime},
                page:page
            }).trigger("reloadGrid");
		},
		validator: function () {
		  if(isBlank(vm.type.typeName)){
	                alert("菜品类型不能为空");
	                return true;
	       }
        }
	}
});


function time(){
	$('#datetimepicker').datetimepicker({
		 autoclose: 1,
		 language: 'zh-CN',
		 weekStart:1,
		 todayBtn:1,
		 todayHighlight:1,
		 startView:2,
		 minView:2,
		 forceParse:0

	});
	}
