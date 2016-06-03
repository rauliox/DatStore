<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Tienda Virtual DAT | Producto</title>
<%@include file="/WEB-INF/jspf/_headercalls.jspf" %>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script type="text/javascript" src="js/operacionescarrito.js"></script> 
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/jquery.easydropdown.js"></script>
</head>
<body> 
    <!-- Menú de la parte superior -->
    <%@include file="/WEB-INF/jspf/headmenu.jspf" %>
    
    <!-- Logo, busqueda y menu de categorías -->
    <%@include file="/WEB-INF/jspf/headbottom.jspf" %>
    
   <jsp:include page="Carrito?accion=singleprod&idProducto=${param.idProducto}" />
   
<div class="mens">    
    <div class="main">
        <div class="wrap">
            <c:forEach items="${categorias}" var="cat" >
                <c:forEach items="${cat.subcategorias}" var="subcat">
                    <c:if test="${subcat.idSubcategoria==producto.idSubcategoria}">
                        <ul class="breadcrumb breadcrumb__t"><a class="home" href="index.jsp">Inicio</a> / 
                            <a href="index.jsp?idCategoria=${cat.idCategoria}">${cat.descripcion}</a> / 
                            <a href="index.jsp?idSubcategoria=${subcat.idSubcategoria}">${subcat.descripcion}</a> / 
                            ${producto.nombre}</ul>
                    </c:if>
                </c:forEach>
            </c:forEach>
            <div class="cont span_2_of_3">
                <div class="grid images_3_of_2">
                    <div id="container">
                        <img src="${producto.imagen}" />
                    </div>
                </div>
                    
                
                
                <div class="desc1 span_3_of_2">
                    <h3 class="m_3">${producto.nombre}</h3>
                    <p class="m_5">S/.${producto.precio}</p>
                    <p class="m_1">Marca: ${producto.marca}  </p>

                    <p class="m_3">Modelo: ${producto.modelo} </p>
                    <c:set var="lacantidad" scope="session" value="${producto.stock}" />
                    <c:if test="${not empty listacarrito}">  
                        <c:forEach items="${listacarrito}" var="lis">
                            <c:if test="${lis.idProducto == producto.idProducto}">
                                <c:set var="lacantidad" scope="session" value="${producto.stock - lis.cantidad}" />
                            </c:if>                              
                        </c:forEach>   
                    </c:if>
            
                    <c:if test="${lacantidad != 0}">
                        <p>Stock: ${lacantidad}</p>
                        <p>Cantidad: <input style="width: 40px;" type="number" name="cant" id="cant"  value="1" min="1" max="${lacantidad}" maxlength="3" /></p>
                        <div class="btn_form">
                            <form>
                             <a href="javascript:void()" onclick="javascript:agregar('${producto.idProducto}');">COMPRAR</a>
                            </form>
                        </div>
                        <p class="m_text2">${producto.descripcion}</p>
                    </c:if>
                   
                        
                    <c:if test="${lacantidad == 0}">
                        
                        <p style="color: red;font-size: 18px;">LO SENTIMOS!!PRODUCTO AGOTADO!</p>
                        <a href="carrito.jsp">FINALIZA TU COMPRA!</a>
                        
                    </c:if>
                </div>
               
                
                <div class="clear"></div>	
                <div class="toogle">
                    
                    <h3 class="m_3">Comentarios</h3>
                    <c:forEach items="${comentarios}" var="comentario" >
                        <c:set var="valoracion" value="${5-comentario.valoracion}"/>
                        <div class="comment" style="border-top: 1px solid #E6E6E6;">
                            <h2>${comentario.nombre} (${comentario.fecha})</h2>
                            <div class="rating1">
                                <c:forEach begin="1" end="5" var="i">
                                    <c:choose>
                                        <c:when test="${i<=valoracion}">
                                            <span>☆</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span style="color:#FFD700;">★</span>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </div>
                            <p class="m_text">${comentario.texto}</p>
                        </div>
                    </c:forEach>             
                </div>
                
                <div class="toogle">
                    <h3 class="m_3">Mas Información</h3>
                    <p class="m_text">
                            ${producto.idProducto}||
        ${producto.idVendedor} ||
      ${producto.idSubcategoria} ||
        ${producto.nombre}||
      
        ${producto.precio}||
         ${producto.imagen}||
         ${producto.stock}||
         ${producto.vendidas}||
         ${producto.marca}||
         ${producto.modelo}||
          ${producto.estado}||
                    </p>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
    
  
        <!-- Pie de página -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>