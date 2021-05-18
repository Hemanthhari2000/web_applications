function validate_creditcard()
{
	var current=new Date();
	var mon=current.getMonth();
	var yr=current.getFullYear();
	var name=document.getElementById("name1").value;
	var num=document.getElementById("num").value;
	var id=document.getElementById("mail1").value;
	var cvv=document.getElementById("cvv").value;
	var exp_mon=document.getElementById("mon").value;
	var exp_yr=document.getElementById("yr").value;

	var pattern_name=/^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/;
	var pattern_cvv=/^\d{3}$/;
	var pattern_mail=/^\w+@[a-zA-Z_]+?(\.[a-zA-Z]{2,3})+$/;
    	var pattern_acc=/^\d{16}$/;
document.write("<h1>CREDIT CARD DETILS</h1>");
   	 if(pattern_name.test(name))
document.write("<table><tr><tdstyle='font-weight:bold'>Card Holder's Name</td> <td> "+name+"</td></tr>");
    	else
		window.alert("Ivalid Name");
   	 if(pattern_acc.test(num))
document.write("<tr><td style='font-weight:bold'>Card Number</td><td>"+num+" </td></tr>");
else
		window.alert("Ivalid card Number ");
    	if(pattern_mail.test(id))
document.write("<tr><td style='font-weight:bold'>Email Id</td><td>"+id+"</td> </tr>");
    	else
		window.alert("Invalid Mail Id");
    	if(pattern_cvv.test(cvv))
document.write("<tr><td style='font-weight:bold'>CVV Number</td><td>"+cvv+" </td></tr>");
    	else
		window.alert("Invalid CVV");
	if(exp_yr>=yr){
		if(exp_mon>=mon+1)
document.write("<tr><td style='font-weight:bold'>Card Vlidity</td><td> Month:"+exp_mon+"Year:"+exp_yr+"</td></tr>");
		else{
			window.alert("Card validity Expires");
document.write("<tr><td style='font-weight:bold'>Card Vlidity<td><td> Expired </td></tr>");
		}
    	}
    	else{
            window.alert("Card validity Expires");
            document.write("<tr><td style='font-weight:bold'>Card Vlidity </td><td> Expired</td></tr>");
    	}
}
