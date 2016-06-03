<%-- 
    Document   : newjsp
    Created on : 17/08/2014, 08:28:17 PM
    Author     : hogar1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
      
        <link href="../css/pagar.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="../js/operacionescarrito.js"></script>
    </head>
    <body>
       
        
      
<div id="step-2" class="step">
   <h2 class="step-title">  Método de pago   </h2>
      <div class="step-content">
       <ul class="payment-options">
           
           
           <li id="cash-on-delivery-payment-method" class="payment-method">
                <input id="cashondelivery_payment" class="payment-method-field"  type="radio" />   

                <div class="payment-method-label">
                    <h3 class="payment-method-title"> Pago contra entrega en efectivo        </h3>
                </div>
                
            </li>

        <li id="credit-card-on-delivery-payment-method" class="payment-method">
            <input id="creditcardondelivery_payment" class="payment-method-field"  type="radio" />  
            <div class="payment-method-label">
              <h3 class="payment-method-title"> Pago contra entrega con tarjeta      </h3>
            </div>
    
         
        </li>


         <li id="adyen-api-payment-method" class="payment-method">
              <input id="adyen_hostedpaymentpage_payment" class="payment-method-field" value="Adyen_ApiPayment" type="radio"  />
                <div class="payment-method-label">
                <h3 class="payment-method-title"> Tarjetas de Crédito        </h3>
               </div>
              <div class="payment-method-description">
          
         </li>


         <li id="pagoefectivo-payment-method" class="payment-method">
             <input class="payment-method-field" id="pagoefectivo_payment" value="PagoEfectivo_Payment" type="radio"  />
             <div class="payment-method-label">
               <h3 class="payment-method-title">PagoEfectivo (Prepago) </h3>
             </div>

          
         </li>

         <li id="paypal-express-checkout-payment-method" class="payment-method">
             <input id="paypal-express-checkout-installments" class="payment-method-field" value="Paypal_Express_Checkout" type="radio"  />  
              <div class="payment-method-label">
             <h3 class="payment-method-title"> PayPal & Tarjeta de Credito Internacional   </h3>
            </div>
                
        </li>
        
        
         <li id="safety-pay-payment-method" class="payment-method">
                <input id="safetypay_payment" class="payment-method-field"type="radio"  />   
                <div class="payment-method-label">
               <h3 class="payment-method-title">  SafetyPay (Efectivo o Pago Virtual)  </h3>
                 </div>
                
          </li>
         
          <li id="agencia-bcp-payment-method" class="payment-method">
                <input id="agencia_bcp" class="payment-method-field" value="AgenciaBCP_Payment" type="radio"  />  
                <div class="payment-method-label">
                <h3 class="payment-method-title"> Agencia BCP        </h3>
                 </div>
                
           </li>
        
        
             <li id="agencia-bbva-payment-method" class="payment-method">
                <input id="agencia_bbva" class="payment-method-field" value="AgenciaBBVA_Payment" type="radio" />
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
                <th scope="col" colspan="2">
                    Resumen del Pedido                </th>
            </tr>
            </thead>
            <tbody>
            <tr id="checkout-cart-subtotal">
                <th scope="row">Subtotal</th>
                <td>S/. 2,372.90</td>
            </tr>
                    
                                                                                <tr id="checkout-cart-shipping-enter-address">
                    <th scope="row">Envío</th>
                    <td>Por favor introduce tu dirección de entrega</td>
                </tr>
                                <tr id="checkout-cart-total">
                <th scope="row">Total</th>
                <td class="total">
                    <input id="shp-cart-total-int" name="shp-cart-total-int" type="hidden" value="2372.9" />
                    <input id="shp-cart-total-calc" name="shp-cart-total-calc" type="hidden" value="2372.9" />
                    S/. 2,372.90                </td>
            </tr>
            </tbody>
        </table>
    </div>
</fieldset>



<fieldset id="checkout-btn" class="">
    <div class="form-field ff-type-button">
        <button id="checkoutBtn" title="Finalizar Compra" type="submit" class="disabled">Finalizar Compra</button>
    </div>

  
    <div id="checkout-agreement" class="form-field ff-type-checkbox">
        Al hacer click en "Finalizar compra" acepto las condiciones de entrega y terminos de uso <a href="" onClick="window.open('http://www.linio.com.pe/terminosdeuso','mywindow','width=600,height=400,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,copyhistory=no,resizable=yes'); return false;">Condiciones de entrega</a>, 
     </div>
</fieldset>  
        
 </div>
 </div>
        
        
        
        
        
        
        
    </body>
</html>
