<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Covalisage</title>
        <meta name="description" content="company is a free job board template">
        <meta name="author" content="Ohidul">
        <meta name="keyword" content="html, css, bootstrap, job-board">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800' rel='stylesheet' type='text/css'>

        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link rel="icon" href="favicon.ico" type="image/x-icon">

        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/fontello.css">
        <link rel="stylesheet" href="css/animate.css">        
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="css/owl.theme.css">
        <link rel="stylesheet" href="css/owl.transitions.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="responsive.css">
        <script src="js/vendor/modernizr-2.6.2.min.js"></script>
    </head>
    <body>

        <div id="preloader">
            <div id="status">&nbsp;</div>
        </div>
        <!-- Body content --> 
         
        <nav class="navbar navbar-default">
          <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
             
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <div class="button navbar-right">
                <!--  <button class="navbar-btn nav-button wow bounceInRight login" data-wow-delay="0.8s">Login</button>
                  <button class="navbar-btn nav-button wow fadeInRight" data-wow-delay="0.6s">Sign up</button>-->
              </div>
              <ul class="main-nav nav navbar-nav navbar-right">
   <li class="wow fadeInDown" data-wow-delay="0s"><a class="active" href="index.jsp">ACCUEIL</a></li>
                <li class="wow fadeInDown" data-wow-delay="0.1s"><a href="ServletSite?gerer=Rech">ENVOYER UN COLIS</a></li>  
                <li class="wow fadeInDown" data-wow-delay="0.4s"><a href="connexion.jsp">CONNEXION</a></li>
                <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="contact.jsp">CONTACT</a></li>
              </ul>
            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>

        <div class="slider-area">
            <div class="slider">
                <div id="bg-slider" class="owl-carousel owl-theme">
                 
                <div class="item"><img src="img/slide3.jpg" alt="Mirror Edge"></div>
                  <div class="item"><img src="img/slide2.jpg" alt="The Last of us"></div>
                  <div class="item"><img src="img/slide1.jpg" alt="GTA V"></div>
                 
                </div>
            </div>
            <div class="container slider-content">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 col-sm-12">
                        <h2>Rechercher Un  Covalisage</h2>
                        
					</div>
                </div>
            </div>
        </div>

       
            <hr>

            <div class="container">
                <div class="row page-title text-center  wow bounce"  data-wow-delay=".7s">
                    <h2>CONTACT</h2>
                    <h3>N'hesiter pas de nous contacter</h2>
                </div>
                <div class="row testimonial">
                    <div class="col-md-6 col-md-offset-3">
                        <div id="testimonial-slider">
                              <form role="form" action="ServletSite" method="post">
                                      <div class="form-group">
                                          <label for="exampleInputEmail1">Sujet</label>
                                           <select name="sujet" class="form-control input-lg m-b-10">
                                                  <option value="reclamation">Réclamation</option>
                                                  <option value="Suggestion">Suggestion</option>
                                                  <option value="Information">Information</option>
                                              </select>
                                      </div>
									   <div class="form-group">
                                          <label for="exampleInputEmail1">Nom et Prénom</label>
                                          <input type="text" class="form-control" name="nom_prenom" id="exampleInputEmail1" placeholder="Enter Nom et Prénom" required>
                                      </div>
                                      <div class="form-group">
                                          <label for="exampleInputPassword1">E-mail</label>
                                          <input type="email" class="form-control" name="mail" id="exampleInputPassword1" placeholder="Entrer E-mail" required>
                                      </div>
									  <div class="form-group">
                                          <label for="exampleInputPassword1">Message</label>
                                          <textarea class="form-control" rows="8" name="msg" id="comment" required></textarea>
                                      </div>
									   <div class="text-right">
                                           <button type="submit" name="gerer" value="envoyer" class="btn btn-info">Envoyer</button>
									   </div>
                                  </form> 
                            
                        </div>
                    </div>
					<div class="col-md-6">
					
					</div>
                </div>
            </div>

        </div>
    <div class="footer-area">
            <div class="container">
                <div class="row footer">
                    <div class="col-md-4">
                        
                    </div>
                    <div class="col-md-4">
                        <div class="single-footer">
                           
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="single-footer">
                            <h4>Menu</h4>
                            <div class="footer-links">
                                <ul class="list-unstyled"> 
                                    <li><a href="" class="active">ACCUEIL</a></li>
                                    <li><a href="">ENVOYER UN COLIS</a></li>
                                    <li><a href="">CONNEXION</a></li>
                                    <li><a href="">CONTACT</a></li> 
                                </ul>
                            </div>
                        </div>
                    </div>
                </div> 
                    <p><span>(C) All rights reserved</span> <a href="#"></a></span> </p>
                </div>
            </div>
        </div>
		
		
		
		
		
        	
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.10.2.min.js"><\/script>')</script>
        <script src="js/sbootstrap.min.js"></script>
        <script src="js/sowl.carousel.min.js"></script>
        <script src="js/swow.js"></script>
        <script src="js/smain.js"></script>
    </body>
</html>
