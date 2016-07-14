var b=document.getElementsByClassName("no3");
var t1=document.getElementById("t1");

t1.addEventListener("click",function(){
show('light');

});
var sw =document.getElementById("ck1");
sw.addEventListener("click",function(){
if(sw.checked){
document.getElementById("switch").style.display='block';
}else{
document.getElementById("switch").style.display='none';
}

  });

var add =document.getElementById("push");
add.addEventListener("click",function(){
var s1=document.getElementById("s1");
var in1=document.getElementById("input1");
var s2=document.getElementById("s2");
var in2=document.getElementById("input2");
var sw2="yes";
var s11="";
var s21="";
if(sw.checked){

}else{
sw2="NO";
}
switch (s1.value)
{
case "1":
  s11="id";
  break;
case "2":
s11="className";
  break;
case "3":
s11="cssSelector";
  break;
case "4":
  s11="linkText";
  break;
case "5":
  s11="name";
  break;
case "6":
  s11="tagName";
  break;
  case "7":
   s11="partialLinkText";
    break;
      case "8":
       s11="xpath";
        break;
}
switch (s2.value)
{
case "1":
  s21="button";
  break;
case "2":
s21="input";
  break;
case "3":
s21="chioce";
  break;
case "4":
  s21="select";
  break;
case "5":
  s21="upload";
  break;
case "6":
  s21="text";
  break;

}
if(in1.value!=null&&in1.value!=""&&in2.value!=null&&in2.value!=""&&s21!=""&&s11!=""){
var t =document.getElementById("t").getElementsByTagName("tbody")[0].innerHTML;
//alert(t);
//t
var t2=t+"<tr><td width=\"50px\" nowrap>"+s21+"</td><td width=\"100px\" nowrap>"+s11+"</td><td nowrap>"+in1.value+"</td><td nowrap>"+in2.value+"</td><td width=\"50px\" nowrap>"+sw2+"</td><td width=\"100px\" nowrap>$100</td></tr>";
document.getElementById("t").innerHTML=t2;
s1.value="1";
s2.value="1";
in1.value=null;
in2.value=null;
hide('light');
}else{
alert("请输入对应的值");
}

});
/*var linode=document.getElementsByTagName("li");
for(i=0;i<linode.length;i++){
linode[i].addEventListener("dblclick",function(){
alert("double");

});
}*/

function show(tag){
 var light=document.getElementById(tag);
 var fade=document.getElementById('fade');
 light.style.display='block';
 fade.style.display='block';
 }
function hide(tag){
 var light=document.getElementById(tag);
 var fade=document.getElementById('fade');
 light.style.display='none';
 fade.style.display='none';
}


var arrayObj = [];
function liclick(a){

//linode=a.id;
//console.log(a.style.backgroundColor);
if(a.style.backgroundColor=="orange"){
a.style.backgroundColor="Bisque";
for(i=0;i<arrayObj.length;i++){
if(arrayObj[i]==a.id){
arrayObj.splice(i,1);
}
}
//alert(arrayObj)
}else{
a.style.backgroundColor="Orange";
arrayObj.push(a.id);
//alert(arrayObj)
}




}



  for (i = 0; i < b.length; i++) {
        b[i].addEventListener("click", function(){
         var idd=Number(this.parentNode.id)+1;
         var c=document.getElementById(idd);
        if(this.innerHTML=="-_"){

     // console.log(idd);

if(c.getAttribute("hidden")=="hidden"){
c.removeAttribute("hidden");
}else{
c.setAttribute("hidden","hidden");}

}

if(this.innerHTML=="+"){
var d= c.getElementsByTagName("ul");
var e=d[0].innerHTML;
var timestamp=new Date().getTime();
d[0].innerHTML=e+"<li onclick=liclick(this) id=\""+timestamp+"\">new page</li>";
//alert(d[0].innerHTML);
}
if(this.innerHTML=="-"){
var d= c.getElementsByTagName("ul");
//alert(arrayObj.length);
if(arrayObj.length==0){
alert("未选中，请查看");}else{
 if (confirm("你确定删除吗？")) {
for(j=0;j<arrayObj.length;j++){
d[0].removeChild(document.getElementById(arrayObj[j]));}
arrayObj=[];
        }
}

}
if(this.innerHTML=="r"){




 if(arrayObj.length==0){
alert("未选中，请查看");
 }else{
 if(arrayObj.length==1){
  var name = prompt("请重命名", "");
   if(name!=null && name!=""){
document.getElementById(arrayObj[0]).innerHTML=name;
document.getElementById(arrayObj[0]).click();
}
 }else{
 alert("只能选择一条哟~！");
 }



 }

}
//alert(c.className);

        });
      }



