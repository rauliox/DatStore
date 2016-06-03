function valorar(val){
    document.getElementById('valoracion').value=val;
    elementos=document.getElementsByName("val");
    for(i=0;i<elementos.length;i++)
        if(i<(5-val))
            elementos[i].innerHTML='☆';
        else
            elementos[i].innerHTML='★';
}

function cambiarEstado(idOrdenxProducto,estado,valoracion,comentario){
    $.ajax({
        url:"OrdenxProducto",
        data: {
            idOrdenxProducto:idOrdenxProducto,
            accion:'UPDESTADO',
            estado:estado,
            valoracion:valoracion,
            comentario:comentario
        },
        type:'POST',
        success:function(data)
        {
            if (data==="OK")
                window.location.reload();
            else $("#msg").html(data);
        },
        error: function (xhr, ajaxOptions, thrownError) {
            $("#msg").html(xhr.status+"<br/>"+thrownError);
        }
    });
}