<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Diseño adaptado por un equipo DAT a partir
de una plantilla creative commons de http://w3layouts.com
-->
<!DOCTYPE HTML>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%//Carga del objeto Búsqueda%>
<jsp:include page="/BusquedaProducto?accion=iniciarbusqueda" />

<html>
<head>
<title>Tienda Virtual DAT | Inicio</title>
<%@include file="WEB-INF/jspf/_headercalls.jspf" %>

<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script type="text/javascript" src="js/operacionescarrito.js"></script> 
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<c:if test="${empty busquedaProducto.idCategoria && empty busquedaProducto.idSubcategoria && empty busquedaProducto.busqueda}">
<!--start slider -->
    <link rel="stylesheet" href="css/fwslider.css" media="all">
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/css3-mediaqueries.js"></script>
    <script src="js/fwslider.js"></script>
<!--end slider -->
</c:if>
<script src="js/jquery.easydropdown.js"></script>
<script type="text/javascript">
    function buscar(parametros) {
        $.ajax({
            url: 'BusquedaProducto',
            type: 'POST',
            async: true,
            data: $("#criterios").serialize() + '&accion=buscar&' + parametros,
            success: function(response) {
                $("#listado").html(response);
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

    <c:if test="${empty busquedaProducto.idCategoria && empty busquedaProducto.idSubcategoria && empty busquedaProducto.busqueda}">
        <!-- Slider de la página principal -->
        <%@include file="/WEB-INF/jspf/frontslider.jspf" %>
    </c:if>
        
<!-- Contenido -->
<div class="mens">
    <div class="main">
        <div class="wrap">
            <div id="listado">
                <%@include file="/producto/busquedaproducto.jsp" %>
            </div>
            <form id="criterios">
                <c:choose>
                    <c:when test="${not empty busquedaProducto.idCategoria}">
                        <input type="hidden" id="idCategoria" value="${busquedaProducto.idCategoria}" />
                    </c:when>
                    <c:when test="${not empty busquedaProducto.idSubcategoria}">
                        <input type="hidden" id="idSubcategoria" value="${busquedaProducto.idSubcategoria}" />
                    </c:when>
                    <c:when test="${not empty busquedaProducto.busqueda}">
                        <input type="hidden" id="busqueda" value="${busquedaProducto.busqueda}" />
                    </c:when>
                </c:choose>
                <div class="rsidebar span_1_of_left">

                    <section  class="sky-form">
                        <h4>Precio</h4>
                        <div class="row row1 scroll-pane">

                            <div class="col col-4">
                                <c:forEach items="${busquedaProducto.criterioPrecio}" var="precio">
                                    <label class="checkbox">
                                        <input type="checkbox" name="precio" value="${precio.key}" onchange="buscar('');">
                                        <i></i>${precio.value}</label>
                                </c:forEach>
                            </div>
                        </div>
                    </section>
                    <section  class="sky-form">
                        <h4>Marca</h4>
                        <div class="row row1 scroll-pane">
                            <div class="col col-4">
                                <c:forEach items="${busquedaProducto.criterioMarca}" var="marca">
                                    <label class="checkbox"><input type="checkbox" name="marca" value="${marca}" onchange="buscar('');"><i></i>${marca}</label>
                                </c:forEach>
                            </div>
                        </div>
                    </section>
                    <section  class="sky-form">
                        <h4>Modelo</h4>
                        <div class="row row1 scroll-pane">
                            <div class="col col-4">
                                <c:forEach items="${busquedaProducto.criterioModelo}" var="modelo">
                                    <label class="checkbox"><input type="checkbox" name="modelo" value="${modelo}" onchange="buscar('')"><i></i>${modelo}</label>
                                </c:forEach>
                            </div>
                        </div>
                    </section>
                </div>
            </form>
            <div class="clear"></div>
        </div>
    </div>
</div>
    
    
    <!-- Pie de página -->
    <%@include file="/WEB-INF/jspf/footer.jspf" %>
	
</body>
</html>
