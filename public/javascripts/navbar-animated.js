$(function () {
    var navbar = $(".js-navbar-animated");

    var toggleAnimatedClass = function(){
         var windowWidth = $(window).width(),
             screenXsMax = 767;

         if(windowWidth <= screenXsMax){
            navbar.removeClass("navbar-animated");
         }
         else{
            navbar.addClass("navbar-animated");
         }
    };

    var resizeNavbar = function() {
        var distanceY = window.pageYOffset || document.documentElement.scrollTop,
            shrinkOn = 300;

        if (distanceY > shrinkOn) {
            navbar.addClass("navbar-animated-small");
        } else {
            if (navbar.hasClass("navbar-animated-small")) {
                navbar.removeClass("navbar-animated-small");
            }
        }
    };

    window.addEventListener('scroll', function(e){
        resizeNavbar();
    });

     window.addEventListener('resize', function(e){
        toggleAnimatedClass();
     });

    toggleAnimatedClass();
    resizeNavbar();
});