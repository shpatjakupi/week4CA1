<<<<<<< HEAD

var groupName = [
    {Name: 'Talha', Student_Id: 1, Color: 'green'},
    {Name: 'Henrik', Student_Id: 2, Color: 'green'},
    {Name: 'John', Student_Id: 3, Color: 'yellow'},
    {Name: 'Younes', Student_Id: 4, Color: 'yellow'},
];
function writeTable(arr) {
    var out = "<table class='table'>";
    out += "<thead>"
            + "<tr>"
            + "<th>Name</th>"
            + "<th>Student_Id</th>"
            + "<th>Color</th>"
            + "</tr>"
            + "</thead>";
    out += arr.map(function (item) {
        return "<tr>"
                + "<td>" + item.Name + "</td>"
                + "<td>" + item.Student_Id + "</td>"
                + "<td>" + item.Color + "</td>"
                + "</tr>";


    }).join('');
    out += "</table>";
    document.getElementById("d1").innerHTML = out;
}
writeTable(groupName);

document.getElementById("btn").onclick = removeBot;
function removeBot(e) {
    e.preventDefault();
    var carsout = groupName.filter(function (item) {
        if (item.price < document.getElementById("in").value)
            return item;
        return 0;
    });
    writeTable(carsout);
}
=======
//
//console.log("hohohohoi");
//
//var groupName = [
//  { Name: 'Talha', Student_Id: 1, Color: 'green' },
//  { Name: 'Henrik', Student_Id: 2, Color: 'green' },
//  { Name: 'John', Student_Id: 3, Color: 'yellow' },
//  { Name: 'Younes', Student_Id: 4, Color: 'yellow' },
//];
//function writeTable(arr){
//var out = "<table class='table'>";
//  out += "<thead>"
//      +"<tr>"
//        +"<th>Name</th>"
//        +"<th>Student_Id</th>"
//        +"<th>Color</th>"
//      +"</tr>"
//    +"</thead>";
//out +=arr.map(function(item){
//        return "<tr>"
//         +"<td>" + item.Name + "</td>"
//         +"<td>" + item.Student_Id + "</td>"
//         +"<td>" + item.Color + "</td>"
//         +"</tr>";
//
//    
//}).join('');
//out+="</table>";
//document.getElementById("root").innerHTML = "HIHIHIHIHIHIHIHIHIHIHIH";
//
//writeTable(groupName);
//
//document.getElementById("btn").onclick = removeBot;
//function removeBot(e) {
//    e.preventDefault();
//   var carsout =groupName.filter(function (item){
//       if(item.price < document.getElementById("in").value) return item;
//       return 0;
//   });
//    writeTable(carsout);
//}
//
>>>>>>> 4c8e6620fd5174227128cec8e863875b48015fbb

