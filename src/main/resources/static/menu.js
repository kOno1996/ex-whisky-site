function openClose(){
    var obj = document.getElementsByClassName('openHere');
    for(var i=0;i<obj.length;i++){
        //非表示ならインライン要素に変更。表示状態なら非表示に変更。
        if(obj[i].style.display == "inline-block"){
            obj[i].style.display = "none";
        }
        else{
            obj[i].style.display = "inline-block";
        }
    }
}