<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Tienda Virtual DAT | Bienvenido Vendedor</title>
<%@include file="../WEB-INF/jspf/_headercalls.jspf" %>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!-- dropdown -->
<script src="js/jquery.easydropdown.js"></script>
</head>
<body>
    <!-- Menú de la parte superior -->
    <%@include file="../WEB-INF/jspf/headmenu.jspf" %>
    
    <!-- Logo, busqueda y menu de categorías -->
    <%@include file="../WEB-INF/jspf/headbottom.jspf" %>
    
    <div style="overflow: auto;">
        <div class="wrap">
            <h4 class="title">Bienvenido Vendedor</h4>
            <div style="text-align: center;">
                <img src="images/presentacion.jpg" />
            </div>
        </div>
    </div>
    
        <!-- Pie de página -->
        <%@include file="../WEB-INF/jspf/footer.jspf" %>
        
</body>
</html>

