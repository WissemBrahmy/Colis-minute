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
                        <p></p>
                        <div class="search-form wow pulse" data-wow-delay="0.8s">
                            <form action="ServletSite" method="post" class=" form-inline">
                            
                                <div class="form-group">
                                    <input type="date" name="date" class="form-control" placeholder="Date Voyage">
                                </div>
                            <div class="form-group">
                                    <select name="depart" id="" class="form-control">
                                        <option selected>Pays Depart</option>
                                        <option value="Tunis">Tunis</option>
										<option value="Monastir">Monsatir</option>
										<option value="Sfax">Sfax</option>
										<option value="Tozeur">Tozeur</option>
										<option value="Djerba">Djerba</option>
										
										
                                    </select>
                                </div>
                                <div class="form-group">
                                    <select name="arrive" id="" class="form-control">
                                        <option selected>Destination</option>
                                        <option value="Paris">Paris</option>
										<option value="Nice">Nice</option>
										<option value="Marseille">Marseille</option>
										<option value="Bordeaux">Bordeaux</option>
										<option value="Toulouse">Toulouse</option>
										
                                    </select>
                                </div>
                                <input type="submit" name="gerer" value="chercher" class="btn" value="Trouvez">


                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    
            <hr>

            <div class="container">
                <div class="row page-title text-center wow bounce"  data-wow-delay="1s">
                    <h5> </h5>
                    <h2><span>VOYAGEURS TROUVES</span></h2>
                </div>
                <div class="row jobs">      
                    <div class="col-md-12">
                        <div class="job-posts table-responsive">
                            <table class="table">
								<tr> 
                                    <th>Destination</th>
                                    <th>Date</th>
                                    <th>Poids</th>
                                    <th>Prix</th>
                                    <th  class="tbl-apply">Action</th>
                                </tr> 
                                <c:forEach var="L" items="${LAA }">
                                <tr class="odd wow fadeInUp" data-wow-delay="1s"> 
                                    <td  class="tbl-title"><h4><i class="icon-location"></i>${L.villedep } - ${L.villearriv }</h4></td>
                                    <td>${L.datedep }</td>
                                    <td>${L.kg } Kg</td>
                                    <td>${L.prix } Dt</td>
                             
                                    <td  class="tbl-apply"><a href="ServletSite?gerer=SendDMD&id=${L.id }">Envoyer Demande</a></td>
                                </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                     
                </div>
            </div>
            <hr>

            
        </div>
      <div class="footer-area">
            <div class="container">
                <div class="row footer">
                    <div class="col-md-4">
                        <div class="single-footer">
                           
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Obcaecati architecto quaerat facere blanditiis tempora sequi nulla accusamus, possimus cum necessitatibus suscipit quia autem mollitia, similique quisquam molestias. Vel unde, blanditiis.</p>
                        </div>
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
	<script>window.jQuery || document.write('<script src="js/vendor/jquery.geocomplete.min.js"><\/script>')</script>
        <script src="js/sbootstrap.min.js"></script>
        <script src="js/sowl.carousel.min.js"></script>
        <script src="js/swow.js"></script>
        <script src="js/smain.js"></script>
    </body>
</html>
