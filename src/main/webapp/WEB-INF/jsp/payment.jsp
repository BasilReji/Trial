<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Donate Now</title>
  <link rel="stylesheet" href='<c:url value="/assets/style.css"/>'>

</head>
<body>
<!-- partial:index.partial.html -->
<div id="card-success" class="hidden">
  <i class="fa fa-check"></i>
  <p>Payment Successful!</p>
</div>
<div id="form-errors" class="hidden">
  <i class="fa fa-exclamation-triangle"></i>
  <p id="card-error">Card error</p>
</div>
<a href="index" style="color: yellowgreen;">Go Back</a>
<div id="form-container">

  <div id="card-front">
    <div id="shadow"></div>
    <div id="image-container">
      <span id="amount">Donating: <strong><input type="text" id="donate"  placeholder="Donating Amount *" value=""
        required /></strong></span>
      <span id="card-image">
      
        </span>
    </div>
    <!--- end card image container --->

    <label for="card-number">
        Card Number
      </label>
    <input type="text" id="card-number" placeholder="1234 5678 9101 1112" length="16">
    <div id="cardholder-container">
      <label for="card-holder">Card Holder
      </label>
      <input type="text" id="card-holder" placeholder="e.g. John Doe" />
    </div>
    <!--- end card holder container --->
    <div id="exp-container">
      <label for="card-exp">
          Expiration
        </label>
      <input id="card-month" type="text" placeholder="MM" length="2">
      <input id="card-year" type="text" placeholder="YY" length="2">
    </div>
        <div id="cvc-container">
      <label for="card-cvc"> CVC/CVV</label>
      <input id="card-cvc" placeholder="XXX-X" type="text" min-length="3" max-length="4">
      <p>Last 3 or 4 digits</p>
    </div>
    <!--- end CVC container --->
    <!--- end exp container --->
  </div>
  <!--- end card front --->
  <div id="card-back">
    <div id="card-stripe">
    </div>

  </div>
  <!--- end card back --->
  <input type="text" id="card-token" />
  <button type="button" id="card-btn">Submit</button>

</div>



<!--- end form container --->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="https://js.stripe.com/v2/"></script>
<script src="https://use.fontawesome.com/f1e0bf0cbc.js"></script>
<!-- partial -->
  <script  src="./script.js"></script>

</body>
</html>
    