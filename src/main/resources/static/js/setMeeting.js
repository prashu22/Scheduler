<script type="text/javascript">
var start_time;
var end_time;
var list=[];

function checkStart() {
    if(list.length!=0)
    {
    if (confirm('Are you sure this will delete all added member')) {
    list.length=0;
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

    var timing={
        "stDate":start_time,
        "edDate":end_time
    };
    $("#add").click(function(){
    var m=$('#member').val();
    if (!start_time && !end_time) {
    alert("Enter Valid Timing");
    }
    else if(m=="")
    {
        alert("Enter Email");
    }
    else{
    var timing = JSON.stringify({
            'timing':timing
        });


    $.ajax({
            url: "/check/"+m,
            type: 'POST',
            data:  timing,
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
    });

    $("#set").click(function(){
        var Meeting = JSON.stringify({
            'hostId':"Prashu1996@gmail.com",
            'list' : list,
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
        });

});

</script>