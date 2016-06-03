<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Tienda Virtual DAT | Ventas</title>
<%@include file="/WEB-INF/jspf/_headercalls.jspf" %>
<link rel="stylesheet" href="css/jquery-ui.css">
        <script src="js/jquery-ui.js"></script>
        <script type="text/javascript">
            var $dialog;
            var $html1;
            $(function() {
                $html1=$( "<div></div>" );
                 $dialog= $html1.dialog({
                          autoOpen: false,
                          show: {
                            effect: "blind",
                            duration: 300
                          },
                          hide: {
                            effect: "blind",
                            duration: 300
                          },
                          title: 'Producto'
                    });
              });
        </script>
        <script src="js/estados.js"></script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/jquery.easydropdown.js"></script>
<script type="text/javascript">
    function _click(id,orden,producto){
        //$('#c'+id).prop('checked', !$('#c'+id).attr( 'checked' ) );
        $.ajax({
            url:"producto/ordenxproducto.jsp",
            data: {
                idOrdenxProducto:id
            },
            type:'POST',
            success:function(data)
            {
                $html1.html(data);
                $dialog.dialog( "option", "width", $('#labels').width() );
                $dialog.dialog('option', 'title', 'Orden: '+orden+" / Producto: "+producto);
                $dialog.dialog('open');
            },
            error: function (xhr, ajaxOptions, thrownError) {
                $html1.html(xhr.status+"<br/>"+thrownError);
                $dialog.dialog('open');
            }
        });
    }
</script>
</head>
<body> 
    <!-- Menú de la parte superior -->
    <%@include file="/WEB-INF/jspf/headmenu.jspf" %>
    
    <!-- Logo, busqueda y menu de categorías -->
    <%@include file="/WEB-INF/jspf/headbottom.jspf" %>
    
    <jsp:include page="/OrdenxProducto?accion=QRYVENDEDOR&idVendedor=${usuario.idUsuario}" />
    
    <div class="login" style="overflow: auto;">
        
        <div class="wrap">
            <h4 class="title">Productos Vendidos</h4>
             
            <div id="labels" class="column-labels">
                <label class="product-price" style="width:4%"><!--modificaciones-->&nbsp;</label>
                <label class="product-price" style="width:10%">IdOrden</label>
                <label class="product-price" style="width:25%">Producto</label>
                <label class="product-price" style="width:25%">Cliente</label>
                <label class="product-price" style="width:8%; text-align: right;">Precio</label>
                <label class="product-price" style="width:8%; text-align: center;">Cantidad</label>
                <label class="product-price" style="width:8%; text-align: right;">Monto</label>
                <label class="product-price" style="width:12%; text-align: center;">Estado</label>
                
            </div>

            <c:forEach items="${listaProductos}" var="producto">
                <div id="d${producto.idOrdenxProducto}" class="product tablafila" onclick="_click('${producto.idOrdenxProducto}','${producto.idOrden}','${producto.nombreProducto}');">
                    <div class="product-price" style="width:4%">
                        <!--<input type="checkbox" id="c${producto.idOrdenxProducto}" />-->&nbsp;
                    </div>
                    <div class="product-price" style="width:10%">
                        ${producto.idOrden}
                    </div>
                    <div class="product-price" style="width:25%">
                        ${producto.nombreProducto}
                    </div>
                    <div class="product-price" style="width:25%">
                        ${producto.nombreCliente}
                    </div>
                    <div class="product-price" style="width:8%; text-align: right;">
                        S/.${producto.precio/producto.cantidad}
                    </div>
                    <div class="product-price" style="width:8%; text-align: center;">
                        ${producto.cantidad}
                    </div>
                    <div class="product-price" style="width:8%; text-align: right;">
                        S/.${producto.precio}
                    </div>
                    <div class="product-price _${producto.estado}" style="width:12%; text-align: center;">
                        ${producto.descEstado}
                    </div>
                    
                </div>
            </c:forEach>     
            
        </div>

    </div>
        <!-- Pie de página -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>