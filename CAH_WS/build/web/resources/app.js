/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$('#Login-modal').modal({
    backdrop: "static",
    show: false
});
$('#toggle').on('click', function(){
    $('#pass').css("border-color", "rgba(0, 0, 0, 0.14902)");
    $('#subscribe').toggleClass('invis');
    $('#login').toggleClass('invis');
    $('#forgot').toggleClass('invis');
    $('#email_field').toggleClass('invis');
    if($('#toggle').val() === "S'inscrire") {
        $('#toggle').val("Se connecter");
        $('#modal_title').html("Sign up");
    }
    else {
        $('#toggle').val("S'inscrire");
        $('#modal_title').html("Sign in");
    }
});
$('#forgot').on('click', function(){
    $('#toggle').toggleClass('invis');
    $('#login').toggleClass('invis');
    $('#usr').toggleClass('invis');
    $('#psw').toggleClass('invis');
    $('#send').toggleClass('invis');
    $('#email_field').toggleClass('invis');
    if($('#forgot').val() === "Forgot password") {
        $('#forgot').val("Se connecter");
        $('#modal_title').html("Forgot password");
    }
    else{
        $('#forgot').val("Forgot password");
        $('#modal_title').html("Sign in");
    }
});
$('.screen').animate({scrollTop: $('.screen').prop("scrollHeight") - $('.screen').height() });