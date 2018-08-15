function build_table(){
    // 构造表单并提交
    var childs = $("#IUtable>tbody>tr");
    var ips = "";
    var urls = "";
    for (var i = 2; i<childs.length; i++){
        ips += $("td:eq(0)>input:eq(0)" ,childs[i]).val()+"|||";
        urls += $("td:eq(1)>input:eq(0)", childs[i]).val()+"|||";
    }
    ips = ips.substring(0, ips.length-3);
    urls = urls.substring(0, urls.length-3);
    console.log(ips);
    console.log(urls);
    $("#ip").val(ips);
    $("#url").val(urls);
    $("form").submit();
}


function delete_row(bt_element){
    // 实现删除行的功能
    // 首先检查是否只剩下一行，如果是，那么拒绝删除操作
    if($("#IUtable>tbody>tr").length == 3){
        $(".alert-warning").remove();

        $("                <div class=\"alert alert-warning alert-dismissible\" role=\"alert\">\n" +
            "                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">×</span></button>\n" +
            "                    <p id=\"msg\">请至少填写一行</p>\n" +
            "                </div>\n").insertBefore($("#IUtable"))
    }else {
        $(bt_element).parent().parent().remove();
    }
}

function add_row(){
    // 增加行
    var tr = $("#tr_for_cp").clone(true,true);
    tr.removeAttr("hidden").removeAttr("id");
    $("input[type='text'].form-control").attr("required","required");
    $("#IUtable>tbody").append(tr);
}