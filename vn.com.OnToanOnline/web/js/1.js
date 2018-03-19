$(document).ready(function () {

    //Scroll TOp event
    $(window).scroll(function () {
        var menu = document.getElementById("section_menu");
        if ($(window).scrollTop() > 0) {

            menu.style.position = 'fixed';
            menu.style.width = '100%';
            menu.style.zIndex = '1';
            menu.style.top = "0";

        } else {
            menu.style.position = 'inherit';
        }
    });
    $(".div_header_footer").click(function () {

        $("html,body").animate({scrollTop: 600}, 'slow');

    });

});