var content;
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPath=curWwwPath.substring(0,pos);
var path="http://211.149.174.103:9999/";

function getid(){
	var url = location.search;	
	var theRequest = new Object();   
	   if (url.indexOf("?") != -1) {   
	      var str = url.substr(1);   
	      strs = str.split("&");   
	      for(var i = 0; i < strs.length; i ++) { 
	   
	         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);  //前边是=前边的, 后边是=号后边的
	      }   
	   }   
	   return theRequest;   
	} ;  
var pamer=getid();
var id=pamer.id;



$(document).ready(function () {
    $("#jqGrid").jqGrid({
    	
    	
    	
    	
    	url: baseURL + 'restaurant/evaluates/list',//注入id
        datatype: "json",
        postData:{'id': id},
        colModel: [			
			
			{ label: '评论人姓名', name: 'createUserName', width: 50}, 	
			{ label: '评论内容', name: 'content', width: 50 }, 			
			{ label: '评论时间', name: 'createTime', width: 70 }	
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
   
/*    function showPic(cellvalue, options, rowObject){
    	var str = '<img src="'+localhostPath+'/file/read/readImg?filePath='+rowObject.dishesPicPath +'"  width="42" height="42">';
    	return str;
    }*/
   /* function operate(cellvalue, options, rowObject){
    	var str = '<button type="button" >评价管理</button> ';
    	return str;
    }*/
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
			evaluates: null
		},
		showList: true,
		title:null,
		evaluates :{}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.evaluates = {};
			var obj = document.getElementById("addImg");
			addImg.innerHTML  = "";
			editor.setContent("");
			
		},
		update: function () {
			var obj = document.getElementById("addImg");
			addImg.innerHTML  = "";
			var id = {};
			if(id == null){
				return ;
			}
			
            $.get(baseURL + "restaurant/evaluates/info/"+id, function(r){
                vm.showList = false;
                vm.title = "修改";
                vm.evaluates = r.evaluates;
               /* editor.setContent(r.evaluates.dishesDetail);*/

                var divImg = document.getElementById("addImg");
                var img = document.createElement("img");
            　　　　		//设置 img 图片地址
            　　　　		img.src = localhostPath+'/file/read/readImg?filePath='+r.evaluates.evaluatesPicPath;
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
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "restaurant/evaluates/delete",
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
			});
		},
		
		
		go: function(){
			window.location.href=path+"modules/restaurant/dishes.html?token="+localStorage.getItem("token");
			},
		
		
		
		 //跳转到evaluate.html
        evaluate:function(){
        	
        	window.location.href=path+"modules/restaurant/evaluate.html?token="+localStorage.getItem("token");
        },
		saveOrUpdate: function () {
            if(vm.validator()){
                return ;
            }
          
			var url = vm.evaluates.id == null ? "restaurant/evaluates/save" : "restaurant/evaluates/update";
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
		
		
		getevaluates: function(id){
			$.get(baseURL + "restaurant/evaluates/info/"+id, function(r){
				vm.evaluates = r.evaluates;
			});
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'createUserName': vm.q.createUserName},
                page:page
            }).trigger("reloadGrid");
		},
		validator: function () {
		  if(isBlank(vm.evaluates.evaluates)){
	                alert("评价人姓名不能为空");
	                return true;
	       }
        }
	}
});

