<%-- 
    Document   : pago
    Created on : Jul 26, 2014, 4:09:00 PM
    Author     : juancarlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Tienda Virtual DAT | Carrito</title>
<%@include file="WEB-INF/jspf/_headercalls.jspf" %>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
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
             
            <div class="column-labels">
                <label class="product-image">Imagen</label>
                <label class="product-details">Productos</label>
                <label class="product-price">Precio</label>
                <label class="product-quantity">Cantidad</label>
                <label class="product-removal">Remover</label>
                <label class="product-line-price">Subtotal</label>
            </div>

            <div class="product">
                <div class="product-image">
                    <img src="http://s.cdpn.io/3/dingo-dog-bones.jpg">
                </div>
                <div class="product-details">
                    <div class="product-title">Lorem Ipsum</div>
                    <p class="product-description">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                </div>
                <div class="product-price">S/.12.99</div>
                <div class="product-quantity">
                    <input type="number" value="2" min="1">
                </div>
                <div class="product-removal">
                    <button class="remove-product">
                        Eliminar
                    </button>
                </div>
                <div class="product-line-price">S./25.98</div>
            </div>

            <div class="product">
                <div class="product-image">
                    <img src="http://s.cdpn.io/3/large-NutroNaturalChoiceAdultLambMealandRiceDryDogFood.png">
                </div>
                <div class="product-details">
                    <div class="product-title">Lorem Ipsum</div>
                    <p class="product-description">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                </div>
                <div class="product-price">S/.45.99</div>
                <div class="product-quantity">
                    <input type="number" value="1" min="1">
                </div>
                <div class="product-removal">
                    <button class="remove-product">
                        Eliminar
                    </button>
                </div>
                <div class="product-line-price">S/.45.99</div>
            </div>

            <div class="totals" style="overflow: auto;">
                <div class="totals-item totals-item-total">
                    <label>Total</label>
                    <div class="totals-value" id="cart-total">S/.90.57</div>
                </div>
            </div>

            <button class="cssbutton greyright">Pagar</button>
            <button class="cssbutton greenright">Actualizar</button>
            
        </div>
    </div>
    
        <!-- Pie de página -->
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        
</body>
</html>

