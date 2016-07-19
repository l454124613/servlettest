var b = document.getElementsByClassName("no3");
var t1 = document.getElementById("t1");
var no1 = document.getElementById("list");
var table = document.getElementById("table");
var isre = null; //是否修改
var xmlhttp;
var arrayObj = [];
no1.addEventListener("click", function () {
    no1.style.width = "20%";
    table.style.width = "55%";


})
t1.addEventListener("click", function () {
    if (arrayObj.length == 0&&isre==null) {
        alert("未选中，请查看");
    } else {
        if (arrayObj.length == 1||isre!=null) {
            show('light');
        } else {
            alert("只能选择一条哟~！");
        }


    }


});
window.onload = function () {
    // document.getElementById("loading").style.display="block";
    var gets = "../1.lx?&method=get&" + "type=page";
    httpget(gets, function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("loading").style.display = "none";
            var obj = JSON.parse(xmlhttp.responseText);

            if (obj.isok == true) {
                var c = document.getElementById("2");
                var d = c.getElementsByTagName("ul");
                var e = d[0].innerHTML;


                //  alert( xmlhttp.responseText);

                //console.log(obj.node);
                var n1 = obj.node;

                //  console.log(n1);
                for (var o in n1) {

                    d[0].innerHTML = e + "<li onclick=liclick(this) id=\"" + n1[o].pid + "\">" + decodeURI(n1[o].name) + "</li>";
                    e = d[0].innerHTML;
                }
            } else {

            }


            //  alert( xmlhttp.responseText);
        } else {

        }

    });
}
var sw = document.getElementById("ck1");
sw.addEventListener("click", function () {
    if (sw.checked) {
        document.getElementById("switch").style.display = 'block';
    } else {
        document.getElementById("switch").style.display = 'none';
    }

});
var s1 = document.getElementById("s1");
var in1 = document.getElementById("input1");
var s2 = document.getElementById("s2");
var s3 = document.getElementById("s3");
var s4 = document.getElementById("s4");
var s6 = document.getElementById("s6");
var in2 = document.getElementById("input2");
var in3= document.getElementById("input3");
var s5 = document.getElementById("s5");
var in4= document.getElementById("input4");
var add = document.getElementById("push");
add.addEventListener("click", function () {

    var sw2 = "yes";
    var s11 = "";
    var s21 = "";
    var in3v="";
    var in4v="";
    if (sw.checked) {


        in3v=in3.value;
        if(in3v==null||in3v==""){
            alert("请输入对应的值");
            return;
        }

        if(s5.value!=0){

            in4v=in4.value;
            if(in4v==null||in4v==""){
                alert("请输入对应的值");
                return;
            }
        }
    } else {
        sw2 = "NO";
    }
s11=swtype(s1.value);
s21=swbutton(s2.value);
    if (in1.value != null && in1.value != "" && in2.value != null && in2.value != "" && s21 != "" && s11 != "") {
        if (isre != null) {

            var gets = "../1.lx?" + "&method=re2&" + "type=element" + "&pid=" + isre.id+"&name=s1:"+s1.value+",s2:"+s2.value+",s3:"+s3.value+",s4:"+s4.value+",s5:"+s5.value+",s6:"+s6.value+",in1:"+in1.value+",in2:"+in2.value+",in3:"+in3.value+",in4:"+in4.value+",sw:"+sw2;
            document.getElementById("loading").style.display = "block";
            httpget(gets, function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    document.getElementById("loading").style.display = "none";
                    var obj = JSON.parse(xmlhttp.responseText);

                    if (obj.isok == true) {
                        isre.innerHTML = "<td width=\"50px\" nowrap>" + s21 + "</td><td width=\"100px\" nowrap>" + s11 + "</td><td nowrap>" + in1.value + "</td><td nowrap>" + in2.value + "</td><td width=\"50px\" nowrap>" + sw2 + "</td><td width=\"100px\" nowrap><button onclick='re(this)'>R</button><button onclick='rm(this)'>X</button></td>";
                        isre = null;
                        s1.value = "1";
                        s2.value = "1";
                        in1.value = null;
                        in2.value = null;
                        in3.value = null;
                        in4.value = null;
                        if(sw.checked){ sw.click();}

                        //   console.log("");
                    } else {
                        alert("插入错误，请查明原因");

                    }
                }


            });



        } else {

            var t = document.getElementById("t").getElementsByTagName("tbody")[0].innerHTML;
//alert(t);
//t

            var timestamp = new Date().getTime();

            var gets = "../1.lx?" + "&method=add&" + "type=element" + "&pid=" + arrayObj+"&name=s1:"+s1.value+",s2:"+s2.value+",s3:"+s3.value+",s4:"+s4.value+",s5:"+s5.value+",s6:"+s6.value+",in1:"+in1.value+",in2:"+in2.value+",in3:"+in3.value+",in4:"+in4.value+",sw:"+sw2+",eid:"+timestamp;
            document.getElementById("loading").style.display = "block";

            httpget(gets, function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    document.getElementById("loading").style.display = "none";
                    var obj = JSON.parse(xmlhttp.responseText);

                    if (obj.isok == true) {
                        var t2 = t + "<tr id='" + timestamp + "'><td width=\"50px\" nowrap>" + s21 + "</td><td width=\"100px\" nowrap>" + s11 + "</td><td nowrap>" + in1.value + "</td><td nowrap>" + in2.value + "</td><td width=\"50px\" nowrap>" + sw2 + "</td><td width=\"100px\" nowrap><button onclick='re(this)'>R</button><button onclick='rm(this)'>X</button></td></tr>";
                        document.getElementById("t").innerHTML = t2;
                        s1.value = "1";
                        s2.value = "1";
                        in1.value = null;
                        in2.value = null;
                        in3.value = null;
                        in4.value = null;
                        if(sw.checked){ sw.click();}

                     //   console.log("");
                    } else {
                        alert("插入错误，请查明原因");

                    }
                }


            });




        }
        hide('light');
    } else {
        alert("请输入对应的值");
    }

});
/*var linode=document.getElementsByTagName("li");
 for(i=0;i<linode.length;i++){
 linode[i].addEventListener("dblclick",function(){
 alert("double");

 });
 }*/
