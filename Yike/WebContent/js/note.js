 window.onload = function(){
    
    //留言框

    var TipBox = document.getElementById("tipCon");
    var CloseBtn = document.getElementById("closeBtn");
    CloseBtn.onclick = function(){
         TipBox.style.display = 'none';//改变显示属性
         TipBox.remove();//删除节点及内容
       
}
}
