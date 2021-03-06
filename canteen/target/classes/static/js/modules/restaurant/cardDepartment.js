
var content;
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPath=curWwwPath.substring(0,pos);
$(document).ready(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'restaurant/cardDepartment/list',
        datatype: "json",
        colModel: [			
			{ label: '卡号', name: 'cardNo', width: 50 },
			{ label: '部门', name: 'department', width: 50 }
			/*{ label: '交易金额', name: 'transMoney', width: 50 },
			{ label: '时间', name: 'transTime', width: 50 },*/
		
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
			cardNo: null
		},
		showList: true,
		title:null,
		cardDepartment:{},
		deparList :{}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.cardDepartment = {};
			getDepartment();
	},
		
		saveOrUpdate: function () {
            if(vm.validator()){
                return ;
            }
          
			var url = vm.cardDepartment.id == null ? "restaurant/cardDepartment/save" : "restaurant/cardDepartment/update";
			var form = new FormData(document.getElementById("cardDeparForm"));
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
				postData:{'cardNo': vm.q.cardNo},
                page:page
            }).trigger("reloadGrid");
		},
		validator: function () {
		  if(isBlank(vm.cardDepartment.cardNo)){
	                alert("卡号不能为空");
	                return true;
	       }
		  if(isBlank(vm.cardDepartment.department)){
              alert("部门不能为空");
              return true;
     }
        }
	}
});


function getDepartment(){
	$.ajax({
		type: "GET",
	    url: "http://211.149.174.103:8080/sys/user/department",
	    dataType:'jsonp',  
        jsonp:"callback",
        data:{"token":localStorage.getItem("token")},
	    success: function(r){
	    	if(r.code === 0){
	    		vm.deparList= r.list;
			}else{
				alert(r.msg);
			}
		}
	});
	/*getLoginAddress();*/
}