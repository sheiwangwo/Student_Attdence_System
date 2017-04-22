
function CLASS_LIANDONG_YAO(array)
    {
        //数组，联动的数据源
        this.array=array;
        this.indexName='';
        this.obj='';
        //设置子SELECT
        // 参数：当前onchange的SELECT ID，要设置的SELECT ID
        this.subSelectChange=function(selectName1,selectName2)
        {
            //try
            //{
            var obj1=document.all[selectName1];
            var obj2=document.all[selectName2];
            var objName=this.toString();
            var me=this;
            obj1.onchange=function()
            {
                me.optionChange(this.options[this.selectedIndex].value,obj2.id)
            }
        }
        //设置第一个SELECT
        // 参数：indexName指选中项,selectName指select的ID
        this.firstSelectChange=function(indexName,selectName)
        {
            this.obj=document.all[selectName];
            this.indexName=indexName;
            this.optionChange(this.indexName,this.obj.id)
        }
        // indexName指选中项,selectName指select的ID
        this.optionChange=function (indexName,selectName)
        {
            var obj1=document.all[selectName];
            var me=this;
            obj1.length=0;
            obj1.options[0]=new Option("请选择",'');
            for(var i=0;i<this.array.length;i++)
            {
                if(this.array[i][1]==indexName)
                {
                    //alert(this.array[i][1]+" "+indexName);
                    obj1.options[obj1.length]=new Option(this.array[i][2],this.array[i][0]);
                }
            }
        }
    }

var array=new Array();
array[0]=new Array("华南地区","根目录","华南地区"); //数据格式 ID，父级ID，名称
array[1]=new Array("华北地区","根目录","华北地区");
array[2]=new Array("上海","华南地区","上海");
array[3]=new Array("广东","华南地区","广东");
array[4]=new Array("徐家汇","上海","徐家汇");
array[5]=new Array("普托","上海","普托");
array[6]=new Array("广州","广东","广州");
array[7]=new Array("湛江","广东","湛江");
//--------------------------------------------
//这是调用代码
var liandong=new CLASS_LIANDONG_YAO(array) //设置数据源
liandong.firstSelectChange("根目录","s1"); //设置第一个选择框
liandong.subSelectChange("s1","s2"); //设置子级选择框
liandong.subSelectChange("s2","s3");