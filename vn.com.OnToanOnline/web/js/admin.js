/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(window).ready(function() {
    $("ul li").click(function() {
        $("ul li").removeClass("active");
        $(this).addClass("active");
    });


    $("a#dashboard").click(function(){
    	$("section#listed_number").show();
    	$("section#profile").hide();
    	$("section#feedback").hide();
    	$("section#activities").hide();
    	$("section#notification").hide();
    	$("section#tableList").hide();

    });
    $("a#profile").click(function(){
    	$("section#listed_number").hide();
    	$("section#profile").show();
    	$("section#feedback").hide();
    	$("section#activities").hide();
    	$("section#notification").hide();
    	$("section#tableList").hide();

    });
    $("a#tableList").click(function(){
    	$("section#listed_number").hide();
    	$("section#profile").hide();
    	$("section#feedback").hide();
    	$("section#activities").hide();
    	$("section#notification").hide();
    	$("section#tableList").show();

    });
    $("a#feedback").click(function(){
    	$("section#listed_number").hide();
    	$("section#profile").hide();
    	$("section#feedback").show();
    	$("section#activities").hide();
    	$("section#notification").hide();
    	$("section#tableList").hide();

    });
    $("a#activities").click(function(){
    	$("section#listed_number").hide();
    	$("section#profile").hide();
    	$("section#feedback").hide();
    	$("section#activities").show();
    	$("section#notification").hide();
    	$("section#tableList").hide();

    });
    $("a#notification").click(function(){
    	$("section#listed_number").hide();
    	$("section#profile").hide();
    	$("section#feedback").hide();
    	$("section#activities").hide();
    	$("section#notification").show();
    	$("section#tableList").hide();

    });
});