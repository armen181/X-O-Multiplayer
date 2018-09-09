var x = 0;
var y = 0;
var side = 0;
var sideTemp = 0;
var sessionId = "";
var gameId = "";
$(document).ready(function () {


    $("#btn00,#btn01,#btn02,#btn10,#btn11,#btn12,#btn20,#btn21,#btn22").click(function () {
        x = $(this).attr("x");
        y = $(this).attr("y");
        var settings = {
            "async": true,
            "crossDomain": true,
            "url": "set",
            "method": "POST",
            "headers": {
                "x": x,
                "y": y,
                "id": gameId,
                "sessionId": sessionId
            }
        }
            $.ajax(settings).done(function (response) {
            console.log(response);
            sideTemp=response.side;
            update(response);

        });


    });



    $("#start1").click(function () {
        $('#inputFormForStart').modal({
            backdrop: 'static',
            keyboard: false
        }, 'show');

    });


    $("#start2").click(function () {
        $('#inputFormForJoin').modal({
            backdrop: 'static',
            keyboard: false
        }, 'show');

    });

    $("#btnForStart").click(function () {
        var settings = {
            "async": true,
            "crossDomain": true,
            "url": "startGame",
            "method": "POST",
            "headers": {
                "name": $("#name").val()
            }
        }
        $.ajax(settings).done(function (response) {
             console.log(response);
             side = 1;
             gameId=response.idForFirst;
             sessionId=response.sessionId;
             $('#inputFormForStart').modal('hide');
             $('#writeSessionId').val(response.sessionId);
        });


    });

    $("#btnForJoin").click(function () {
        var settings = {
            "async": true,
            "crossDomain": true,
            "url": "joinGame",
            "method": "POST",
            "headers": {
                "sessionId": $("#sessionId").val(),
                "name": $("#nameForJoin").val()
            }
        }
        $.ajax(settings).done(function (response) {
            console.log(response);
            side = 2;
            sessionId=response.sessionId;
            gameId=response.idForSecond;
            $('#inputFormForJoin').modal('hide');
            $('#writeSessionId').val(response.sessionId);
        });


    });

    setInterval(function(){

        if(side!=sideTemp&&side!=0) {
                var settings = {
                    "async": true,
                    "crossDomain": true,
                    "url": "get",
                    "method": "POST",
                    "headers": {
                        "sessionId": sessionId,
                        "id": gameId
                    }
                }
                $.ajax(settings).done(function (response) {
                    if(response!=null){
                        console.log(response);
                        update(response);
                        sideTemp=response.side;

                    }
                });

        }

    }, 3000);

});
function update(response) {
    for(var i=0;i<3;i++){
        for(var j=0;j<3;j++){
            if(response.game[i][j].value == 1) {
                var id = "#btn" + j + i;
                $(id).text(response.game[i][j].side==1?"X":"O");
            }else {
                var id = "#btn" + j + i;
                $(id).text("");
            }

        }
    }
}