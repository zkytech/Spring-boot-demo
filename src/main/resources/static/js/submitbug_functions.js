function build_table(){
    var childs=document.getElementById("IUtable").getElementsByTagName("tr");
    var ips = "";
    var urls = "";
    for(var i=2;i<childs.length;i++){
        ips += childs[i].getElementsByTagName("td").item(0).getElementsByTagName("input").item(0).value + "|||";// |||是多个IP/URL的分隔符
        urls += childs[i].getElementsByTagName("td").item(1).getElementsByTagName("input").item(0).value + "|||";
    }
    ips=ips.substring(0,ips.length-3);
    urls=urls.substring(0,urls.length-3);
    console.log("ips="+ips);
    console.log("urls="+urls);
    document.getElementById("ip").value=ips;
    document.getElementById("url").value=urls;
    document.forms.item(0).submit();
}

function delete_row(bt_element){
    // 实现删除行的功能
    // 首先检查是否只剩下一行，如果是，那么拒绝删除操作
    if(document.getElementById("IUtable").getElementsByTagName("tr").length==3){
        alert("请至少填写一行");
    }else{
        bt_element.parentElement.parentElement.remove();}
}

function add_row(){
    // 实现增加行的功能
    var tr = document.getElementById("tr_for_cp").cloneNode(true);  // 这里需要克隆后代，所以设置为true，默认为false
    tr.removeAttribute("hidden");
    tr.getElementsByTagName("input").item(0).setAttribute("required","required");
    tr.getElementsByTagName("input").item(1).setAttribute("required","required");
    document.getElementById("IUtable").appendChild(tr);
}