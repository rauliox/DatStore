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
    
    <div >
        Una vez seleccionada la orden dentro de la pantalla ordenes.jsp. Se ve en esta pantalla una lista con los productos de dicha orden
        
        Producto, Cantidad, precio, Estado, botones de cambio
        
        Los botones de cambio permitirá anular, aceptar, rechazar, y/o valorar de acuerdo al diagrama de estados de como se comporta un producto en una orden.
        
        
        sugerencia: hacer una flechita con colorcitos que indique la fecha en la cual se ha realizado cada paso de la compra.

    </div>
        <!-- Pie de página -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>