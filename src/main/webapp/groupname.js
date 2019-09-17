
var div = document.getElementById("div");
let url = "https://shpat.dk/CA1/api/students/all";
fetch(url)
        .then(res => res.json()) //in flow1, just do it
        .then(data => {
            // Inside this callback, and only here, the response data is available
            console.log("data", data);
            var head = "<tr><th>id</th><th>name</th><th>color</th></tr>";
            var td = data.map(obj => {
                var str = "";
                for (var p in obj) {
                    str += "<td>" + obj[p] + "</td>" + "\r";
                }
                return "<tr>" + str + "</tr>";
            });
            data = td.join('');
            div.innerHTML = "<table class=\"table-striped\">" + head.concat(data) + "</table>";

          
        });

