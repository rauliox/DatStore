<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Tienda Virtual DAT | Registro</title>
<%@include file="/WEB-INF/jspf/_headercalls.jspf" %>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/table2.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.js" ></script>
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/jquery.easydropdown.js"></script>

<script type="text/javascript">  
            function eliminar(codigo) {
                $.ajax({
                    url: 'Producto',
                    type: 'POST',
                    async: true,
                    data: 'accion=eliminaProducto&idProducto=' + codigo,
                    success:function(data)
                        {
                        if (data==="OK")
                        window.location.href = "Producto?accion=listarProductos&idProducto=-1";
                        else $("#msg").html(data);
                        },
                        error: function (xhr, ajaxOptions, thrownError) {
                $("#msg").html(xhr.status+"<br/>"+thrownError);
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
    <jsp:include page="/Producto?accion=listarProductos&&idProducto=-1" />
    <div  >
        Listado de productos que ha creado el vendedor.
        
        sugerencia: hacer editar y eliminar.

    </div>
    <br>
    <div id="caja" style="margin: auto; width: 1000px" >
    <table>
        <tr>
            <td align="right"><a href="Producto?accion=nuevoProducto&idCategoria=-1">Nuevo Producto</a></td>
        </tr>
    </table>
    </div>
    <br>
    <div id="caja" style="margin: auto; width: 1000px" >
        <table class="navy">
            <caption>Lista de Productos</caption>
        <thead>
            <tr>
                <td>Categoria</td>
                <td>SubCategoria</td>
                <td>Marca</td>
                <td>Modelo</td>
                <td>Descripcion</td>
                <td>Precio</td>
                <td>Unid. Vendidas</td>
                <td>stock</td>
                <td>Modificar</td>
                <td>Eliminar</td>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${listaProd}" var="prod">
            <tr>
                <td>${prod.descCategoria}</td>
                <td>${prod.desSubCategoria}</td>
                <td>${prod.marca}</td>
                <td>${prod.modelo}</td>
                <td>${prod.descripcion}</td>
                <td>${prod.precio}</td>
                <td>${prod.vendidas}</td>
                <td>${prod.stock}</td>
                <td><a href="Producto?accion=nuevoProducto&mostrar=1&idProducto=${prod.idProducto}">Modificar</a></td>
                <td><a href="javascript:eliminar('${prod.idProducto}');">Eliminar</a></td>
                           
            </tr>
        </c:forEach>

        </tbody>
    </table>
        <br>
        <br>
    </div>
   
        <!-- Pie de página -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>