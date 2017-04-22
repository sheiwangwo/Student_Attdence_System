/**
 * Created by silence on 15-6-23.
 */
var xmlHttpRequest;
function createXmlHttpRequest(){
    if(window.ActiveXObject){ //如果是IE浏览器
        return new ActiveXObject("Microsoft.XMLHTTP");
    }else if(window.XMLHttpRequest){ //非IE浏览器
        return new XMLHttpRequest();
    }
}
function requestByGET(){
    var type="selectAll";

    /*var radio = document.getElementsByName("search");
    //var text = document.getElementById("Info").value;
    for(var i = 0;i<radio.length;i++)
    {
        if(radio[i].checked)
            type = radio[i].value;
    }*/

    var string = "type="+type;
    var url="./Servlet?"; //这里写上跳转到structs的路径和方法,并把参数传进去
    url = url+string;

    xmlHttpRequest=createXmlHttpRequest();
    xmlHttpRequest.onreadystatechange=callBack;
    xmlHttpRequest.open("GET",url,true); //true是异步请求
    xmlHttpRequest.send(null);
}
function callBack(){
    if(xmlHttpRequest.readyState == 4&&xmlHttpRequest.status == 200)
    {
        var state = xmlHttpRequest.responseText;
        if(state == "error") {
            var responseDiv = document.getElementById("error");
            if (responseDiv.hasChildNodes()) {
                responseDiv.removeChild(responseDiv.chileNode[0]);
            }
            var responseText = document.createTextNode("查询失败！");
            responseDiv.appendChild(responseText);
        }
        else {
            var responseDiv=document.getElementById("table");
            var responseText=document.createTextNode(xmlHttpRequest.responseText);
            responseDiv.innerHTML = xmlHttpRequest.responseText;
            if (responseDiv.hasChildNodes()) {
                responseDiv.removeChild(responseDiv.chileNode[0]);
            }
            document.body.appendChild(responseDiv);
        }
    }
}
function getCindition()
{
    var select1 = document.getElementById("campus");
    var select2 = document.getElementById("major");
}