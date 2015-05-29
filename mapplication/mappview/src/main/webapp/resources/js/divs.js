function readCookie(str) {
    var allcookies = document.cookie;
    cookiearray = allcookies.split(';');
    for (var i = 0; i < cookiearray.length; i++) {
        name = cookiearray[i].split('=')[0];
        value = cookiearray[i].split('=')[1];
        if (name === str) {
            return value;
        }
        return "";
    }
}
;

function showDivs(value) {
    var v = parseInt(value);
    switch (v) {
        case 1:
        {
            document.getElementById('album1').style.display = "block";
            break;
        }
        case 2:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            break;
        }
        case 3:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            break;
        }
        case 4:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            document.getElementById('album4').style.display = "block";
            break;
        }
        case 5:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            document.getElementById('album4').style.display = "block";
            document.getElementById('album5').style.display = "block";
            break;
        }
        case 6:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            document.getElementById('album4').style.display = "block";
            document.getElementById('album5').style.display = "block";
            document.getElementById('album6').style.display = "block";
            break;
        }
        case 7:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            document.getElementById('album4').style.display = "block";
            document.getElementById('album5').style.display = "block";
            document.getElementById('album6').style.display = "block";
            document.getElementById('album7').style.display = "block";
            break;
        }
        case 8:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            document.getElementById('album4').style.display = "block";
            document.getElementById('album5').style.display = "block";
            document.getElementById('album6').style.display = "block";
            document.getElementById('album7').style.display = "block";
            document.getElementById('album8').style.display = "block";
            break;
        }
        case 9:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            document.getElementById('album4').style.display = "block";
            document.getElementById('album5').style.display = "block";
            document.getElementById('album6').style.display = "block";
            document.getElementById('album7').style.display = "block";
            document.getElementById('album8').style.display = "block";
            document.getElementById('album9').style.display = "block";
            break;
        }
        case 10:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            document.getElementById('album4').style.display = "block";
            document.getElementById('album5').style.display = "block";
            document.getElementById('album6').style.display = "block";
            document.getElementById('album7').style.display = "block";
            document.getElementById('album8').style.display = "block";
            document.getElementById('album9').style.display = "block";
            document.getElementById('album10').style.display = "block";
            break;
        }

         case 11:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            document.getElementById('album4').style.display = "block";
            document.getElementById('album5').style.display = "block";
            document.getElementById('album6').style.display = "block";
            document.getElementById('album7').style.display = "block";
            document.getElementById('album8').style.display = "block";
            document.getElementById('album9').style.display = "block";
            document.getElementById('album10').style.display = "block";
            document.getElementById('album11').style.display = "block";
            break;
        }
        
         case 12:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            document.getElementById('album4').style.display = "block";
            document.getElementById('album5').style.display = "block";
            document.getElementById('album6').style.display = "block";
            document.getElementById('album7').style.display = "block";
            document.getElementById('album8').style.display = "block";
            document.getElementById('album9').style.display = "block";
            document.getElementById('album10').style.display = "block";
            document.getElementById('album11').style.display = "block";
            document.getElementById('album12').style.display = "block";
            break;
        }
        
         case 13:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            document.getElementById('album4').style.display = "block";
            document.getElementById('album5').style.display = "block";
            document.getElementById('album6').style.display = "block";
            document.getElementById('album7').style.display = "block";
            document.getElementById('album8').style.display = "block";
            document.getElementById('album9').style.display = "block";
            document.getElementById('album10').style.display = "block";
            document.getElementById('album11').style.display = "block";
            document.getElementById('album12').style.display = "block";
            document.getElementById('album13').style.display = "block";
            break;
        }
        
         case 14:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            document.getElementById('album4').style.display = "block";
            document.getElementById('album5').style.display = "block";
            document.getElementById('album6').style.display = "block";
            document.getElementById('album7').style.display = "block";
            document.getElementById('album8').style.display = "block";
            document.getElementById('album9').style.display = "block";
            document.getElementById('album10').style.display = "block";
            document.getElementById('album11').style.display = "block";
            document.getElementById('album12').style.display = "block";
            document.getElementById('album13').style.display = "block";
            document.getElementById('album14').style.display = "block";
            break;
        }
        
         case 15:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            document.getElementById('album4').style.display = "block";
            document.getElementById('album5').style.display = "block";
            document.getElementById('album6').style.display = "block";
            document.getElementById('album7').style.display = "block";
            document.getElementById('album8').style.display = "block";
            document.getElementById('album9').style.display = "block";
            document.getElementById('album10').style.display = "block";
            document.getElementById('album11').style.display = "block";
            document.getElementById('album12').style.display = "block";
            document.getElementById('album13').style.display = "block";
            document.getElementById('album14').style.display = "block";
            document.getElementById('album15').style.display = "block";
            break;
        }
        
         case 16:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            document.getElementById('album4').style.display = "block";
            document.getElementById('album5').style.display = "block";
            document.getElementById('album6').style.display = "block";
            document.getElementById('album7').style.display = "block";
            document.getElementById('album8').style.display = "block";
            document.getElementById('album9').style.display = "block";
            document.getElementById('album10').style.display = "block";
            document.getElementById('album11').style.display = "block";
            document.getElementById('album12').style.display = "block";
            document.getElementById('album13').style.display = "block";
            document.getElementById('album14').style.display = "block";
            document.getElementById('album15').style.display = "block";
            document.getElementById('album16').style.display = "block";
            break;
        }
         case 17:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            document.getElementById('album4').style.display = "block";
            document.getElementById('album5').style.display = "block";
            document.getElementById('album6').style.display = "block";
            document.getElementById('album7').style.display = "block";
            document.getElementById('album8').style.display = "block";
            document.getElementById('album9').style.display = "block";
            document.getElementById('album10').style.display = "block";
            document.getElementById('album11').style.display = "block";
            document.getElementById('album12').style.display = "block";
            document.getElementById('album13').style.display = "block";
            document.getElementById('album14').style.display = "block";
            document.getElementById('album15').style.display = "block";
            document.getElementById('album16').style.display = "block";
            document.getElementById('album17').style.display = "block";
            break;
        }
        
         case 18:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            document.getElementById('album4').style.display = "block";
            document.getElementById('album5').style.display = "block";
            document.getElementById('album6').style.display = "block";
            document.getElementById('album7').style.display = "block";
            document.getElementById('album8').style.display = "block";
            document.getElementById('album9').style.display = "block";
            document.getElementById('album10').style.display = "block";
            document.getElementById('album11').style.display = "block";
            document.getElementById('album12').style.display = "block";
            document.getElementById('album13').style.display = "block";
            document.getElementById('album14').style.display = "block";
            document.getElementById('album15').style.display = "block";
            document.getElementById('album16').style.display = "block";
            document.getElementById('album17').style.display = "block";
            document.getElementById('album18').style.display = "block";
            break;
        }
        
         case 19:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            document.getElementById('album4').style.display = "block";
            document.getElementById('album5').style.display = "block";
            document.getElementById('album6').style.display = "block";
            document.getElementById('album7').style.display = "block";
            document.getElementById('album8').style.display = "block";
            document.getElementById('album9').style.display = "block";
            document.getElementById('album10').style.display = "block";
            document.getElementById('album11').style.display = "block";
            document.getElementById('album12').style.display = "block";
            document.getElementById('album13').style.display = "block";
            document.getElementById('album14').style.display = "block";
            document.getElementById('album15').style.display = "block";
            document.getElementById('album16').style.display = "block";
            document.getElementById('album17').style.display = "block";
            document.getElementById('album18').style.display = "block";
            document.getElementById('album19').style.display = "block";
            break;
        }
        
         case 20:
        {
            document.getElementById('album1').style.display = "block";
            document.getElementById('album2').style.display = "block";
            document.getElementById('album3').style.display = "block";
            document.getElementById('album4').style.display = "block";
            document.getElementById('album5').style.display = "block";
            document.getElementById('album6').style.display = "block";
            document.getElementById('album7').style.display = "block";
            document.getElementById('album8').style.display = "block";
            document.getElementById('album9').style.display = "block";
            document.getElementById('album10').style.display = "block";
            document.getElementById('album11').style.display = "block";
            document.getElementById('album12').style.display = "block";
            document.getElementById('album13').style.display = "block";
            document.getElementById('album14').style.display = "block";
            document.getElementById('album15').style.display = "block";
            document.getElementById('album16').style.display = "block";
            document.getElementById('album17').style.display = "block";
            document.getElementById('album18').style.display = "block";
            document.getElementById('album19').style.display = "block";
            document.getElementById('album20').style.display = "block";
            break;
        }
        
    }

}
