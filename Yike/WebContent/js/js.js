$(document).ready(function(){
				$('#iview').iView({
					pauseTime: 4000,
					directionNav: false,
					controlNav: true,
					tooltipY: -15
				});
			});
//表单验证

function submit(){
        var note=document.getElementById('note').value;
        var name=document.getElementById('name').value;
        var phone=document.getElementById('phone').value;
        var phoneTxt=document.getElementById('phone');
        var email=document.getElementById('email').value;
        var emailTxt=document.getElementById('email');
        var myreg = /^([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+@([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+.[a-za-z]{2,3}$/;
        if (note==""||name==""||phone==""||email=="") {
            alert("*号为必填");
            return false;
        }else if(!/^1[3458]\d{9}$/.test(phone)){
            alert('手机号码格式不正确');
            phoneTxt.focus();
            return false;
        }else if(!myreg.test(email)){
            alert('邮箱格式不正确');
            emailTxt.focus();
             return false;
         }
         else{return true;}
    }

//友情链接
function MM_o(selObj){
window.open(selObj.options[selObj.selectedIndex].value);
};

    //回到顶部
    $(function(){   
    $(window).scroll(function() {       
        if($(window).scrollTop() >= 100){
            $('.actGotop').fadeIn(300); 
        }else{    
            $('.actGotop').fadeOut(300);    
        }  
    });
    $('.actGotop').click(function(){
    $('html,body').animate({scrollTop: '0px'}, 800);}); 
});

//    window.onload = function(){
//     //相册滚动
//     var speed=10;
//     var tab=document.getElementById("demo");
//     var tab1=document.getElementById("demo1");
//     var tab2=document.getElementById("demo2");
//     tab2.innerHTML=tab1.innerHTML;
//     function Marquee(){
//     if(tab2.offsetWidth-tab.scrollLeft<=0)
//     tab.scrollLeft-=tab1.offsetWidth
//     else{
//     tab.scrollLeft++;
//     }
//     }
//     var MyMar=setInterval(Marquee,speed);
//     tab.onmouseover=function() {clearInterval(MyMar)};
//     tab.onmouseout=function() {MyMar=setInterval(Marquee,speed)};
// }

// function hide(){
//     var TipBox = document.getElementById("tipCon");
//     var CloseBtn = document.getElementById("closeBtn");
//     CloseBtn.onclick = function(){
//          TipBox.style.display = 'none';//改变显示属性
//          TipBox.remove();//删除节点及内容
// }
// }


function autoScroll(obj, ul_bz){
 $(obj).find(ul_bz).animate({
  marginTop : "-25px"
 },500,function(){
  $(this).css({marginTop : "0px"}).find("li:first").appendTo(this);
 });
}
setInterval('autoScroll("#oDiv", "#oUl")',2000);

function addEvent(obj,evt,fn){
            var saved;
            if(typeof obj["on"+evt] == "function"){
                saved = obj["on"+evt];   
            }
            obj["on"+evt] = function(){         
                if(saved){
                    saved();
                }        
                fn();   
            }
        }
         //相册滚动
addEvent(window,'load',firstAll);  
function firstAll() {  
    var speed=10;
    var tab=document.getElementById("demo");
    var tab1=document.getElementById("demo1");
    var tab2=document.getElementById("demo2");
    tab2.innerHTML=tab1.innerHTML;
    function Marquee(){
    if(tab2.offsetWidth-tab.scrollLeft<=0)
    tab.scrollLeft-=tab1.offsetWidth
    else{
    tab.scrollLeft++;
    }
    }
    var MyMar=setInterval(Marquee,speed);
    tab.onmouseover=function() {clearInterval(MyMar)};
    tab.onmouseout=function() {MyMar=setInterval(Marquee,speed)};
}  
addEvent(window,'load',nextAll);  
        function nextAll() {  
           
    //留言框

    var TipBox = document.getElementById("tipCon");
    var CloseBtn = document.getElementById("closeBtn");
    CloseBtn.onclick = function(){
         TipBox.style.display = 'none';//改变显示属性
         TipBox.remove();//删除节点及内容 
        }  
    }