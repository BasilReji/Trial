<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Hope</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/hybrid-crypto.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/sha256.js"></script>



    <style type="text/css">
        body {
            background: -webkit-linear-gradient(left, #3931af, #00c6ff);
        }

        .register {
            margin-top: 3%;
            padding: 3%;
        }

        .register-left {
            text-align: center;
            color: #fff;
            margin-top: 4%;
        }

        .register-left input {
            border: none;
            border-radius: 1.5rem;
            padding: 2px;
            width: 100%;
            text-align: center;
            height: 50px;
            background: #f8f9fa;
            margin-top: 30%;
            margin-bottom: 3%;
            cursor: pointer;

        }

        .register-right {
            background: #f8f9fa;
            border-top-left-radius: 10% 50%;
            border-bottom-left-radius: 10% 50%;
        }

        .register-left img {
            margin-top: 15%;
            margin-bottom: 5%;
            width: 25%;
            -webkit-animation: mover 2s infinite alternate;
            animation: mover 1s infinite alternate;
        }

        @-webkit-keyframes mover {
            0% {
                transform: translateY(0);
            }

            100% {
                transform: translateY(-20px);
            }
        }

        @keyframes mover {
            0% {
                transform: translateY(0);
            }

            100% {
                transform: translateY(-20px);
            }
        }

        .register-left p {
            font-weight: lighter;
            padding: 12%;
            margin-top: -9%;
        }

        .register .register-form {
            padding: 10%;
            margin-top: 10%;
        }

        .btnRegister {
            float: right;
            margin-top: 10%;
            border: none;
            border-radius: 1.5rem;
            padding: 2%;
            background: green;
            color: #fff;
            font-weight: 600;
            width: 50%;
            cursor: pointer;
        }

        .register .nav-tabs {
            margin-top: 3%;
            border: none;
            background: green;
            border-radius: 1.5rem;
            width: 28%;
            float: right;
        }

        .register .nav-tabs .nav-link {
            padding: 2%;
            height: 34px;
            font-weight: 600;
            color: #fff;
            border-top-right-radius: 1.5rem;
            border-bottom-right-radius: 1.5rem;
        }

        .register .nav-tabs .nav-link:hover {
            border: none;
        }

        .register .nav-tabs .nav-link.active {
            width: 100px;
            color: #0062cc;
            border: 2px solid #0062cc;
            border-top-left-radius: 1.5rem;
            border-bottom-left-radius: 1.5rem;
        }

        .register-heading {
            text-align: center;
            margin-top: 8%;
            margin-bottom: -15%;
            color: #495057;
        }

        .login-form-1 {
            padding: 5%;
            background: white;
            box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);
            border-radius: 25px;
            text-align: center;
        }

        .login-form-1 h3 {
            text-align: center;
            color: #333;
        }

        .login-form-1 .btnSubmit {
            font-weight: 600;
            color: #fff;
            background-color: green;
            -webkit-animation: mover 2s infinite alternate;
            animation: mover 1s infinite alternate;
        }

        .login-form-1 .ForgetPwd {
            color: green;
            font-weight: 600;
            text-decoration: none;
        }

        .col-md-6 {
            -ms-flex: 0 0 50%;
            flex: 0 0 50%;
            max-width: 100%;
        }
    </style>
    <script> 
		
			// Function to check Whether both passwords 
			// is same or not. 
			function checkPassword(form) { 
				password1 = form.password1.value; 
				password2 = form.password2.value; 

				// If password not entered 
				if (password == '') 
					alert ("Please enter Password"); 
					
				// If confirm password not entered 
				else if (password2 == '') 
					alert ("Please enter confirm password"); 
					
				// If Not same return False.	 
				else if (password1 != password2) { 
					alert ("\nPassword did not match: Please try again...") 
					return false; 
				} 

				// If same return True. 
				
			} 
		</script> 
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>