function httpget(url, aa) {
    xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange = aa;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();

}
function show(tag) {
    var light = document.getElementById(tag);
    var fade = document.getElementById('fade');
    light.style.display = 'block';
    fade.style.display = 'block';
}
function hide(tag) {
    var light = document.getElementById(tag);
    var fade = document.getElementById('fade');
    light.style.display = 'none';
    fade.style.display = 'none';
}
function rm(a) {
    if (confirm("你确定删除吗？")) {
        var aa=a.parentNode.parentNode;
        document.getElementById("loading").style.display = "block";
        var gets = "../1.lx?" + "&method=minus&" + "type=element" + "&pid=";
        httpget(gets + aa.id, function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("loading").style.display = "none";
                var obj = JSON.parse(xmlhttp.responseText);

                if (obj.isok == true) {

                    document.getElementById("t").getElementsByTagName("tbody")[0].removeChild(aa);

                    //  console.log(n1);


                    // console.log("");
                } else {

                    alert("删除错误，请查明原因");
                }
            }


        });

        // alert();
    }

}


function re(a) {
    // document.getElementById("push").setAttribute("id","re");
    isre = a.parentNode.parentNode;

    document.getElementById("loading").style.display = "block";
    var gets = "../1.lx?" + "&method=re&" + "type=element" + "&pid=";
    httpget(gets + isre.id, function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("loading").style.display = "none";
            var obj = JSON.parse(xmlhttp.responseText);

            if (obj.isok == true) {
                var n1=obj.node;
                s1.value=n1.type;
                s2.value=n1.button;
                in1.value=n1.value;
                in2.value=n1.buttonvalue;
                if(n1.isswitch=="yes"){
                    sw.click();
                    s3.value=n1.fw;
                    s4.value=n1.stype1;
                    s5.value=n1.fwn;
                    s6.value=n1.stype2;
                    in3.value=n1.svalue1;
                    in4.value=n1.svalue2;
                }else{
                    if(sw.checked){
                        sw.click();
                        s3.value=1;
                        s4.value=9;
                        s5.value=0;
                        s6.value=9;
                        in3.value="";
                        in4.value="";
                    }
                }

                t1.click();

                //  console.log(n1);


                // console.log("");
            } else {

                alert("修改错误，请查明原因");
            }
        }


    });
    t1.click();

}

function liclick(a) {

//linode=a.id;
//console.log(a.style.backgroundColor);
    if (a.style.backgroundColor == "orange") {
        a.style.backgroundColor = "Bisque";
        for (i = 0; i < arrayObj.length; i++) {
            if (arrayObj[i] == a.id) {
                arrayObj.splice(i, 1);
            }
        }
//alert(arrayObj)
    } else {
        a.style.backgroundColor = "Orange";
        arrayObj.push(a.id);
//alert(arrayObj)
    }


}


