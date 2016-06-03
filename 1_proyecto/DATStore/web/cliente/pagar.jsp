<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Tienda Virtual DAT | Pagar</title>
<%@include file="/WEB-INF/jspf/_headercalls.jspf" %>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script type="text/javascript" src="js/operacionescarrito.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!-- dropdown -->
<script src="js/jquery.easydropdown.js"></script>

<link href="css/pagar.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="../js/operacionescarrito.js"></script>
</head>
<body>
    <!-- Menú de la parte superior -->
    <%@include file="/WEB-INF/jspf/headmenu.jspf" %>
    
    <!-- Logo, busqueda y menu de categorías -->
    <%@include file="/WEB-INF/jspf/headbottom.jspf" %>
    
        <div class="wrap" style="overflow: auto;">
            <h4 class="title">Pagar Orden</h4>
            <c:if test="${ empty listacarrito}">
                
             
            <h4 class="title">USTED NO TIENE PEDIDOS PENDIENTES!</h4>
            <br/> <br/> <br/> <br/>
            </c:if>
        
            
                <c:if test="${not empty listacarrito}">   
       
      
         
         
         
         
<div id="step-2" class="step">
   <h2 class="step-title">  Método de pago   </h2>
      <div class="step-content">
       <ul class="payment-options">
           
           
           <li id="cash-on-delivery-payment-method" class="payment-method">
                <input id="cashondelivery_payment" class="payment-method-field" name="a"  type="radio" />   

                <div class="payment-method-label">
                    <h3 class="payment-method-title"> Pago contra entrega en efectivo</h3>
                </div>
                
            </li>

        <li id="credit-card-on-delivery-payment-method" class="payment-method">
            <input id="creditcardondelivery_payment" class="payment-method-field" name="a"  type="radio" />  
            <div class="payment-method-label">
              <h3 class="payment-method-title"> Pago contra entrega con tarjeta</h3>
            </div>
    
         
        </li>


         <li id="adyen-api-payment-method" class="payment-method">
              <input id="adyen_hostedpaymentpage_payment" class="payment-method-field" name="a" value="Adyen_ApiPayment" type="radio"  />
                <div class="payment-method-label">
                <h3 class="payment-method-title"> Tarjetas de Crédito</h3>
               </div>
              <div class="payment-method-description">
          
         </li>


         <li id="pagoefectivo-payment-method" class="payment-method">
             <input class="payment-method-field" id="pagoefectivo_payment" name="a" value="PagoEfectivo_Payment" type="radio"  />
             <div class="payment-method-label">
               <h3 class="payment-method-title">PagoEfectivo (Prepago) </h3>
             </div>

          
         </li>

         <li id="paypal-express-checkout-payment-method" class="payment-method">
             <input id="paypal-express-checkout-installments" class="payment-method-field" name="a" value="Paypal_Express_Checkout" type="radio"  />  
              <div class="payment-method-label">
             <h3 class="payment-method-title"> PayPal & Tarjeta de Credito Internacional   </h3>
            </div>
                
        </li>
        
        
         <li id="safety-pay-payment-method" class="payment-method">
                <input id="safetypay_payment" class="payment-method-field" type="radio" name="a"  />   
                <div class="payment-method-label">
               <h3 class="payment-method-title">  SafetyPay (Efectivo o Pago Virtual)  </h3>
                 </div>
                
          </li>
         
          <li id="agencia-bcp-payment-method" class="payment-method">
                <input id="agencia_bcp" class="payment-method-field" value="AgenciaBCP_Payment" type="radio"  name="a"  />  
                <div class="payment-method-label">
                <h3 class="payment-method-title"> Agencia BCP        </h3>
                 </div>
                
           </li>
        
        
             <li id="agencia-bbva-payment-method" class="payment-method">
                <input id="agencia_bbva" class="payment-method-field" value="AgenciaBBVA_Payment" type="radio"  name="a" />
                <div class="payment-method-label">
                    <h3 class="payment-method-title">Agencia BBVA  </h3>
                </div>
                
           </li>

        </ul>
   
      </div>
   </div>
        
 <div class="step" id="step-3">
            <h2 class="step-title">  Confirmación de pedido            </h2>
            <div class="step-content">
                
<fieldset>
    <div id="checkout-grand-total">
        <table>
            <thead>
            <tr>
                <th scope="col" colspan="3">  ${totalart} Artículo(s)</th>
                
            </tr>
            </thead>
            <tbody>
           
                    
               <c:set var="i" value="0"/>
             <c:set var="valor" value="0"/>
             <tr id="checkout-cart-shipping-enter-address">
              <th scope="row"></th>
              <td>
                  
              </td>
                      
                </tr>
                
               <tr id="checkout-cart-subtotal">
                
                <th scope="row"></th>
                <td></td>
                </tr> 
                   
                
              <tr id="checkout-cart-subtotal">
                <th scope="col" colspan=""> Producto </th>
                <th scope="col" colspan=""> Cantidad </th>
                <th scope="col" colspan=""> Precio</th>
             </tr>
                 
             <c:forEach items="${listacarrito}" var="lis">
              
             <tr >
                <td style="padding-left: 40px;"> <div style="width:100px;height: 20px; overflow: hidden;"> ${lis.nombre} </div> </td>
                <td style="padding-left: 10px;"> <div style="width:50px;height: 20px; overflow: hidden;text-align: center;">${lis.cantidad}  </div></td>
                <td style="padding-left: 20px;"> ${lis.precio} </td>
                 
                </tr>   
             
                    
            
          
               </c:forEach>  
              <c:remove var="i" />
                
               
               <tr id="checkout-cart-total">
                
                <th scope="row">Total</th>
                <td class="total"> </td>
                <td class="total" style="padding-left: 20px;"> ${totalfinal}  </td>
            </tr>
            </tbody>
        </table>
    </div>
</fieldset>



<fieldset id="checkout-btn" class="">
    <div class="form-field ff-type-button">
        <button id="checkoutBtn" title="Finalizar Compra" type="submit" class="disabled"  onclick="location.href = 'Carrito?accion=procesarcompra'">Finalizar Compra</button>
   
    </div>

         
  
    <div id="checkout-agreement" class="form-field ff-type-checkbox">
        <br/>
        Al hacer click en "Finalizar compra" acepto las condiciones de entrega y terminos de uso <a href="javascript:void" onClick="window.open('cliente/Condiciones.jsp','mywindow','width=600,height=400,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,copyhistory=no,resizable=yes'); return false;">Condiciones de entrega</a>, 
     </div>
</fieldset>  
        
 </div>
 </div>
            
    </div>
            
          </c:if>
        
        <!-- Pie de página -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>


