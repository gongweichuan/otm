var _footer_content = '<div id="" class="">';
_footer_content += '<div class="">';
_footer_content += '<div>&copy; 2013	GCYZ版权所有</div>';
_footer_content += '</div>';
_footer_content += '</div>';

document.write(_footer_content);


/*****主要工作区域自适应***********/
SetWrapperFull=function(fullClassName){
//没有右侧区域自动更改工作区宽度
try{
	var floatObj=document.getElementById("float");
	var wrapperObj=document.getElementById("wrapper");
	var footerObj=document.getElementById("footer");
    if(wrapperObj==null || typeof(wrapperObj)=="undefind"){
		return;
	}

	if(floatObj==null || typeof(floatObj)=="undefind"){
		wrapperObj.className=fullClassName;
		return;
	} else {
		f_h=floatObj.offsetHeight;
		w_h=wrapperObj.offsetHeight;
		if(footerObj.offsetTop<floatObj.offsetHeight)
		footerObj.style.margin=(30+f_h-w_h)+"px auto 0 auto";
	}
}catch(e){}}
/*设置工作区全屏*/
SetWrapperFull("wrapper_full");

/******************分隔线开始****************************************/
var CVO_Split_Line=new Object();
CVO_Split_Line._name='CVO_Split_Line';
CVO_Split_Line._line=null;
CVO_Split_Line._frameset=null;
CVO_Split_Line._initialized=false;
CVO_Split_Line._expanded=true;

CVO_Split_Line.initialize=function()
{
try
{
if(this._initialized) return;
this._line=document.createElement("div");

this._frameset=parent.document.getElementsByTagName("frameset")[0];  
if (this._frameset==null || typeof(this._frameset)=="undefind") return;
this._line.className="splitClose";   

this._line.onmouseover=new Function('event','window.'+this._name+'.over(event);');
this._line.onmouseout=new Function('event','window.'+this._name+'.out(event);');
this._line.onclick=new Function('event','window.'+this._name+'.click(event);');

document.body.appendChild(this._line);
this._initialized=true;
}catch (ex)
{this._initialized=false;}
}

CVO_Split_Line.over=function()
{
if(!this._initialized) return;
if(this._expanded) this._line.className="splitCloseOver";
else this._line.className="splitOpenOver";     
}

CVO_Split_Line.out=function()
{
if(!this._initialized) return;
if(this._expanded) this._line.className="splitClose";
else this._line.className="splitOpen";
}

CVO_Split_Line.click=function()
{
if(!this._initialized) return;
if(this._expanded) {
	this._line.className="splitOpen";
    this._frameset.setAttribute("cols","0,*");
	this._expanded=false;
}else{
	this._line.className="splitClose";
	this._frameset.setAttribute("cols","190,*");
	this._expanded=true;
}}

CVO_Split_Line.initialize();
/******************分隔线结束****************************************/
