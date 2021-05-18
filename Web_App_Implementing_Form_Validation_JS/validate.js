function validate()
{
var name=document.getElementById("name").value;
var rol=document.getElementById("roll").value;
var reg=document.getElementById("regno").value;
var dep=document.getElementById("dept").value;
var db=document.getElementById("dob").value;
var mail=document.getElementById("mail").value;
var sem1=document.getElementById("sem1");
var sem2=document.getElementById("sem2");
var sem3=document.getElementById("sem3");
var sem4=document.getElementById("sem4");
var sem5=document.getElementById("sem5");
var sem6=document.getElementById("sem6");
var sem7=document.getElementById("sem7");
var sem8=document.getElementById("sem8");
var sub1=document.getElementById("gt");
var sub2=document.getElementById("gis");
var sub3=document.getElementById("evs");
var pattern_name=/^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/;
var pattern_roll=/^\d{2}[A-Z]{2}\d{3}$/i;
var pattern_reg=/^[3123]\d{11}$/;
var pattern_mail=/^\w+@[a-zA-Z_]+?(\.[a-zA-Z]{2,3})+$/;
document.write("<h1>STUDENT DETAILS</h1>");
if(pattern_name.test(name))
document.write("<table><tr><td style='font-weight:bold;'>Student Name</td><td> "+name+"</td></tr>");
else
		window.alert("Ivalid Name Format");
        if(pattern_roll.test(rol))
        document.writeln("<tr><td style='font-weight:bold;'>Roll Number</td><td> "+rol+" </td></tr>");
        else
                window.alert("Invalid Roll number Format");
        if(pattern_reg.test(reg))
        document.write("<tr><td style='font-weight:bold;'>Register Number</td><td>"+reg+" </td></tr>");
        else
                window.alert("Invalid Register Number Format");
        document.write("<tr><td style='font-weight:bold;'>Department</td><td>"+dep+"</td>	</tr>");
        document.write("<tr><td style='font-weight:bold;'>Date of Birth</td><td>"+db+"</td>	</tr>");
        if(pattern_mail.test(mail))
        document.write("<tr><td style='font-weight:bold;'>Email Id</td><td>"+mail+"</td> </tr>");
        else
                window.alert("Invalid Mail Id format");
        var sem;
        if(sem1.checked)
                sem=sem1.value;
        if(sem2.checked)
                sem=sem2.value;
        if(sem3.checked)
                sem=sem3.value;
        if(sem4.checked)
                sem=sem4.value;
        if(sem5.checked)
                sem=sem5.value;
        if(sem6.checked)
                sem=sem6.value;
        if(sem7.checked)
                sem=sem7.value;
        if(sem8.checked)
                sem=sem8.value;
        document.write("<tr><td style='font-weight:bold;'>Semester</td><td>"+sem+"</td></tr>");
        document.write("<tr><td style='font-weight:bold;'>Interest Subject</td>");
if(sub1.checked)
		document.write("<td style='font-weight:bold;'>"+sub1.value+"</td></tr>");
if(sub2.checked)
document.write("<tr><td></td><td style='font-weight:bold;'>"+sub2.value+" </td> </tr>");
if(sub3.checked)
		document.write("<tr><td></td><td style='font-weight:bold;'>"+sub3.value+
"</td> </tr>");
document.write("</table>");
}
