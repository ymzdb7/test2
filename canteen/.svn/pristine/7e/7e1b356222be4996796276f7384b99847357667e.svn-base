$(function(){  
            //初始化FullCalendar  
            $('#mycalendar').fullCalendar({  
                //日历初始化默认视图，可选agendaWeek、agendaDay、month  
                defaultView: 'agendaWeek',  
                  
                /*  
                    设置日历头部信息  
                    头部信息包括left、center、right三个位置，分别对应头部左边、头部中间和头部右边。  
                    头部信息每个位置可以对应以下配置：  
                        title: 显示当前月份/周/日信息  
                        prev: 用于切换到上一月/周/日视图的按钮  
                        next: 用于切换到下一月/周/日视图的按钮  
                        prevYear: 用于切换到上一年视图的按钮  
                        nextYear: 用于切换到下一年视图的按钮  
                    如果不想显示头部信息，可以设置header为false  
                */  
                header: {  
                    left: 'prev,next today',  
                    center: 'title',  
                    right: 'month,agendaWeek,agendaDay'  
                },  
                  
                //设置日历头部的日期格式  
                titleFormat: {  
                    month: 'YYYY年MM月',  
                    week: 'YYYY年MM月DD日',  
                    day: 'YYYY年MM月DD日 dddd'  
                },  
                  
                //日历高度  
                height: $(window).height() - 40,  
                  
                //显示周末，设为false则不显示周六和周日。  
                weekends: true,  
                  
                /*  
                    在月视图里显示周的模式，因为每月周数可能不同，所以月视图高度不一定。  
                    fixed：固定显示6周高，日历高度保持不变  
                    liquid：不固定周数，高度随周数变化  
                    variable：不固定周数，但高度固定  
                */  
                weekMode: 'liquid',  
                  
                //日历上显示全天的文本  
                allDayText: '全天',  
                  
                //允许用户通过单击或拖动选择日历中的对象，包括天和时间。  
                selectable: true,  
                  
                //当点击或拖动选择时间时，显示默认加载的提示信息，该属性只在周/天视图里可用。  
                selectHelper: true,  
                  
                //当点击页面日历以外的位置时，自动取消当前的选中状态。  
                unselectAuto: true,  
                  
                /*  
                events: {  
                    url: '',  
                    type: 'post'  
                },  
                */  
                  
                /*  
                    添加日程事件  
                    start: 被选中区域的开始时间  
                    end: 被选中区域的结束时间  
                    jsEvent: jascript对象  
                    view: 当前视图对象  
                */  
                select: function(start, end, jsEvent, view){  
                    //添加日程事件  
                    var $win = $('#addCalendarWin');  
                    $win.find('input[name="start"]').val(start.format('YYYY-MM-DD HH:mm'));  
                    $win.find('input[name="end"]').val(end.format('YYYY-MM-DD HH:mm'));  
                    $win.rhui('window').show();  
                },  
                  
                /*  
                    修改日程事件  
                    当点击日历中的某一日程时，触发此事件  
                    data: 日程信息  
                    jsEvent: jascript对象  
                    view: 当前视图对象  
                */  
                eventClick: function(data, jsEvent, view){  
                    //修改日程事件  
                    var $win = $('#editCalendarWin');  
                    $win.find('input[name="id"]').val(data.id);  
                    $win.find('input[name="title"]').val(data.title);  
                    $win.find('textarea[name="content"]').val(data.cntent);  
                    $win.find('input[name="start"]').val(data.start.format('YYYY-MM-DD HH:mm'));  
                    $win.find('input[name="end"]').val(data.end.format('YYYY-MM-DD HH:mm'));  
                    $win.rhui('window').show();  
                }  
            });  
              
            //初始化新建日程窗口  
            (function(){  
                var $win = $('#addCalendarWin');  
                  
                //初始化日期控件  
                $win.find('input[name="start"]').datetimepicker({format: 'Y-m-d H:i'});  
                $win.find('input[name="end"]').datetimepicker({format: 'Y-m-d H:i'});  
                  
                $win.rhui('window', {  
                    title: '新建日程',  
                    width: 400,  
                    height: 265,  
                    buttons: [{  
                        text: '确定',  
                        cls: 'rhui-btn-primary',  
                        click: function(toolbar, win){  
                            alert('日程已新建');  
                        }  
                    },{  
                        text: '取消',  
                        click: function(toolbar, win){  
                            win.hide();  
                        }  
                    }]  
                }).hide();                
            })();  
              
            //初始化修改日程窗口  
            (function(){  
                var $win = $('#editCalendarWin');  
                  
                //初始化日期控件  
                $win.find('input[name="start"]').datetimepicker({format: 'Y-m-d H:i'});  
                $win.find('input[name="end"]').datetimepicker({format: 'Y-m-d H:i'});  
                  
                $win.rhui('window', {  
                    title: '修改日程',  
                    width: 400,  
                    height: 265,  
                    buttons: [{  
                        text: '确定',  
                        cls: 'rhui-btn-primary',  
                        click: function(toolbar, win){  
                            alert('日程已修改');  
                        }  
                    },{  
                        text: '删除',  
                        cls: 'rhui-btn-danger',  
                        click: function(toolbar, win){  
                            alert('日程已删除');  
                        }  
                    },{  
                        text: '取消',  
                        click: function(toolbar, win){  
                            win.hide();  
                        }  
                    }]  
                }).hide();  
            })();  
        });  