<%-- 
    Document   : pago
    Created on : Jul 26, 2014, 4:09:00 PM
    Author     : juancarlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Tienda Virtual DAT | Carrito</title>
<%@include file="WEB-INF/jspf/_headercalls.jspf" %>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>

    <script type="text/javascript" src="js/operacionescarrito.js"></script>

<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!-- dropdown -->
<script src="js/jquery.easydropdown.js"></script>
</head>
<body>
    <!-- Menú de la parte superior -->
    <%@include file="WEB-INF/jspf/headmenu.jspf" %>
    
    <!-- Logo, busqueda y menu de categorías -->
    <%@include file="WEB-INF/jspf/headbottom.jspf" %>
    
    
    
    <div class="login" style="overflow: auto;">
        <div class="wrap">
            <h4 class="title">Carrito de compras</h4>
             
            <c:if test="${empty listacarrito}">
                             
               <div class="empty-cart">
                    <p>Tu carrito de compras está vacío</p>
                    <p>
                        Click <a href="">aquí</a> para retornar al catálogo.
                    </p>
                    <br/><br/>
                </div>
            </c:if>
            
            <c:if test="${not empty listacarrito}">
                
            <div class="column-labels">
                <label class="product-image">Imagen</label>
                <label class="product-details">Producto</label>
                <label class="product-price">Precio</label>
                <label class="product-quantity">Cantidad</label>
                <label class="product-removal">Remover</label>
                <label class="product-line-price">Subtotal</label>
            </div>

            
                
             <c:set var="i" value="0"/>
             <c:set var="valor" value="0"/>
             <c:forEach items="${listacarrito}" var="lis">
                  
            
                 <c:set var="i" value="${i+1}"/>  
                 <c:set var="total"  value="${valor+lis.precio}"/>
                 <c:set var="valor"  value="${total}" /> 
                 
                
                <div class="product" id="${lis.idProducto}">
                    
                    <div class="product-image">
                        <img src="${lis.imagen}" />
                    </div>
                    <div class="product-details">
                        <p class="product-title">${lis.nombre}</p>
                        <p class="product-description">${lis.descripcion}</p>
                    </div>
                    <div class="product-price">S/.${lis.precio/lis.cantidad}</div>
                    <div class="product-quantity">
                        <input style="width: 40px;" type="number" name="cantidad_${i}" id="cantidad_${i}"  value="${lis.cantidad}" min="1" max="${lis.stock}" maxlength="3" onchange="javascript:change('${lis.idProducto}','${i}')"/>                 
                    </div>
                     <div class="product-removal">
                        <button class="remove-product" onclick="javascript:eliminar('${lis.idProducto}')">
                            Eliminar
                        </button>
                    </div>
                    <div class="product-line-price">S/.${lis.precio}</div>
                
                </div>
               </c:forEach>  
              <c:remove var="i" />
                <c:set var="totalfinal" scope="session" value="${valor}" /> 
            
  
            <div class="totals" style="overflow: auto;">
                <div class="totals-item totals-item-total">
                    <label>Total</label>
                    <div class="totals-value" id="cart-total">S/.${total}</div>
                </div>
            </div>
            </c:if> 
            <button class="cssbutton greyright" onclick="window.location.href='cliente/pagar.jsp';">Comprar</button>
            <button class="cssbutton greenright" onclick="window.location.href='index.jsp';">Seguir Comprando</button>
            
            <c:remove var="lacantidad" scope="session"  />
        </div>
    
    </div>
  
        <!-- Pie de página -->
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        
</body>
</html>