var columns=[],url;
$(function(){
    $('#search').click(function(){
        $("#table-container").html('<table class="table table-bordered"  id="showTable"></table>');
        $('#search-text').empty();
        if((url=getUrl())){
            columns=createColumns(url);
            initTable(url,columns);
        }
    })
})


function createColumns(url) {
        let columns=[];
        $.ajax({
            url:url,
            type:"get",
            async:false,
            success:function(data){
                let divGroup=$('<div class="form-group block"></div>');
                if(data.rows&&data.rows.length>0){
                    Object.getOwnPropertyNames(data.rows[0]).map((name,i)=>{
                        let obj={};
                        obj.field=name;
                        obj.title=name;
                        if(typeof data.rows[0][name]=='string'){
                            obj.width='center';
                        }
                        //生成input文本框
                        let divContainer=$('<div class="my-container">' +
                            '<label class="myLabel-content">'+name+'：</label>' +
                            '<div class="myText-content">' +
                            '<input id="'+name+'" name="'+name+'" type="text" class="form-control" placeholder="输入'+name+'">' +
                            '</div>' +
                            '</div>');
                        divGroup.append(divContainer);
                        let length=Object.getOwnPropertyNames(data.rows[0]).length; //获取表格列的长度
                        //如果i等于3时就拼接成一行
                        if((i+1)%3==0||i==length-1){
                            $('#search-text').append(divGroup);
                            divGroup=$('<div class="form-group block"></div>');
                        }

                        columns.push(obj);


                    })
                }
                let lastColumn={
                    title: '操作',
                    field: 'id',
                    width: '110px',
                    align: 'center',
                    formatter: function (value, row, index) {
                        var e = '<a class="btn btn-primary btn-xs " href="#" mce_href="#" title="编辑" onclick="edit(\''
                            + row.id + '\',\'' + row.nodeType + '\',\'' + row.name
                            + '\')"><i class="fa fa-edit"></i>编辑</a> ';
                        var d = '<a class="btn btn-warning btn-xs" href="#" title="删除"  mce_href="#" onclick="remove(\''
                            + row.id
                            + '\')"><i class="fa fa-remove">删除</i></a> ';
                        var f = '<a class="btn btn-success btn-xs" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                            + row.id
                            + '\')"><i class="fa fa-key"></i>备用</a> ';
                        return e + d;
                    }};
                columns.push(lastColumn);
            }
        })
        return columns;
}
function getUrl() {
   let tableName=$("#tableName").val(),url='';
   if(tableName){
       url="/"+tableName+"/list";
   }
  return url;
}
function initTable(url,columns){
    $('#showTable').bootstrapTable(
        {
            method: 'get', // 服务器数据的请求方式 get or post
            url: url, // 服务器数据的加载地址
            //	showRefresh : true,
            //	showToggle : true,
            //	showColumns : true,
            iconSize: 'outline',
            //toolbar: '#exampleToolbar',
            striped: true, // 设置为true会有隔行变色效果
            dataType: "json", // 服务器返回的数据类型
            pagination: true, // 设置为true会在底部显示分页条
            // queryParamsType : "limit",
            // //设置为limit则会发送符合RESTFull格式的参数
            singleSelect: false, // 设置为true将禁止多选
            // contentType : "application/x-www-form-urlencoded",
            // //发送到服务器的数据编码类型
            pageSize: 10, // 如果设置了分页，每页数据条数
            pageNumber: 1, // 如果设置了分布，首页页码
            //search : true, // 是否显示搜索框
            showColumns: false, // 是否显示内容下拉框（选择显示的列）
            sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
            formatLoadingMessage: function() {                    // 表格生成过程中执行的方法
                return '请稍等，正在加载中...';                        // 返回一串等待文字
            },
            formatNoMatches: function() {                          // 没有匹配的结果执行的方法
                return '无符合条件的记录';                            // 返回一串提示文字
            },
            queryParams: function (params) {

                return {
                    //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                    limit: params.limit,
                    offset: params.offset,
                    /*key: $('#searchName').val(),
                    parentId: $("#parentId").val(),
                    id: id,*/
                    // name:$('#searchName').val(),
                    // username:$('#searchName').val()
                };
            },
            //加载成功时执行
            onLoadSuccess: function () {
                $(".pagination").css('margin','0');
                let height=screen.height,footer=$('.clearfix').height();
                $('.fixed-table-body').css({
                    'height':'auto',
                    'max-height':(height*0.54-footer)+'px'
                });
            },
            // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
            // queryParamsType = 'limit' ,返回参数必须包含
            // limit, offset, search, sort, order 否则, 需要包含:
            // pageSize, pageNumber, searchText, sortName,
            // sortOrder.
            // 返回false将会终止请求
            columns:columns
        });
}