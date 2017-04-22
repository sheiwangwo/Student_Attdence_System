/**
 * Created by silence on 15-6-23.
 */
function myselect()
{
    var s1=document.getElementById("campus");
    var select2=document.getElementById("major");
    var number=select2.options.length;
    for(var j=select2.length-1;j>=0;j--){
        select2.removeChild(select2.childNodes.item(j));
    }
    var dopt = document.createElement("OPTION");
    dopt.text="请选择专业";
    dopt.value="null";
    select2.add(dopt);
    if(s1.value=="信息工程学院")
    {
        var opt = document.createElement("OPTION");
        opt.text = "软件工程";
        opt.value = "SE";
        opt.selected=false;
        select2.add(opt);

        var opt2 = document.createElement("OPTION");
        opt2.text = "信息工程";
        opt2.value = "XG";
        opt2.selected=false;
        select2.add(opt2);

        var opt3 = document.createElement("OPTION");
        opt3.text = "测绘工程";
        opt3.value = "CH";
        opt3.selected=false;
        select2.add(opt3);

        var opt4 = document.createElement("OPTION");
        opt4.text = "遥感科学与技术";
        opt4.value = "YG";
        opt4.selected=false;
        select2.add(opt4);

        var opt5 = document.createElement("OPTION");
        opt5.text = "地理信息系统";
        opt5.value = "DX";
        opt5.selected=false;
        select2.add(opt5);
    }
    else if(s1.value=="地学院")
    {
        var opt6 = document.createElement("OPTION");
        opt6.text = "地理学";
        opt6.value = "DX";
        opt6.selected=false;
        select2.add(opt6);
    }
    else if(s1.value == "外国语学院")
    {
        var opt7 = document.createElement("OPTION");
        opt7.text = "英语";
        opt7.value = "EN";
        opt7.selected=false;
        select2.add(opt7);

        var opt8 = document.createElement("OPTION");
        opt8.text = "法语";
        opt8.value = "FR";
        opt8.selected=false;
        select2.add(opt8);
    }
}
function add()
{
    window.location.href='addInfomation.html';
}
function update()
{
    window.location.href='changeInfo.html';
}
    var xmlHttpRe;
    function createXmlHttpRequest(){
        if(window.ActiveXObject){ //如果是IE浏览器
            return new ActiveXObject("Microsoft.XMLHTTP");
        }else if(window.XMLHttpRequest){ //非IE浏览器
            return new XMLHttpRequest();
        }
    }
    function deleteByGet(ID){
        var type="delete";
        //var ID=document.getElementById("ID").value;
        var string ="type="+type+ "&ID="+ID;
        var url="./Servlet?"; //这里写上跳转到structs的路径和方法,并把参数传进去
        //url=encodeURI(url);
        url = url+string;

        xmlHttpRe=createXmlHttpRequest();
        xmlHttpRe.onreadystatechange=callBackA;
        xmlHttpRe.open("GET",url,true); //true是异步请求
        xmlHttpRe.send(null);
    }
    function callBackA(){
        //var r_value=xmlHttpRequest.responseText;
        //var r_status=xmlHttpRequest.readyState;
        if(xmlHttpRe.readyState == 4&&xmlHttpRe.status == 200)
        {
            var state = xmlHttpRe.responseText;
            if(state == "error") {
                alert("删除失败！");
            }
            else {
                alert("删除成功!");
            }
        }
    }