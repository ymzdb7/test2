
var content;
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPath=curWwwPath.substring(0,pos);
$(document).ready(function () {
	getTypes();
    $("#jqGrid").jqGrid({
        url: baseURL + 'restaurant/dishes/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', width: 30, key: true},
			{ label: '图片', name: 'dishesPicPath', width: 50 ,formatter:showPic}, 	
			{ label: '菜名', name: 'dishes', width: 50 }, 
			{ label: '种类', name: 'typeName', width: 50 },
			{ label: '点赞数', name: 'recomNum', width: 50 },
			{ label: '配料', name: 'batching', width: 70 }, 			
			{ label: '简介', name: 'keyword', width: 150 }
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
   
    function showPic(cellvalue, options, rowObject){
    	var str = '<img src="'+localhostPath+'/file/read/readImg?filePath='+rowObject.dishesPicPath +'"  width="42" height="42">';
    	return str;
    }
});
/*var editor = new baidu.editor.ui.Editor(); 
editor.render("myEditor"); 
editor.ready(function(){
     editor.setContent("");
});*/

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			dishes: null
		},
		showList: true,
		title:null,
		type:{},
		dishes :{}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.dishes = {};
			var obj = document.getElementById("addImg");
			addImg.innerHTML  = "";
		/*	editor.setContent("");*/
			getTypes();
			
		},
		update: function () {
			var obj = document.getElementById("addImg");
			addImg.innerHTML  = "";
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			
            $.get(baseURL + "restaurant/dishes/info/"+id, function(r){
                vm.showList = false;
                vm.title = "修改";
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
		},
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			var boo=confirm('确定要删除选中的记录？');
        	if(boo==true){
			
		/*	confirm('确定要删除选中的记录？', function(){*/
				$.ajax({
					type: "POST",
				    url: baseURL + "restaurant/dishes/delete",
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
		 //跳转到evaluate.html
        evaluate:function(){
        	var id = getSelectedRow();
        	if(id == null){
				return ;
			}
        	location.href="/modules/restaurant/evaluate.html?id="+id+"&token="+localStorage.getItem("token"); //注入id
        },
		saveOrUpdate: function () {
            if(vm.validator()){
                return ;
            }
          
			var url = vm.dishes.id == null ? "restaurant/dishes/save" : "restaurant/dishes/update";
			var form = new FormData(document.getElementById("dishForm"));
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    data:form,
			    contentType: false,
			    processData:false,
			    success: function(r){
			    	if(r.code === 0){
						alert(r.msg);
							vm.reload();
						
					}else{
						alert(r.msg);
					}
				}
			});
		},
		
		
		getDishes: function(id){
			$.get(baseURL + "restaurant/dishes/info/"+id, function(r){
				vm.dishes = r.dishes;
			});
		},
		
	
		
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'dishes': vm.q.dishes},
                page:page
            }).trigger("reloadGrid");
		},
		validator: function () {
		  if(isBlank(vm.dishes.dishes)){
	                alert("菜名不能为空");
	                return true;
	       }
		  if(isBlank(vm.dishes.typeName)){
              alert("菜品类型不能为空");
              return true;
		  }
        }
	}
});


function getTypes(){
	$.post(baseURL + "restaurant/type/dishType", function(r){
		
		vm.type = r.type;
	});
	
}

