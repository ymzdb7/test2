var content;
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPath=curWwwPath.substring(0,pos);
$(document).ready(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'restaurant/oneCard/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', width: 30, key: true},
			{ label: '帐号', name: 'account', width: 80 }, 	
			{ label: '员工编号', name: 'employeeNo', width: 60 }, 	
			{ label: '卡序列号', name: 'cardSn', width: 70 }, 			
			{ label: '卡号', name: 'cardNo', width: 100 }, 
			{ label: '交易类型', name: 'transType', width: 70 },
			{ label: '交易金额', name: 'transMoney', width: 70 },
			{ label: '交易状态', name: 'transState', width: 70 },
			{ label: '终端编号', name: 'terminalNo', width: 70 },
			{ label: '交易时间', name: 'transTime', width: 150 }
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
   
 /*   function showPic(cellvalue, options, rowObject){
    	var str = '<img src="'+localhostPath+'/file/read/readImg?filePath='+rowObject.dishesPicPath +'"  width="42" height="42">';
    	return str;
    }*/


  /*  function operate(cellvalue, options, rowObject){
    	var str = '<button type="button">评价管理</button> ';
    	return str;
    }*/
});
/*var editor = new baidu.editor.ui.Editor(); 
editor.render("myEditor"); 
editor.ready(function(){
     editor.setContent("");
});
*/
var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			employeeNo: null
		},
		showList: true,
		title:null,
		employeeNo :{}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		
		/*add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.dishes = {};
			var obj = document.getElementById("addImg");
			addImg.innerHTML  = "";
			editor.setContent("");
			
		},*/
		/*update: function () {
			var obj = document.getElementById("addImg");
			addImg.innerHTML  = "";
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			
            $.get(baseURL + "restaurant/dishes/info/"+id, function(r){
                vm.showList = false;
                vm.title = "修改";
                console.log("dish:",r.dishes);
                vm.dishes = r.dishes;
                editor.setContent(r.dishes.dishesDetail);

                var divImg = document.getElementById("addImg");
                var img = document.createElement("img");
            　　　　		//设置 img 图片地址
            　　　　		img.src = localhostPath+'/file/read/readImg?filePath='+r.dishes.dishesPicPath;
            　　　　		img.width='50';
            　　　　		img.id = 'dishPic';
            　　　　		img.height = '50'
            　　　　		divImg.appendChild(img);
            　　　　		
                
            });
		},*/
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			var boo=confirm('确定要删除选中的记录？');
			if(boo==true){
				$.ajax({
					type: "POST",
				    url: baseURL + "restaurant/oneCard/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(){
                                vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			}
		},
		/* //跳转到evaluate.html
        evaluate:function(){
        	var id = getSelectedRow();
        	if(id == null){
				return ;
			}
        	window.location.href="/modules/restaurant/evaluate.html?id="+id//注入id
        },*/
		saveOrUpdate: function () {
            if(vm.validator()){
                return ;
            }
          
			var url = vm.dishes.id == null ;
			var form = new FormData(document.getElementById("dishForm"));
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    data:form,
			    contentType: false,
			    processData:false,
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		
		
	/*	getDishes: function(id){
			$.get(baseURL + "restaurant/dishes/info/"+id, function(r){
				vm.dishes = r.dishes;
			});
		},*/
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'employeeNo': vm.q.employeeNo},
                page:page
            }).trigger("reloadGrid");
		},
		
		/*validator: function () {
		  if(isBlank(vm.dishes.dishes)){
	                alert("菜名不能为空");
	                return true;
	       }
        }*/
	}
});