<body>
<a href="index" style="color: yellowgreen;">Go Back</a>
    <div class="container register">
        
        <div class="row">
            <div class="col-md-3 register-left">
                <div class="col-md-6 login-form-1">
                    <h3>Login Here</h3>
                    <form:form method="post" action="login">
                        <div class="form-group" align="center">
                            <input type="text" id="userIdl" class="form-control" placeholder="UserID *" name="user"
                                required />
                        </div>
                        <div class="form-group" align="center">
                            <input type="password" id="passwordl" class="form-control" placeholder="Password *" name="password"
                                required />
                        </div>
                        <div class="form-group">
                            <input type="submit"  class="btnSubmit" value="Login" />
                        </div>
                        <!-- <div class="form-group">
                            <a href="#" class="ForgetPwd">Forget Password?</a>
                        </div> -->
                    </form:form>
                </div>
            </div>
            <div class="col-md-9 register-right">
                <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab"
                            aria-controls="home" aria-selected="true">Orphanage</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab"
                            aria-controls="profile" aria-selected="false">Donator</a>
                    </li>

                </ul>
                <div class="tab-content" id="myTabContent">
                 
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <h3 class="register-heading">Apply as an Orphanage</h3>
                        <form:form method="post" action="save1" class="row register-form">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="UserID *" value=""
                                        name="user" id="userID" required />
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Full Name *" value=""
                                        name="name" id="fullName" required />
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="Password *" value=""
                                        name="password" id="password" required />
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Registration Number *" value=""
                                        name="regno" id="regid" required />
                                </div>
                                <!-- <div class="form-group">
                                            <div class="maxl">
                                                <label class="radio inline"> 
                                                    <input type="radio" name="gender" value="male" checked>
                                                    <span> Male </span> 
                                                </label>
                                                <label class="radio inline"> 
                                                    <input type="radio" name="gender" value="female">
                                                    <span>Female </span> 
                                                </label>
                                            </div>
                                        </div> -->
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="email" class="form-control" name="email" id="email"
                                        placeholder="Your Email *" value="" required />
                                </div>
                                <div class="form-group">
                                    <input type="text" name="place" id="place" class="form-control" placeholder="Place *"
                                        value="" required />
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="Confirm Password *"
                                   name="password2"     value="" id="c_pass" required />
                                </div>


                                <div class="form-group">
                                    <input type="text" name="phone" id="phone" class="form-control"
                                        placeholder="Your Phone *" value="" required />
                                </div>
                                <input type="submit"  class="btnRegister" value="Register" />
                            </div>
                        </form:form>
                       
                    </div>
                    <div class="tab-pane fade show" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                        <h3 class="register-heading">Apply as a Donator</h3>
                        <form:form method="post" action="save" class="row register-form" >
                    
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="userID *" value=""
                                        id="user" name="user" required />
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Full Name *" value=""
                                        id="name" name="name" required />
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control" placeholder="Email *" value="" id="email"
                                        name="email" />
                                </div>
                                <div class="form-group">
                                    <input type="text" maxlength="10" minlength="10" class="form-control"
                                        placeholder="Phone *" value="" id="phone" name="phone"/>
                                </div>


                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="Password *" value=""
                                        name="password" id="password" required />
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="Confirm Password *"
                                   name="password2"     value="" id="c_pass_d" />
                                </div>
                                <div class="form-group">
                                    <input type="text" maxlength="10" minlength="10" class="form-control"
                                        placeholder="Aadhar Number *" value="" name="aadhar"
                                        id="Aadhar" required />
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Gender *" value=""
                                        name="gender" id="Gender" required />
                                </div>

                                <div class="form-group">
                                            <div class="maxl">
                                                <label class="radio inline"> Willing to Volunteer : &nbsp;
                                                    <input type="radio" name="willing" value="yes" checked>
                                                    <span> Yes </span> 
                                                </label>
                                                <label class="radio inline"> 
                                                    <input type="radio" name="willing" value="no">
                                                    <span>No </span> 
                                                </label>
                                            </div>
                                        </div>
                                <input type="submit" class="btnRegister" value="Register" />
                            </div>
                           
                        </form:form>
                    </div>
                </div>
                
            </div>
        </div>
		
    </div>
    <script
        src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@2.1.6/dist/loadingoverlay.min.js"></script>

    <script type="text/javascript" src="js/notify.js"></script>

    <script type="text/javascript">
    
    
    
    </script>
    
</body>

</html>