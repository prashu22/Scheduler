var user=JSON.parse(localStorage.getItem("user"));
var meetings=[];
uEmail=localStorage.getItem("email");
$(document).ready(function(){
        $.ajax({
                async: false,
                url: "/getMeeting?email="+uEmail,
                type: 'POST',
                dataType: "json",
                contentType: 'application/json',
                mimeType: 'application/json',
                success: function(response)
                {
                tbl = document.getElementById("meet-body");
                tbl.innerHTML = "";
                response.forEach(function(data) {
                    let row = document.createElement("tr");
                    var stDate=data.timing.stDate;
                    var edDate=data.timing.edDate;
                    cell = document.createElement("td");
                    cellText = document.createTextNode(data.hostId);
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    cell = document.createElement("td");
                    cellText = document.createTextNode(stDate);
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    cell = document.createElement("td");
                    cellText = document.createTextNode(edDate);
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    tbl.appendChild(row);
                 });

                 }

               });
       });
