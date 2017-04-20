var room = null;
var required_action = null;

$(function(){
    var webSocket = new WebSocket(
        'ws://localhost:8080/CAH_WS/websocket');
    initWebSocket(webSocket);
    $('input[type=submit]').bind('click',function(){
        webSocket.send($('#userinput').val());

    });
    $('#envoyer_alias').bind('click',function(){
        webSocket.send($('#userinput').val());
    });
    $('#messages').on('click','#envoyer_alias',function(){
        webSocket.send("_alias "+$('#alias_field').val());
        $('#messages').empty();
    });
});