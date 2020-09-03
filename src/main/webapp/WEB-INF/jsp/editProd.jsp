<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page isELIgnored="false" %>	
 <%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Orphanage</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>
   <script type="text/javascript" src='<c:url value="/assets/js/hybrid-crypto.min.js"/>'></script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href='<c:url value="/assets/css/patient-app.css"/>'>
    <link rel="stylesheet" href='<c:url value="/assets/css/patient-style.css"/>'>
    <script
        src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@2.1.6/dist/loadingoverlay.min.js"></script>
    <style>
        .newmodal {
            width: 100%;
            height: 100%;
            margin: 0;
            padding: 0;
        }

        .newcontent {
            height: auto;
            min-height: 100%;
            border-radius: 0;
            margin: 25px;
        }

        .radio-button {
            position: relative;
            margin: 20px 0;
        }

        .radio-button input {
            position: absolute;
            margin: 5px;
            padding: 0;
            /* for mobile accessibility (iOS Label Bug) */
            visibility: hidden;
        }

        .radio-button .label-visible {
            margin-left: 2em;
            margin-bottom: 0;
        }

        .fake-radiobutton {
            position: absolute;
            display: block;
            top: 0;
            left: 3px;
            width: 20px;
            height: 20px;
            border: 1px solid slategray;
            background-color: white;
        }

        .fake-radiobutton:after {
            content: "";
            display: none;
            position: absolute;
            top: 50%;
            left: 50%;
            width: 16px;
            height: 16px;
            background: navy;
            transform: translateX(-50%) translateY(-50%);
        }

        .fake-radiobutton {
            border-radius: 50%;
        }

        .fake-radiobutton:after {
            border-radius: 50%;
        }

        input[type="radio"]:checked+span .fake-radiobutton:after {
            display: block;
        }
    </style>
</head>


<body>
    <aside class="left-panel" tabindex="5003" style="overflow: hidden; outline: none;">
        <div class="user text-center">
            <img src="assets/images/user.png" class="img-circle" alt="...">
            <h4  id ="pname" class="user-name"></h4>
        </div>
        <nav class="navigation">
            <ul class="list-unstyled">
                <li class="has-submenu"><a href="Orphanages"><i class="fa fa-heart-o"></i> <span
                            class="nav-label">My Profile</span></a>
                </li> 
                <li class="active"><a href="Requested"><i class="fa fa-bookmark-o"></i><span class="nav-label">
                            Requested 
                            Items</span></a>
                            
                </li>
                <li class="has-submenu"><a href="Request"><i class="fa fa-heart-o"></i> <span class="nav-label">Request Items</span></a>
                </li>
                <li class="has-submenu"><a href="Donatedo"><i class="fa fa-bookmark-o"></i><span class="nav-label">
                            Donated 
                            Items</span></a>
                </li>
               
                <li class="has-submenu"><a href="index.html"><i class="fa fa-file-text-o"></i> <span
                            class="nav-label">Logout</span></a>
                </li>
            </ul>
        </nav>
    </aside>
    <!-- Aside Ends-->
    <section class="content">
        
          <div class="box">
            <h2 style="text-align: center;">Requested Items</h2>
            <div class="container">
                <div class="row">
                    <br><br><br>
                <div id="app">
                 <div  class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                 
                 
   				

                 
                  <div class="table-responsive">
                               <form:form class="row register-form" action="editPro" method="post">
                               
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Product Name *" value="${req.getPname()}"
                                        name="pname" id="userID" required />
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Quantity *" value="${req.getQuant()}"
                                        name="quant" id="fullName" required />
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Category *" value="${req.getCateg()}"
                                        name="categ" id="password" required />
                                </div>
                                <div class="form-group">
                                	
                                    <textarea rows="5" cols="35" placeholder="Description *" name="desc"  >${req.getDesc()}</textarea>
                                </div>
                                <input type="hidden" name="pid" value="${req.getPid()}">
                                <input type="submit" class="btnRegister" value="Edit" />
                        </form:form>
                            </div>
                 </div>
                
                
			
					
					
                </div>
            </div>
        </div>
       
       
        
        
    </section>
   
</body>

</html>