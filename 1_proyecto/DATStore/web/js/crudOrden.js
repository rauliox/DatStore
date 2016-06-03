function js_selProductos(){
    var idOrden=document.getElementsByName('orden_sel');
    window.location = "OrdenxProducto?accion=QRY&orden_sel="+idOrden;
}

function js_upd(){
}

function js_del(){
    var idOrden = document.getElementsByName('chk_del');
    
    var idOrden_param="";
    for(var i=0;i<idProfesores.length;i++){
        
        if(idOrden[i].checked){
        idOrden_param += idOrden[i].value+",";
        }
    }
    //Falta configurar el orden delete
    window.location = "../../Orden?accion=DEL&&ids="+idOrden_param;
}
