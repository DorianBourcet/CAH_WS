var room = null;
var required_action = null;

$(function(){
    var webSocket = new WebSocket(
        'ws://localhost:8080/CAH_WS/websocket');
    initWebSocket(webSocket);
    
    $('#login').on('click',function(){
        webSocket.send("LOGIN "+$('#user').val()+" "+$('#pass').val());
        $('#user').empty();
        $('#pass').empty();
    });
    $('#sndMessage').on('click',function(){
        var cmd = $('#someMessage').val().split(" ");
        console.log(cmd[0]+" "+cmd[1]+" "+cmd[2]);
        webSocket.send(cmd[0]+" "+cmd[1]+" "+cmd[2]);
        $('#user').empty();
        $('#pass').empty();
    });
});