for (i = 0; i < b.length; i++) {
    b[i].addEventListener("click", function () {
        var idd = Number(this.parentNode.id) + 1;
        var c = document.getElementById(idd);
        if (this.innerHTML == "-_") {

            // console.log(idd);

            if (c.getAttribute("hidden") == "hidden") {
                c.removeAttribute("hidden");
            } else {
                c.setAttribute("hidden", "hidden");
            }

        }

        if (this.innerHTML == "+") {
            var d = c.getElementsByTagName("ul");
            var e = d[0].innerHTML;
            var timestamp = new Date().getTime();
            var gets = "../1.lx?name=new page&" + "pid=" + timestamp + "&method=add&" + "type=page";
            document.getElementById("loading").style.display = "block";
            httpget(gets, function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    document.getElementById("loading").style.display = "none";
                    var obj = JSON.parse(xmlhttp.responseText);

                    if (obj.isok == true) {
                        d[0].innerHTML = e + "<li onclick=liclick(this) id=\"" + timestamp + "\">new page</li>";
                    } else {
                        alert("添加错误，请查明原因");
                    }


                    //  alert( xmlhttp.responseText);
                } else {

                }

            });

//alert(d[0].innerHTML);
        }
        if (this.innerHTML == "-") {
            var d = c.getElementsByTagName("ul");
//alert(arrayObj.length);
            if (arrayObj.length == 0) {
                alert("未选中，请查看");
            } else {
                if (confirm("你确定删除吗？")) {
                    var gets = "../1.lx?" + "&method=minus&" + "type=page" + "&pid=";
                    document.getElementById("loading").style.display = "block";
                    httpget(gets + arrayObj, function () {
                        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                            document.getElementById("loading").style.display = "none";
                            var obj = JSON.parse(xmlhttp.responseText);

                            if (obj.isok == true) {
                                for (j = 0; j < arrayObj.length; j++) {

                                    d[0].removeChild(document.getElementById(arrayObj[j]));
                                }
                                arrayObj = [];
                            } else {
                                alert("删除错误，请查明原因");
                            }


                            //  alert( xmlhttp.responseText);
                        } else {

                        }

                    });

                }
            }

        }
        if (this.innerHTML == "r") {
            if (arrayObj.length == 0) {
                alert("未选中，请查看");
            } else {
                if (arrayObj.length == 1) {
                    var name = prompt("请重命名", "");
                    if (name != null && name != "") {
                        var gets = "../1.lx?" + "&method=re&" + "type=page" + "&pid=";
                        document.getElementById("loading").style.display = "block";

                        httpget(gets + arrayObj + "&name=" + name, function () {
                            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                                document.getElementById("loading").style.display = "none";
                                var obj = JSON.parse(xmlhttp.responseText);

                                if (obj.isok == true) {
                                    document.getElementById(arrayObj[0]).innerHTML = name;
                                    document.getElementById(arrayObj[0]).click();
                                } else {
                                    alert("修改错误，请查明原因");
                                }


                                //  alert( xmlhttp.responseText);
                            } else {

                            }

                        });

                    }
                } else {
                    alert("只能选择一条哟~！");
                }
            }
        }
        if (this.innerHTML == "Go") {
            if (arrayObj.length == 0) {
                alert("未选中，请查看");
            } else if (arrayObj.length == 1) {
                document.getElementById("t").innerHTML ="";
                var gets = "../1.lx?" + "&method=go&" + "type=element" + "&pid=";
                document.getElementById("loading").style.display = "block";

                httpget(gets + arrayObj, function () {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                        document.getElementById("loading").style.display = "none";
                        var obj = JSON.parse(xmlhttp.responseText);

                        if (obj.isok == true) {
                            no1.style.width = "0%";
                            table.style.width = "75%";
                            var n1 = obj.node;

                            //  console.log(n1);
                            var t2="";
                            for (var o in n1) {

                                var t2 = t2 + "<tr id='" + n1[o].eid + "'><td width=\"50px\" nowrap>" +swbutton( n1[o].button) + "</td><td width=\"100px\" nowrap>" +swtype(n1[o].type)+ "</td><td nowrap>" + n1[o].value  + "</td><td nowrap>" + n1[o].buttonvalue  + "</td><td width=\"50px\" nowrap>" + n1[o].isswitch + "</td><td width=\"100px\" nowrap><button onclick='re(this)'>R</button><button onclick='rm(this)'>X</button></td></tr>";


                            }
                            document.getElementById("t").innerHTML = t2;
                           // console.log("");
                        } else {

                            alert("加载错误，请查明原因");
                        }
                    }


                });
            }else {
                alert("只能选择一条哟~！");
            }
        }
    });
}
function swtype(a){
    var s11="";
    switch (a) {
        case "1":
            s11 = "id";
            break;
        case "2":
            s11 = "className";
            break;
        case "3":
            s11 = "cssSelector";
            break;
        case "4":
            s11 = "linkText";
            break;
        case "5":
            s11 = "name";
            break;
        case "6":
            s11 = "tagName";
            break;
        case "7":
            s11 = "partialLinkText";
            break;
        case "8":
            s11 = "xpath";
            break;
    }
    return s11;
}
function swbutton(a){
    var s21="";
    switch (a) {
        case "1":
            s21 = "button";
            break;
        case "2":
            s21 = "input";
            break;
        case "3":
            s21 = "chioce";
            break;
        case "4":
            s21 = "select";
            break;
        case "5":
            s21 = "upload";
            break;
        case "6":
            s21 = "text";
            break;

    }
return s21;
}


