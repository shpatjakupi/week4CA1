var div = document.getElementById("div");
let url = "http://localhost:8080/CA1/api/joke/all";
fetch(url)
        .then(res => res.json()) //in flow1, just do it
        .then(data => {
            // Inside this callback, and only here, the response data is available
            console.log("data", data);
            var head = "<tr><th>id</th><th>joke</th><th>reference</th><th>type</th></tr>";
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
