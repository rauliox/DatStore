 
            function agregar(idProducto) {
                var cant = document.getElementById('cant').value;
                $.ajax({
                    url: 'Carrito',
                    type: 'POST',
                    async: true,
                    data: 'accion=Alcarrito&idProducto=' + idProducto+'&cantidad=' + cant,
                    success: function (){
            
                    window.location.href ="carrito.jsp";
                          }  
                     
                });
            }
         

 
        
         
           function eliminar(idProducto) {
                $.ajax({
                    url: 'Carrito',
                    type: 'POST',
                    async: true,
                    data: 'accion=eliminar&idProducto=' + idProducto,
                    success: function() { 
                    window.location.href ="carrito.jsp";
                   // $("#"+idProducto).remove();
                    }
                });
            }
      
      
 
            function limpiar() {
                $.ajax({
                    url: 'Carrito',
                    type: 'POST',
                    async: true,
                    data: 'accion=limpiar',
                    success: function(data) { $('#msg2').html(data);}
                   
                });
            }
         

            function change(idProducto,i){
              var valor =String(document.getElementById('cantidad_'+i).value);
              window.location.href ='Carrito?accion=cambiarcant&idProducto='+ idProducto+'&cantidad='+ valor;
              /*
              var url='accion=cambiarcant&idProducto='+ idProducto+'&cantidad='+ valor
              $.ajax({
                    url: 'Carrito',
                    type: 'POST',
                    async: true,
                    data: url,
                    success:  function(response)
                         {
                               //obj = JSON.parse(response);
                    //window.location.href = "carrito.jsp";
                         // alert(obj.toString());
                     }
                   
                });*/
              
            }
            

    