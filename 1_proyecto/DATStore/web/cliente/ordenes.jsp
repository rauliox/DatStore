<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Tienda Virtual DAT | Registro</title>
<%@include file="/WEB-INF/jspf/_headercalls.jspf" %>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/table.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script> 
<!--<script src="js/jquery.easydropdown.js"></script>-->
<script src="js/crudOrden.js" type="text/javascript"></script>
<script src="js/jquery.easydropdown.js"></script>
</head>
<body> 
    <!-- Menú de la parte superior -->
    <%@include file="/WEB-INF/jspf/headmenu.jspf" %>
    
    <!-- Logo, busqueda y menu de categorías -->
    <%@include file="/WEB-INF/jspf/headbottom.jspf" %>
    <jsp:include page="/Orden?accion=QRY" />
    <div class="wrap">
        <h4 class="title">Productos Vendidos</h4>
        
        <div id="labels" class="column-labels">
                <label class="product-price" style="width:4%">&nbsp;</label>
                <label class="product-price" style="width:32%">Numero de Orden</label>
                <label class="product-price" style="width:32%">Fecha de Creacion</label>
                <label class="product-price" style="width:32%">Estado de la Orden</label>
        </div>
   
        <c:forEach items="${list}" var="o">
            <div id="d${o.idOrden}" class="product tablafila" onclick="window.location.href='cliente/ordenesxProductos.jsp?idOrden=${o.idOrden}'">
                    <div class="product-price" style="width:4%">
                        &nbsp;
                    </div>
                    <div class="product-price" style="width:32%">
                        ${o.idOrden}
                    </div>
                    <div class="product-price" style="width:32%">
                        ${o.fechaCreada}
                    </div>
                    <div class="product-price" style="width:32%">
                        ${o.estado}
                    </div>                    
                </div>
            </c:forEach>

    </div>
        <!-- Pie de página -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>