$(document).ready(function () {
    
    $(".periodo").hide();
    $(".periodo").attr('disabled',true);
    $("#1843570").change(func)
            .change();

});


function func(){

    $("#18435702").attr('selectedIndex', '0');
    $(".periodo").hide();
    $(".periodo").attr('disabled',true);
    
    if($("#1843570 option:selected")[0].value != 0){
        $(".pp"+$("#1843570 option:selected")[0].id).show();
        $(".pp"+$("#1843570 option:selected")[0].id).attr('disabled',false);
    }

}
