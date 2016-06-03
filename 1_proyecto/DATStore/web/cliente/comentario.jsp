<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Tienda Virtual DAT | Registro</title>
<%@include file="/WEB-INF/jspf/_headercalls.jspf" %>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/jquery.easydropdown.js"></script>
</head>
<body> 
    <!-- Menú de la parte superior -->
    <%@include file="/WEB-INF/jspf/headmenu.jspf" %>
    
    <!-- Logo, busqueda y menu de categorías -->
    <%@include file="/WEB-INF/jspf/headbottom.jspf" %>
    
    <div>
       <form action="OrdenxProducto" method="GET">
            <table>
                <input type="hidden" value="INSC" name="accion">
                <input type="hidden" name="idOrdenxProducto" value="${idOrdenxProducto}">
                <input type="hidden" name="idOrden" value="${idOrden}">
                <tr><td>
                        Estimado ${usuario.nombre}, Por favor, describa la razón por la cual cancelo su pedido
                        N° ${idOrdenxProducto}
                    </td></tr>
                <tr><td><textarea name="comentario">
                            &nbsp;
                        </textarea></td></tr>
                <tr><td>Valoracion:</td><td><input type="text" name="valoracion">&nbsp;</td></tr>
                <tr><td><input type="submit" name="Enviar"></td></tr>
            </table>            
        </form>
    </div>
        <!-- Pie de página -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>