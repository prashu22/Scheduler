var start_time;
var end_time;
var list=[];

function checkStart() {
    if(list.length!=0)
    {
    if (confirm('Are you sure this will delete all added member')) {
    list.length=0;
    $("p").empty();
    start_time = $("#stMeeting").val();
    }
    else
    {
    $("#stMeeting").val(start_time);
    }
  }
  else{
  start_time = $("#stMeeting").val();
  }
}
function checkEnd() {

    if(list.length!=0)
    {
    if (confirm('Are you sure this will delete all added member')) {
    list.length=0;
    $("p").empty();
    end_time = $("#edMeeting").val();
    }
    else
    {
    $("#edMeeting").val(end_time);
    }
  }
  else{
  end_time = $("#edMeeting").val();
  }
}

$(document).ready(function(){

    $("#add").click(function(){

        var timing={
            "stDate":$("#stMeeting").val(),
            "edDate":$("#edMeeting").val()
         };
        var m=$('#member').val();
        if (!start_time && !end_time) {alert("Enter Valid Timing");}

        else if(m=="")  {alert("Enter Email"); }

        else if(list.includes(m))   {alert("Already included");}

        else{
        $.ajax({
            url: "/check/"+m,
            type: 'POST',
            data:  JSON.stringify(timing),
            dataType: "json",
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function(data){
            if(data==true)
            {
                $("p").append("<ol>"+m+"</ol>");
                list.push(m);
            }
            else
            {
                alert("He is not available");
            }
            }
            });
        }
        $('#member').val("");
    });

    $("#set").click(function(){

        if (!start_time && !end_time) {
        alert("Enter Valid Timing");
        }
        else if(list.length<2)
        {
        alert("Enter atleast two member");
        }
        else{
        var timing={
            "stDate":$("#stMeeting").val(),
            "edDate":$("#edMeeting").val()
        };


        var Meeting = JSON.stringify({
            'hostId': localStorage.getItem("email"),
            'members' : list,
            'timing':timing
        });
        $.ajax({
            url: "/set_meeting",
            type: 'POST',
            data:  Meeting,
            dataType: "html",
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function(){
                alert("Successfully Set Meeting");
                
            }
        });
        }
        });

});